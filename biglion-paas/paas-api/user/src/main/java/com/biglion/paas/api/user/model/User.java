/**
 * @filename:User User
 * @project biglion-paas  V1.0
 * Copyright(c) 2018 liyt Co. Ltd. 
 * All right reserved. 
 */
package com.biglion.paas.api.user.model;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;
import java.io.Serializable;

/**   
 * Copyright: Copyright (c) 2019 
 * 
 * <p>说明： 用户实体类</P>
 * @version: V1.0
 * @author: liyt
 * 
 * Modification History:
 * Date         	Author          Version          Description
 *---------------------------------------------------------------*
 * User      liyt    V1.0           initialize
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class User extends Model<User> {

	private static final long serialVersionUID = 1584256383323L;
	
	@TableId(value = "id", type = IdType.AUTO)
	@ApiModelProperty(name = "id" , value = "标识",example = "1")
	private Integer id;
	@ApiModelProperty(name = "userAddress" , value = "用户地址")
	private String userAddress;
	@ApiModelProperty(name = "userName" , value = "用户名")
	private String userName;
	@ApiModelProperty(name = "userSex" , value = "性别，0：男 1：女",example = "1")
	private Integer userSex;
	@Override
    protected Serializable pkVal() {
        return this.id;
    }
}
