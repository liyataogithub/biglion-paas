package com.biglion.paas.api.user.util;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;

/**
 * @author DaoDao
 */
@Data
@NoArgsConstructor
public class Request<P> implements Serializable {

    /**
     * 客户端的主机名或 IP
     * 客户端；请求端；调用端；Client
     */
    @NotNull(message = "host 客户端的主机名或 IP 不可为 null")
    @NotEmpty(message = "host 客户端的主机名或 IP 不可为 空")
    @NotBlank(message = "host 客户端的主机名或 IP 不可为 空")
    @Size(min = 1, max = 64, message = "host 客户端的主机名或 IP 长度范围为 {min} ~ {max}")
    private String host;

    /**
     * 客户端名称
     * 客户端；请求端；Client
     */
    @Size(min = 1, max = 64, message = "client 客户端名称 长度范围为 {min} ~ {max}")
    private String client;

    /**
     * 服务端的服务名称
     * 服务端；响应端；Server
     */
    @NotNull(message = "service 服务端的服务名称 不可为 null")
    @NotEmpty(message = "service 服务端的服务名称 不可为 空")
    @NotBlank(message = "service 服务端的服务名称 不可为 空")
    @Size(min = 1, max = 64, message = "service 服务端的服务名称 长度范围为 {min} ~ {max}")
    private String service;

    /**
     * 服务端的 API 编码
     */
    @NotNull(message = "api 服务端的 API 编码 不可为 null")
    @NotEmpty(message = "api 服务端的 API 编码 不可为 空")
    @NotBlank(message = "api 服务端的 API 编码 不可为 空")
    @Size(min = 1, max = 64, message = "api 服务端的 API 编码 长度范围为 {min} ~ {max}")
    private String api;

    /**
     * 链路追踪 ID
     */
    @Size(min = 1, max = 64, message = "trace 链路追踪 ID 长度范围为 {min} ~ {max}")
    private String trace;

    /**
     * 客户端的请求参数
     */
    @NotNull(message = "param 客户端请求参数 不能为空 null")
    private P param;

/*    @JsonProperty("oAuth2")
    private OAuth2 oAuth2;

    private User user;*/

}
