package com.hexincad.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.hexincad.dao.AcctUserDao;
import com.hexincad.entity.AcctUser;
import com.hexincad.service.AcctUserService;

@Service("AcctUserServiceImpl")
public class AcctUserServiceImpl extends BaseServiceImpl<AcctUser,String> implements AcctUserService {

	@Resource(name="AcctUserDaoImpl")
	public void setBaseDao(AcctUserDao acctUserDao) {
		super.setBaseDao(acctUserDao);
	}
}
