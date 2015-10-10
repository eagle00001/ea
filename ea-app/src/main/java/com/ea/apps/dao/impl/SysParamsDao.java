package com.ea.apps.dao.impl;

import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import com.ea.apps.beans.dto.SaDbSysparam;
import com.ea.apps.common.BaseSqlSessionTemplate;
import com.ea.apps.dao.IsysParamsDao;

/**
@author:eagle.daiq
@company:iot.chinamobile
@date:2015年7月13日
@description:
 **/
@Repository
public class SysParamsDao extends BaseSqlSessionTemplate implements IsysParamsDao {
	
	@Autowired
	public SysParamsDao(@Qualifier("sqlSessionFactory")SqlSessionFactory sqlSessionFactory) {
		super(sqlSessionFactory);
	}
	
	protected static String FIND_SYSPARAMS_BY_ID = "SYS-PARAMS.findSysParamsById";
	
	public SaDbSysparam findSysParamsById(String sysParamsId){
		return this.selectOne(FIND_SYSPARAMS_BY_ID, sysParamsId);
	}
	
}

