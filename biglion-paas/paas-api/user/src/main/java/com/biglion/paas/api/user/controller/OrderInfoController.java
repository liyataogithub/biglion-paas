package com.biglion.paas.api.user.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.biglion.paas.api.user.enums.ReturnCode;
import com.biglion.paas.api.user.model.OrderInfo;
import com.biglion.paas.api.user.util.Response;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.biglion.paas.api.user.service.OrderInfoService;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;


/**
 * Copyright: Copyright (c) 2020
 *
 * <p>说明： 用户订单API接口层</P>
 * @version: V1.0
 * @author: liyt
 *
 * Modification History:
 * Date         	Author          Version          Description
 *---------------------------------------------------------------*
 * 2020年3月14日     liyt           V1.0             initialize
 */
@Api(description = "用户订单",value="用户订单" )
@RestController
@RequestMapping("/user/order-info")
@Slf4j
public class OrderInfoController {

    @Autowired
    OrderInfoService orderInfoService;

    /**
     * @explain 分页条件查询用户订单
     * @param pageNum
     * @param pageSize
     * @return  PageInfo<OrderInfo>
     * @author  liyt
     * @time    2020年3月14日
     */
    @GetMapping("/getOrderPages")
    @ApiOperation(value = "分页查询用户订单", notes = "分页查询用户订单 返回对象[IPage<User>],作者：liyt")
    @ApiImplicitParams({
            @ApiImplicitParam(paramType="query", name = "pageNum", value = "当前页", required = true, dataType = "int"),
            @ApiImplicitParam(paramType="query", name = "pageSize", value = "页行数", required = true, dataType = "int")
    })
    public Response getByPage(Integer pageNum,Integer pageSize) {

        Page<OrderInfo> page=new Page<OrderInfo>(pageNum,pageSize);
        QueryWrapper<OrderInfo> queryWrapper =new QueryWrapper<OrderInfo>();
        //分页数据
        try {
            IPage<OrderInfo> pageInfo=orderInfoService.page(page, queryWrapper);
            return Response.success(pageInfo);
        } catch (Exception e) {
            log.error("分页查询用户订单执行异常："+e.getMessage());
            Response.error(ReturnCode.ERROR.code,e.getMessage(),null);
        }
        return Response.error(ReturnCode.ERROR.code,ReturnCode.ERROR.message,null);
    }

    /**
     * @explain 查询用户订单对象  <swagger GET请求>
     * @param   id
     * @return  user
     * @author  liyt
     * @time    2020年3月14日
     */
    @GetMapping("/getOrderById/{id}")
    @ApiOperation(value = "根据订单ID获取用户订单信息", notes = "根据订单ID获取用户订单信息[order_info]，作者：liyt")
    @ApiImplicitParam(paramType="path", name = "id", value = "用户id", required = true, dataType = "Long")
    public Response get(@PathVariable("id")Long id) {
        OrderInfo orderInfo = orderInfoService.getById(id);
        return Response.success(orderInfo);
    }

    /**
     * @explain 添加或者更新用户订单对象
     * @param   orderInfo
     * @return  int
     * @author  liyt
     * @time    2020年3月14日
     */
    @RequestMapping("/add")
    public Response add(OrderInfo orderInfo) {
        boolean rg=orderInfoService.saveOrUpdate(orderInfo);
        if (rg) {
            return Response.success(orderInfo);
        } else {
            log.error("添加用户订单执行失败："+orderInfo.toString());
            return Response.error(ReturnCode.ERROR.code,ReturnCode.ERROR.message,orderInfo);
        }
    }

    /**
     * @explain 根据ID删除用户订单
     * @param   id
     * @return  int
     * @author  liyt
     * @time    2020年3月14日
     */
    @PostMapping("/deleteById")
    @ApiOperation(value = "根据ID删除用户订单", notes = "根据ID删除用户订单,作者：liyt")
    @ApiImplicitParam(paramType="query", name = "id", value = "订单id", required = true, dataType = "Long")
    public Response del(Long id) {
        orderInfoService.removeById(id);
        return Response.success();
    }
}
