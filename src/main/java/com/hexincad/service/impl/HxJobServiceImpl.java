package com.hexincad.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.hexincad.dao.HxJobDao;
import com.hexincad.entity.HxJob;
import com.hexincad.service.HxJobService;

@Service("HxJobServiceImpl")
public class HxJobServiceImpl extends BaseServiceImpl<HxJob, Long> implements HxJobService {

	@Resource(name="HxJobDaoImpl")
	private void setBaseDao(HxJobDao hxJobDao){
		super.setBaseDao(hxJobDao);
	}

}
