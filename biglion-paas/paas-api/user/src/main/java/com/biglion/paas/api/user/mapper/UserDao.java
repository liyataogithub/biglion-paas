/**
 * @filename:UserDao User
 * @project biglion-paas  V1.0
 * Copyright(c) 2018 liyt Co. Ltd. 
 * All right reserved. 
 */
package com.biglion.paas.api.user.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import com.biglion.paas.api.user.model.User;

/**   
 * Copyright: Copyright (c) 2019 
 * 
 * <p>说明： 用户数据访问层</P>
 * @version: V1.0
 * @author: liyt
 * 
 * Modification History:
 * Date         	Author          Version          Description
 *---------------------------------------------------------------*
 * User      liyt    V1.0         initialize
 */
@Mapper
public interface UserDao extends BaseMapper<User> {
	
}
