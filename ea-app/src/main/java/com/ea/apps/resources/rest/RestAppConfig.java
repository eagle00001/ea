package com.ea.apps.resources.rest;

import org.glassfish.jersey.server.ResourceConfig;
import org.glassfish.jersey.server.spring.scope.RequestContextFilter;

/**
@author:eagle.daiq
@company:iot.chinamobile
@date:2015年7月14日
@description:
 **/
public class RestAppConfig extends ResourceConfig {

	public RestAppConfig() {
		register(RequestContextFilter.class);
//	    packages("cn.iot.m2m.bisserver.resources.rest");
	}
	
}

