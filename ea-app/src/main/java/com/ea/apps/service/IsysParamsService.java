package com.ea.apps.service;

import com.ea.apps.beans.dto.SaDbSysparam;

/**
@author:eagle.daiq
@company:iot.chinamobile
@date:2015年7月13日
@description:
 **/
public interface IsysParamsService {

//	@InterceptorHandler(id="daoMonitor")
	public SaDbSysparam findSysParamsById(String sysParamsId);
}

