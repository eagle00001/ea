package com.ea.apps.beans.vo;

import com.ea.apps.beans.BaseBean;


/**
@author:eagle.daiq
@company:iot.chinamobile
@date:2015年7月14日
@description:
 **/
public class BaseResponseResult extends BaseBean {
	private String code;
	private String message;
	private Object data;
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public Object getData() {
		return data;
	}
	public void setData(Object data) {
		this.data = data;
	}
}

