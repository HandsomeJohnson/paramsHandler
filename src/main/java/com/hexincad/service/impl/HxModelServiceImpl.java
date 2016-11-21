package com.hexincad.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.hexincad.dao.HxModelDao;
import com.hexincad.entity.HxModel;
import com.hexincad.service.HxModelService;

@Service("HxModelServiceImpl")
public class HxModelServiceImpl extends BaseServiceImpl<HxModel, String> implements HxModelService {

	@Resource(name="HxModelDaoImpl")
	private void setBaseDao(HxModelDao acctUserDao) {
		super.setBaseDao(acctUserDao);
	}
	

}
