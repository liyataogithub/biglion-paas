package com.biglion.paas.api.user.service.impl;

import com.biglion.paas.api.user.model.User;
import com.biglion.paas.api.user.mapper.UserMapper;
import com.biglion.paas.api.user.service.IUserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import java.util.List;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * <p>
    * 用户表 服务实现类
    * </p>
 *
 * @author liyt
 * @since 2020-03-13
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements IUserService {

	@Autowired
    UserMapper userMapper;

	@Override
	public void add(User user) {
    userMapper.add(user);
	}

	@Override
	public void del(String user_id) {
    userMapper.del(user_id);
	}

	@Override
	public void update(User user) {
    userMapper.update(user);
	}


	@Override
	public User getById(String user_id) {
		return userMapper.getById(user_id);
	}

	@Override
	public List<User> get(User user) {
		List<User> userList = userMapper.get(user);
		return userList;
	}

	@Override
	public List<User> get(User user, int pageNum, int pageSize) {
		PageHelper.startPage(pageNum, pageSize);
		List<User> userList = userMapper.get(user);
		return userList;
	}

}
