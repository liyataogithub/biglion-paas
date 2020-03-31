/**
 * @filename:UserController User
 * @project biglion-paas  V1.0
 * Copyright(c) 2018 liyt Co. Ltd. 
 * All right reserved. 
 */
package com.biglion.paas.api.user.controller;



import com.biglion.paas.api.user.service.IUserService;
import com.biglion.paas.api.user.model.User;

import com.biglion.paas.api.user.util.JsonResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

/**   
 * Copyright: Copyright (c) 2019 
 * 
 * <p>说明： 用户API接口层</P>
 * @version: V1.0
 * @author: liyt
 * 
 * Modification History:
 * Date         	Author          Version          Description
 *---------------------------------------------------------------*
 * User      liyt    V1.0           initialize
 */
@Api(description = "用户",value="用户" )
@RestController
@RequestMapping("/user")
public class UserController {

	Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	public IUserService userServiceImpl;
	
	/**
	 * @explain 查询用户对象  <swagger GET请求>
	 * @param   id
	 * @return  user
	 * @author  liyt
	 * @time    User
	 */
	@GetMapping("/getUserById/{id}")
	@ApiOperation(value = "获取用户信息", notes = "获取用户信息[user]，作者：liyt")
	@ApiImplicitParam(paramType="path", name = "id", value = "用户id", required = true, dataType = "Long")
	public JsonResult<User> getUserById(@PathVariable("id")Long id){
		JsonResult<User> result=new JsonResult<User>();
		try {
			User user=userServiceImpl.getById(id);
			if (user!=null) {
				result.setType("success");
				result.setMessage("成功");
				result.setData(user);
			} else {
				logger.error("获取用户失败ID："+id);
				result.setType("fail");
				result.setMessage("你获取的用户不存在");
			}
		} catch (Exception e) {
			logger.error("获取用户执行异常："+e.getMessage());
			result=new JsonResult<User>(e);
		}
		return result;
	}
	
	/**
	 * @explain 添加或者更新用户对象
	 * @param   user
	 * @return  int
	 * @author  liyt
	 * @time    User
	 */
	@PostMapping("/insertSelective")
	@ApiOperation(value = "添加用户", notes = "添加用户[user],作者：liyt")
	public JsonResult<User> insertSelective(User user){
		JsonResult<User> result=new JsonResult<User>();
		try {
			boolean rg=userServiceImpl.saveOrUpdate(user);
			if (rg) {
				result.setType("success");
				result.setMessage("成功");
				result.setData(user);
			} else {
				logger.error("添加用户执行失败："+user.toString());
				result.setType("fail");
				result.setMessage("执行失败，请稍后重试");
			}
		} catch (Exception e) {
			logger.error("添加用户执行异常："+e.getMessage());
			result=new JsonResult<User>(e);
		}
		return result;
	}
	
	/**
	 * @explain 删除用户对象
	 * @param   id
	 * @return  int
	 * @author  liyt
	 * @time    User
	 */
	@PostMapping("/deleteByPrimaryKey")
	@ApiOperation(value = "删除用户", notes = "删除用户,作者：liyt")
	@ApiImplicitParam(paramType="query", name = "id", value = "用户id", required = true, dataType = "Long")
	public JsonResult<Object> deleteByPrimaryKey(Long id){
		JsonResult<Object> result=new JsonResult<Object>();
		try {
			boolean reg=userServiceImpl.removeById(id);
			if (reg) {
				result.setType("success");
				result.setMessage("成功");
				result.setData(id);
			} else {
				logger.error("删除用户失败ID："+id);
				result.setType("fail");
				result.setMessage("执行错误，请稍后重试");
			}
		} catch (Exception e) {
			logger.error("删除用户执行异常："+e.getMessage());
			result=new JsonResult<Object>(e);
		}
		return result;
	}
	
	/**
	 * @explain 分页条件查询用户
	 * @return  PageInfo<User>
	 * @author  liyt
	 * @time    User
	 */
	@GetMapping("/getUserPages")
	@ApiOperation(value = "分页查询", notes = "分页查询返回对象[IPage<User>],作者：liyt")
	@ApiImplicitParams({
        @ApiImplicitParam(paramType="query", name = "pageNum", value = "当前页", required = true, dataType = "int"),
        @ApiImplicitParam(paramType="query", name = "pageSize", value = "页行数", required = true, dataType = "int")
    })
	public JsonResult<IPage<User>> getUserPages(Integer pageNum,Integer pageSize){
	
		JsonResult<IPage<User>> result=new JsonResult<IPage<User>>();
		Page<User> page=new Page<User>(pageNum,pageSize);
		QueryWrapper<User> queryWrapper =new QueryWrapper<User>();
		//分页数据
		try {
			IPage<User> pageInfo=userServiceImpl.page(page, queryWrapper);
			result.setType("success");
			result.setMessage("成功");
			result.setData(pageInfo);
		} catch (Exception e) {
			logger.error("分页查询用户执行异常："+e.getMessage());
			result=new JsonResult<IPage<User>>(e);
		}
		return result;
	}
}