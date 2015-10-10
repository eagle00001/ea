package com.ea.apps.beans;

import java.io.Serializable;

import org.apache.commons.beanutils.BeanUtils;

/**
 * 
@author:eagle.daiq
@company:iot.chinamobile
@date:2015年7月14日
@filename:BaseVo.java
@description:
*
 */
public class BaseBean implements Serializable {
	public String toString() {
        try {
            return BeanUtils.describe(this).toString();
        } catch (Exception e) {
            return super.toString();
        }
    }
}
