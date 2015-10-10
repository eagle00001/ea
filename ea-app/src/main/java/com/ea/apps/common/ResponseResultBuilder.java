package com.ea.apps.common;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.alibaba.fastjson.JSON;
import com.ea.apps.beans.AppServiceCodeConstants;
import com.ea.apps.beans.vo.BaseResponseResult;
import com.ea.apps.common.utils.LogUtils;

/**
@author:eagle.daiq
@company:iot.chinamobile
@date:2015年7月14日
@description:
 **/
public class ResponseResultBuilder {
	public  final static String SUCCESS = AppServiceCodeConstants.SUCCESS;
    private final static Logger logger = LoggerFactory.getLogger(ResponseResultBuilder.class);

	private static ResponseResultBuilder instance = new ResponseResultBuilder();
	
	public static ResponseResultBuilder getInstance(){
		return instance;
	}
	
	/**
	 * 返回成功信息
	 */
	public String genSuccess2Json(Object data){
		return JSON.toJSONString(buildResponsResult(SUCCESS,"success",data));
	}
	/**
	 * 参数无效信息 
	 */
	public String genParamInvalid2Json(String msg){
		return JSON.toJSONString(buildResponsResult(AppServiceCodeConstants.PARAM_INVALID, msg, null));
	}
	/**
	 * 返回服务信息
	 */
	public String genRespsonResult2Json(String code,String msg,Object data){
		return JSON.toJSONString(buildResponsResult(code, msg, data));
	}
	/**
	 * 系统运行异常信息
	 */
	public String genUnkonwError2Json(Exception e, Class clasz){
		LogUtils.error(clasz, "runtime exception.",e);
		return JSON.toJSONString(buildResponsResult(AppServiceCodeConstants.UNKNOW_ERROR, "system problem," +
                        "please contact administrator!",
                e!=null?e.getMessage():null));
	}
	
	public BaseResponseResult buildResponsResult(String code,String msg,Object data){
        BaseResponseResult rs = new BaseResponseResult();
        try {
            rs = new BaseResponseResult();
            rs.setCode(code);
            rs.setData(data);
            rs.setMessage(msg);
        }catch(Exception e){
            logger.error(e.getMessage());
        }
		return rs;
	}
}

