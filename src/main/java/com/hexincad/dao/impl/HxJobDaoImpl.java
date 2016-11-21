package com.hexincad.dao.impl;

import org.springframework.stereotype.Repository;

import com.hexincad.dao.HxJobDao;
import com.hexincad.entity.HxJob;

@Repository("HxJobDaoImpl")
public class HxJobDaoImpl extends BaseDaoImpl<HxJob, Long> implements HxJobDao {


}
