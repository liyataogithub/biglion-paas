package com.biglion.paas.api.user.service.impl;

import com.biglion.paas.api.user.model.OrderInfo;
import com.biglion.paas.api.user.mapper.OrderInfoMapper;
import com.biglion.paas.api.user.service.IOrderInfoService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import java.util.List;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * <p>
    * 订单表 服务实现类
    * </p>
 *
 * @author liyt
 * @since 2020-03-13
 */
@Service
public class OrderInfoServiceImpl extends ServiceImpl<OrderInfoMapper, OrderInfo> implements IOrderInfoService {

	@Autowired
    OrderInfoMapper userMapper;

	@Override
	public void add(OrderInfo user) {
    userMapper.add(user);
	}

	@Override
	public void del(String user_id) {
    userMapper.del(user_id);
	}

	@Override
	public void update(OrderInfo user) {
    userMapper.update(user);
	}


	@Override
	public OrderInfo getById(String user_id) {
		return userMapper.getById(user_id);
	}

	@Override
	public List<OrderInfo> get(OrderInfo user) {
		List<OrderInfo> userList = userMapper.get(user);
		return userList;
	}

	@Override
	public List<OrderInfo> get(OrderInfo user, int pageNum, int pageSize) {
		PageHelper.startPage(pageNum, pageSize);
		List<OrderInfo> userList = userMapper.get(user);
		return userList;
	}

}
