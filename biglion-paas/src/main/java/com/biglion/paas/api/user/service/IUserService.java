package com.biglion.paas.api.user.service;

import java.util.List;
import com.biglion.paas.api.user.model.User;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
    * 用户表 服务类
    * </p>
 *
 * @author liyt
 * @since 2020-03-13
 */
public interface IUserService extends IService<User> {

	public void add(User user);
	public void update(User user);
	public void del(String user_id);
	public User getById(String user_id);
	public List<User> get(User user);
	public List<User> get(User user, int pageNum, int pageSize);

}
