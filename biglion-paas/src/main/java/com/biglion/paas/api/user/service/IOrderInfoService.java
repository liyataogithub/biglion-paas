package com.biglion.paas.api.user.service;

import java.util.List;
import com.biglion.paas.api.user.model.OrderInfo;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
    * 订单表 服务类
    * </p>
 *
 * @author liyt
 * @since 2020-03-13
 */
public interface IOrderInfoService extends IService<OrderInfo> {

	public void add(OrderInfo user);
	public void update(OrderInfo user);
	public void del(String user_id);
	public OrderInfo getById(String user_id);
	public List<OrderInfo> get(OrderInfo user);
	public List<OrderInfo> get(OrderInfo user, int pageNum, int pageSize);

}
