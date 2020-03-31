package com.biglion.paas.api.user.util;

import com.biglion.paas.api.user.enums.ReturnCode;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * @author DaoDao
 */
@Data
@NoArgsConstructor
public class Response<D> implements Serializable {

    /**
     * 服务端的响应编码
     */
    private String code;

    /**
     * 服务端的响应信息
     */
    private String message;

    /**
     * 服务端的系统编码
     */
    private String system;

    /**
     * 服务端的主机名或 IP
     * 服务端；响应端；Server
     */
    private String host;

    /**
     * 客户端名称
     * 客户端；请求端；Client
     */
    private String client;

    /**
     * 服务端的服务名称
     * 服务端；响应端；Server
     */
    private String service;

    /**
     * 服务端的 API 编码
     */
    private String api;

    /**
     * 链路追踪 ID
     */
    private String trace;

    /**
     * 服务端的响应数据
     */
    private Object  data;


    protected Response(ReturnCode code) {
        this.code = code.code;
        this.message = code.message;
    }

    public Response(String code,String message,Object data) {
        this.setCode(code);
        this.setMessage(message);
        this.setData(data);
    }

    /**
     * 接口调用成功,有参
     * @param data
     */
    public static <U> Response<U> success(U data){
        Response<U> response = new Response<U>();
        response.setCode(ReturnCode.SUCCESS.code);
        response.setMessage(ReturnCode.SUCCESS.message);
        response.setData(data);
        return response;
    }

    /**
     * 接口调用成功,无参
     */
    public static <U> Response<U> success(){
        Response<U> response = new Response<U>();
        response.setCode(ReturnCode.SUCCESS.code);
        response.setMessage(ReturnCode.SUCCESS.message);
        return response;
    }

    /**
     * 接口调用失败,有错误字符串码和描述,有返回对象
     * @param code
     * @param message
     * @param data
     * @param <U>
     * @return
     */
    public static <U> Response<U> error(String code, String message, U data) {
        Response<U> response = new Response<U>();
        response.setCode(code);
        response.setMessage(message);
        response.setData(data);
        return response;
    }


}
