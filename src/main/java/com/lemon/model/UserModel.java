package com.lemon.model;

import com.lemon.dimain.User;

import java.util.List;

/**
 * 用户模块
 *
 * @author lbk
 * @create 2021-03-14 11:29
 */
public interface UserModel {

    /**
     * 根据用户编号查询，用户信息
     *
     * @param id 用户编号
     * @return
     */
    User queryByUserId(Integer id);

    /**
     * 分页查询用户
     *
     * @param limit 当前页
     * @param size  每页大小
     * @return
     */
    List<User> queryByUsers(Integer limit, Integer size);

    /**
     * 查询用户总数
     *
     * @return
     */
    Integer queryByUserCount();
}
