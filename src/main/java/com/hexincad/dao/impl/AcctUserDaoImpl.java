package com.hexincad.dao.impl;

import org.springframework.stereotype.Repository;

import com.hexincad.dao.AcctUserDao;
import com.hexincad.entity.AcctUser;

@Repository("AcctUserDaoImpl")
public class AcctUserDaoImpl extends BaseDaoImpl<AcctUser, String> implements AcctUserDao {


}
