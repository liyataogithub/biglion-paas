package com.biglion.paas.api.user.model;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import java.io.Serializable;

import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 * 用户订单表
 * </p>
 *
 * @author liyt
 * @since 2020-03-13
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@ApiModel(value="OrderInfo对象", description="订单表")
@TableName("order_info")
public class OrderInfo extends Model<OrderInfo> implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(name = "id" ,value = "标识",example = "1")
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    @ApiModelProperty(name = "orderName" ,value = "订单名")
    private String orderName;

    @ApiModelProperty(name = "orderAddress" ,value = "订单地址")
    private String orderAddress;


}
