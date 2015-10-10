package com.ea.apps.dao;

import com.ea.apps.beans.dto.SaDbSysparam;

/**
@author:eagle.daiq
@company:iot.chinamobile
@date:2015年7月13日
@description:
 **/
public interface IsysParamsDao {

	public SaDbSysparam findSysParamsById(String sysParamsId);
}

