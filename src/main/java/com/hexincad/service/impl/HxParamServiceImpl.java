package com.hexincad.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.hexincad.dao.HxParamDao;
import com.hexincad.entity.HxParam;
import com.hexincad.service.HxParamService;

@Service("HxParamService")
public class HxParamServiceImpl extends BaseServiceImpl<HxParam, Long> implements HxParamService {

@Resource(name="HxParamDaoImpl")
private void setBaseDao(HxParamDao hxParamDao){
	super.setBaseDao(hxParamDao);
}
}
