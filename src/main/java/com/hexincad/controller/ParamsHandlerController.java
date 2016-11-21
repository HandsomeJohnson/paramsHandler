package com.hexincad.controller;

import java.util.HashSet;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.noggit.JSONUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.hexincad.Page;
import com.hexincad.Pageable;
import com.hexincad.entity.HxJob;
import com.hexincad.entity.HxModel;
import com.hexincad.service.HxJobService;
import com.hexincad.service.HxModelService;
import com.hexincad.service.HxParamService;
import com.hexincad.test.HxMsg;
import com.hexincad.util.BeanUtils;
import com.hexincad.util.HttpClientUtils;
import com.hexincad.util.JsonUtils;

@Controller
public class ParamsHandlerController {

	@Autowired
	private SimpMessagingTemplate template;

	@Autowired
	private HxModelService hxModelService;

	@Autowired
	private HxParamService hxParamService;

	@Autowired
	private HxJobService hxJobService;

	/**
	 * 请求路径为/app/hello 因为我们在spring-mvc.xml中配置了websocket拦截前缀为/app的消息
	 * 
	 * @param message
	 * @return
	 */
	@MessageMapping("/hello")
	public String send(String message) {

		System.out.println(message);
		HxMsg hxMsg = JsonUtils.toObject(message, HxMsg.class);
		System.out.println(hxMsg);
		template.convertAndSend("/topic/greetings", hxMsg);
		return null;
	}

	@RequestMapping("/mvc/test")
	public void testA(HttpServletRequest request, HttpServletResponse response, @RequestBody HxMsg hxMsg) {

		/*
		 * template.convertAndSend("/topic/greetings", buf);
		 * template.convertAndSend("/topic/greetings", bytes);
		 */
		template.convertAndSend("/topic/greeting", hxMsg);
	}

	@RequestMapping("/mvc/index")
	public String startModeling() {
		System.out.println("haha,request accepted!!!");
		return "test/myindex";
	}

	@RequestMapping("systemmodel/list")
	@ResponseBody
	public Page<HxModel> getHxModelList(Pageable pageable, String id, String modelname) {
		HxModel queryParam = new HxModel();
		queryParam.setId(id);
		queryParam.setModelname(modelname);
		Page<HxModel> map = hxModelService.findPage(pageable, queryParam);
		// template.convertAndSend("/topic/greeting", map);
		return map;
	}

	@RequestMapping("/systemmodel/modeling")
	public String getHxModelById(Model model, String id) {
		HxModel hxModel = hxModelService.find(id);
		if (hxModel == null) {
			return "index";
		}
		HxJob hxJob = hxJobService.find(new Long(2));
		model.addAttribute("hxJob", hxJob);
		return "modeling/" + id;
	}

	@MessageMapping("/paramschange")
	public void paramsChange(String message) {
		HxJob hxJob = JsonUtils.toObject(message, HxJob.class);
		// 补上参数校验和转发请求
		String url = "http://localhost:8081/httptest/httpclient/getfile";
		String result = HttpClientUtils.httpPostRequest(url);
		template.convertAndSend("/topic/modelacceptor", result);
	}

	@RequestMapping("/job/{id}")
	@ResponseBody
	public HxJob getHxJobById(@PathVariable Long id) {

		return hxJobService.find(id);
	}
}