package com.biglion.paas.api.user.mapper;

import java.util.List;
import com.biglion.paas.api.user.model.User;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

/**
 * <p>
    * 用户表 Mapper 接口
    * </p>
 *
 * @author liyt
 * @since 2020-03-13
 */
public interface UserMapper extends BaseMapper<User> {

	public void add(User user);
	public void update(User user);
	public void del(String user_id);
	public User getById(String user_id);
	public List<User> get(User user);

}
