package com.ea.apps.common;

import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.math.NumberUtils;

/**
 * 参数业务逻辑校验
 *
 * @author:eagle.daiq
 * @company:iot.chinamobile
 * @date:2015年7月14日
 * @description:
 */
public class ParamChecker {
    public static final String PARAM_NOT_NULL_TIPS = "param [%s] is null";
    public static final String PARAM_NOT_NUMBER = "param [%s] must be number";
    public static final String PARAM_OVER_MAXLENGTH = "param [%s] maxlength is ";

    boolean isValid = true;
    String checkResult;

    public static ParamChecker newInstance() {
        return new ParamChecker();
    }

    public boolean isValid() {
        return this.isValid;
    }

    public boolean isNotValid() {
        return !isValid();
    }

    public void setValid(boolean valid) {
        this.isValid = valid;
    }

    //非空检查
    public ParamChecker notBlankCheck(String paramName, String paramVal) {
        if (!isValid())
            return this;
        if (StringUtils.isBlank(paramVal)) {
            this.checkResult = String.format(PARAM_NOT_NULL_TIPS, paramName);
            this.setValid(false);
        }
        return this;
    }

    //数字类型检查
    public ParamChecker notNumberCheck(String paramName, String paramVal) {
        if (!isValid())
            return this;
        if (!NumberUtils.isNumber(paramVal)) {
            this.checkResult = String.format(PARAM_NOT_NUMBER, paramName, paramVal);
            this.setValid(false);
        }
        return this;
    }

    //检验IP是否合法
    public ParamChecker notIpCheck(String paramName, String paramVal) {
        if (!isValid()) {
            return this;
        }
        String rexp = "([1-9]|[1-9]\\d|1\\d{2}|2[0-4]\\d|25[0-5])(\\.(\\d|[1-9]\\d|1\\d{2}|2[0-4]\\d|25[0-5])){3}";
        if (StringUtils.isNotEmpty(paramVal) && !paramVal.matches(rexp)) {
            this.checkResult = String.format(PARAM_NOT_NUMBER, paramName, paramVal);
            this.setValid(false);
        }
        return this;
    }

    //长度检查
    public ParamChecker paramLengthCheck(String paramName, String paramVal, int length) {
        if (!isValid())
            return this;
        if (StringUtils.isNotEmpty(paramVal) && length < paramVal.length()) {
            this.checkResult = String.format(PARAM_OVER_MAXLENGTH, paramName) + length;
            this.setValid(false);
        }
        return this;
    }

    public String getCheckResult() {
        return this.checkResult;
    }

}

