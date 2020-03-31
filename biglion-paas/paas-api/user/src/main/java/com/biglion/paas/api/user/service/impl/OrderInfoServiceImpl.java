package com.biglion.paas.api.user.service.impl;


import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.biglion.paas.api.user.mapper.OrderInfoDao;
import com.biglion.paas.api.user.model.OrderInfo;
import com.biglion.paas.api.user.service.OrderInfoService;
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
public class OrderInfoServiceImpl extends ServiceImpl<OrderInfoDao, OrderInfo> implements OrderInfoService {

}
