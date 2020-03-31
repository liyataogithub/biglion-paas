package com.biglion.paas.api.user.mapper;

import java.util.List;
import com.biglion.paas.api.user.model.OrderInfo;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

/**
 * <p>
    * 订单表 Mapper 接口
    * </p>
 *
 * @author liyt
 * @since 2020-03-13
 */
public interface OrderInfoMapper extends BaseMapper<OrderInfo> {

	public void add(OrderInfo user);
	public void update(OrderInfo user);
	public void del(String user_id);
	public OrderInfo getById(String user_id);
	public List<OrderInfo> get(OrderInfo user);

}
