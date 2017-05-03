package com.ora.service;

import java.util.List;

import com.ora.model.User;

/**
 * 用户服务
 */
public interface UserService {
	/**
	 * 添加一个用户
	 * @param user 用户对象
	 * @since 2016年9月21日20:58:17
	 * @return 是否添加成功
	 */
	public boolean add(User user);
	/**
	 * 查询用户
	 * @return
	 */
	public User findByUserId(Integer id);

    /**
     * @return List<User>
     */
    public List<User> findAll();
}
