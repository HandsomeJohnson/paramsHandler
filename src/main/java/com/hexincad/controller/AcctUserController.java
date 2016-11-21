package com.hexincad.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.hexincad.entity.AcctUser;
import com.hexincad.service.AcctUserService;
import com.hexincad.util.JsonUtils;



@Controller
@RequestMapping("/acctuser")
public class AcctUserController extends BaseController {

	@Autowired
	private AcctUserService acctUserService;
	
	@RequestMapping("/list")
	public List<AcctUser> getAcctUserId(String id){
		List<AcctUser> acctuser = acctUserService.findAll();
		System.out.println(acctuser);
		AcctUser acct = acctUserService.find("14ff5253-5912-4a3f-b51b-f50d9da0271d");
		System.out.println(acct);
		System.out.println("------------------------------------------------");
		System.out.println(JsonUtils.toJson(acct));
		return acctuser;
		
	}



}
