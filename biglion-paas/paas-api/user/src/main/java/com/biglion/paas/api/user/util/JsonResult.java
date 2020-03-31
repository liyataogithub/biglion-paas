package com.biglion.paas.api.user.util;

import java.io.Serializable;
import java.net.ConnectException;
import java.sql.SQLException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Copyright: Copyright (c) 2019
 *
 * <p>说明： 用户服务层</P>
 * @version: V1.0
 * @author: BianPeng
 *
 * Modification History:
 * Date         Author         Version         Description
 *---------------------------------------------------------*
 * 2019/4/9 	flying-cattle  V1.0            initialize
 */
public class JsonResult<T> implements Serializable{

    Logger logger = LoggerFactory.getLogger(this.getClass());
    private static final long serialVersionUID = 1071681926787951549L;

    /**
     * <p>返回状态</p>
     */
    private Boolean isTrue=true;
    /**
     *<p> 状态码</p>
     */
    private String code;
    /**
     * <p>业务码</p>
     */
    private String type;
    /**
     *<p> 状态说明</p>
     */
    private String message;
    /**
     * <p>返回数据</p>
     */
    private T data;
    public Boolean getTrue() {
        return isTrue;
    }
    public void setTrue(Boolean aTrue) {
        isTrue = aTrue;
    }
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
    public T getData() {
        return data;
    }
    public void setData(T data) {
        this.data = data;
    }
    public String getType() {
        return type;
    }
    public void setType(String type) {
        this.type = type;
    }
    /**
     * <p>返回成功</p>
     * @param type 业务码
     * @param message 错误说明
     * @param data 数据
     */
    public JsonResult(String type, String message, T data) {
        this.isTrue=true;
        this.code ="0000";
        this.type=type;
        this.message = message;
        this.data=data;
    }
    public JsonResult() {
        this.isTrue=true;
        this.code ="0000";
    }
    public JsonResult(Throwable throwable) {
        logger.error(throwable+"tt");
        this.isTrue=false;
        if(throwable instanceof NullPointerException){
            this.code= "1001";
            this.message="空指针："+throwable;
        }else if(throwable instanceof ClassCastException ){
            this.code= "1002";
            this.message="类型强制转换异常："+throwable;
        }else if(throwable instanceof ConnectException){
            this.code= "1003";
            this.message="链接失败："+throwable;
        }else if(throwable instanceof IllegalArgumentException ){
            this.code= "1004";
            this.message="传递非法参数异常："+throwable;
        }else if(throwable instanceof NumberFormatException){
            this.code= "1005";
            this.message="数字格式异常："+throwable;
        }else if(throwable instanceof IndexOutOfBoundsException){
            this.code= "1006";
            this.message="下标越界异常："+throwable;
        }else if(throwable instanceof SecurityException){
            this.code= "1007";
            this.message="安全异常："+throwable;
        }else if(throwable instanceof SQLException){
            this.code= "1008";
            this.message="数据库异常："+throwable;
        }else if(throwable instanceof ArithmeticException){
            this.code= "1009";
            this.message="算术运算异常："+throwable;
        }else if(throwable instanceof RuntimeException){
            this.code= "1010";
            this.message="运行时异常："+throwable;
        }else if(throwable instanceof Exception){
            logger.error("未知异常："+throwable);
            this.code= "9999";
            this.message="未知异常"+throwable;
        }
    }
}