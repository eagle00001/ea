package com.ea.apps.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ea.apps.beans.dto.SaDbSysparam;
import com.ea.apps.dao.IsysParamsDao;
import com.ea.apps.dao.impl.SysParamsDao;
import com.ea.apps.service.IsysParamsService;
import com.ea.core.aop.InterceptorHandler;

/**
@author:eagle.daiq
@company:iot.chinamobile
@date:2015年7月13日
@description:
 **/
@Service
public class SysParamsService implements IsysParamsService {
	@Autowired
	IsysParamsDao sysParamsDao;

	public IsysParamsDao getSysParamsDao() {
		return sysParamsDao;
	}

	public void setSysParamsDao(SysParamsDao sysParamsDao) {
		this.sysParamsDao = sysParamsDao;
	}
	
	@InterceptorHandler(id="methodProfileProcessMgr")
	public SaDbSysparam findSysParamsById(String sysParamsId){
		return this.sysParamsDao.findSysParamsById(sysParamsId);
	}
}

