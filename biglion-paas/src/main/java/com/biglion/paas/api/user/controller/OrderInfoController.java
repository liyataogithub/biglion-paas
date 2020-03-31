package com.biglion.paas.api.user.controller;

import com.biglion.paas.api.user.model.OrderInfo;
import com.github.pagehelper.PageInfo;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import com.biglion.paas.api.user.service.IOrderInfoService;

import org.springframework.web.bind.annotation.RestController;

/**
 * <p>
    * 订单表 前端控制器
    * </p>
 *
 * @author liyt
 * @since 2020-03-13
 */
@RestController
@RequestMapping("/user/order-info")
public class OrderInfoController {

	@Autowired
    IOrderInfoService userService;

	@RequestMapping("/getByPage")
	@NotNull(str="pageNum,pageSize")
	@LoginRequired
	public Object getByPage(OrderInfo user, int pageNum, int pageSize) {
		List<OrderInfo> userList = userService.get(user, pageNum, pageSize);
		PageInfo<OrderInfo> pageInfo = new PageInfo<>(userList);
		return ResultUtil.success(pageInfo);
	}

	@RequestMapping("/get")
	@LoginRequired
	public Object get(OrderInfo user) {
		List<OrderInfo> userList = userService.get(user);
		return ResultUtil.success(userList);
	}

	@RequestMapping("/add")
	@LoginRequired
	public Object add(OrderInfo user, @CurrentUser User currentUser) {
    userService.add(user);
		return ResultUtil.success();
	}

	@RequestMapping("/del")
	@LoginRequired
	@NotNull(str="user_id")
	public Object del(String user_id, @CurrentUser User currentUser) {
    userService.del(user_id);
		return ResultUtil.success();
	}

	@RequestMapping("/update")
	@LoginRequired
	@NotNull(str="user_id")
	public Object update(OrderInfo user, @CurrentUser User currentUser) {
    userService.update(user);
		return ResultUtil.success();
	}
}
