package com.ea.apps.common;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionTemplate;

/**
@author:eagle.daiq
@company:iot.chinamobile
@date:2015年7月13日
@description:
 **/
public class BaseSqlSessionTemplate extends SqlSessionTemplate {

	public BaseSqlSessionTemplate(SqlSessionFactory sqlSessionFactory) {
		super(sqlSessionFactory);
	}
}

