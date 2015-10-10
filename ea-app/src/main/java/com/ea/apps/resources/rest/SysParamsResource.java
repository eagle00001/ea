package com.ea.apps.resources.rest;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.ea.apps.beans.dto.SaDbSysparam;
import com.ea.apps.common.ParamChecker;
import com.ea.apps.common.ResponseResultBuilder;
import com.ea.apps.service.IsysParamsService;
import com.ea.core.aop.InterceptorHandler;

/**
@author:eagle.daiq
@company:iot.chinamobile
@date:2015年7月13日
@description:
 **/
@Path("/sys")
@Scope("prototype")
@Component
public class SysParamsResource {
	@Autowired
	IsysParamsService sysParamsService;
	

	@Path("/getSysParams")
	@GET
	@Produces({ MediaType.APPLICATION_JSON }) 
	@InterceptorHandler(id="methodProfileProcessMgr")
	public String getSysPamrams(@QueryParam("sysParamsId") String sysParamsId){
		try {
			//1. parameter check.
			ParamChecker pc = ParamChecker.newInstance().notBlankCheck("sysParamsId", sysParamsId);
			if(pc.isNotValid()){
				//param is invalid.
				return ResponseResultBuilder.getInstance().genParamInvalid2Json(pc.getCheckResult());
			}
			//2. business logic process.
			SaDbSysparam retObj = this.sysParamsService.findSysParamsById(sysParamsId);
			return ResponseResultBuilder.getInstance().genSuccess2Json(retObj);
		} catch (Exception e) {
			//3. runtime exception.
			return ResponseResultBuilder.getInstance().genUnkonwError2Json(e, SysParamsResource.class); 
		}
	}
}

