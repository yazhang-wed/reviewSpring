package com.lemon.service;

import com.lemon.dimain.User;

import java.util.Map;

/**
 * @author lbk
 * @create 2021-03-14 11:43
 */
public interface UserService {

    /**
     * 根据用户编号查询用户
     *
     * @param id 编号
     * @return
     */
    User queryById(Integer id);

    /**
     * 分页查询用户
     *
     * @param limit 当前页
     * @param size  当前页大小
     * @return
     */
    Map<String, Object> queryByUsers(Integer limit, Integer size);
}
