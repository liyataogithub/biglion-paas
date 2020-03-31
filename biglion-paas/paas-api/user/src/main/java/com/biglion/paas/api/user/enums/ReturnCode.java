package com.biglion.paas.api.user.enums;

import lombok.AllArgsConstructor;

/**
 * @author DaoDao
 */

@AllArgsConstructor
public enum ReturnCode {

    /*系统级成功*/
    SUCCESS("0000", "响应成功"),

    /*业务调用级*/
    PUBLIC_PARAM_ERROR("0001", "公共参数错误"),
    REQUEST_PARAM_ERROR("0002", "业务参数错误"),
    NO_SUCH_SERVICE("0003", "没有此项服务"),
    SERVICE_DISABLED("0004", "服务已禁用"),
    CHECKER_ACTUATOR_ERROR("0005", "校验执行器不可用"),
    SERVICE_ACTUATOR_ERROR("0006", "服务执行器不可用"),
    REQUEST_PARAM_NOT_NULL("0007", "请求参数不可为空"),
    REQUEST_PARAM_FORMAT_ERROR("0008", "请求参数格式错误"),

    /*系统失败*/
    ERROR("9999", "系统异常"),
    ;

    /**
     * 返回编码
     */
    public final String code;

    /**
     * 返回信息
     */
    public final String message;

    /**
     * get
     *
     * @param code String
     * @return ReturnCode
     */
    public static ReturnCode get(String code) {
        for (ReturnCode returnCode : ReturnCode.values()) {
            if (code.equals(returnCode.code)) {
                return returnCode;
            }
        }
        return null;
    }

}
