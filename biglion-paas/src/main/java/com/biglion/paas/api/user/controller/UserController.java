package com.biglion.paas.api.user.controller;

import com.biglion.paas.api.user.model.User;
import com.github.pagehelper.PageInfo;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import com.biglion.paas.api.user.service.IUserService;

import org.springframework.web.bind.annotation.RestController;

/**
 * <p>
    * 用户表 前端控制器
    * </p>
 *
 * @author liyt
 * @since 2020-03-13
 */
@RestController
@RequestMapping("/user/user")
public class UserController {

	@Autowired
    IUserService userService;

	@RequestMapping("/getByPage")
	public Object getByPage(User user, int pageNum, int pageSize) {
		List<User> userList = userService.get(user, pageNum, pageSize);
		PageInfo<User> pageInfo = new PageInfo<>(userList);
		return Response.success(pageInfo);
	}

	@RequestMapping("/get")
	public Object get(User user) {
		List<User> userList = userService.get(user);
		return Response.success(userList);
	}

	@RequestMapping("/add")
	public Object add(User user) {
    userService.add(user);
		return Response.success();
	}

	@RequestMapping("/del")
	public Object del(String user_id) {
    userService.del(user_id);
		return Response.success();
	}

	@RequestMapping("/update")
	public Object update(User user) {
    userService.update(user);
		return Response.success();
	}
}
