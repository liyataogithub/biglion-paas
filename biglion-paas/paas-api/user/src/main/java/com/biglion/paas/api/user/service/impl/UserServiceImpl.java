/**
 * @filename:UserServiceImpl User
 * @project biglion-paas  V1.0
 * Copyright(c) 2018 liyt Co. Ltd. 
 * All right reserved. 
 */
package com.biglion.paas.api.user.service.impl;

import com.biglion.paas.api.user.mapper.UserDao;
import com.biglion.paas.api.user.model.User;
import com.biglion.paas.api.user.service.IUserService;
import org.springframework.stereotype.Service;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;

/**   
 * Copyright: Copyright (c) 2019 
 * 
 * <p>说明： 用户服务实现层</P>
 * @version: V1.0
 * @author: liyt
 * 
 * Modification History:
 * Date         	Author          Version          Description
 *---------------------------------------------------------------*
 * User      liyt    V1.0           initialize
 */
@Service
public class UserServiceImpl  extends ServiceImpl<UserDao, User> implements IUserService {
	
}