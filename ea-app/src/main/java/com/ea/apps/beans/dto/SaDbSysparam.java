package com.ea.apps.beans.dto;

import java.util.Date;

import com.ea.apps.beans.BaseBean;

/**
@author:eagle.daiq
@company:iot.chinamobile
@date:2015年7月13日
@description:
 **/
public class SaDbSysparam extends BaseBean {
	private static final long serialVersionUID = 3869558604195719167L;
	private String paramId;
	private String paramName;
	private String paramValue;
	private Date createDate;
	private String paramBelong;
	
	public String getParamId() {
		return paramId;
	}
	public void setParamId(String paramId) {
		this.paramId = paramId;
	}
	public String getParamName() {
		return paramName;
	}
	public void setParamName(String paramName) {
		this.paramName = paramName;
	}
	public String getParamValue() {
		return paramValue;
	}
	public void setParamValue(String paramValue) {
		this.paramValue = paramValue;
	}
	public Date getCreateDate() {
		return createDate;
	}
	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}
	public String getParamBelong() {
		return paramBelong;
	}
	public void setParamBelong(String paramBelong) {
		this.paramBelong = paramBelong;
	}
	

}

