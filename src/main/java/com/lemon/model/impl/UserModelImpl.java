package com.lemon.model.impl;

import com.lemon.annotation.MyBean;
import com.lemon.dimain.User;
import com.lemon.model.UserModel;

import java.util.List;

/**
 * @author lbk
 * @create 2021-03-14 11:34
 */
@MyBean
public class UserModelImpl implements UserModel {
    @Override
    public User queryByUserId(Integer id) {
        System.out.println("根据用户编号查询用户信息");
        return null;
    }

    @Override
    public List<User> queryByUsers(Integer limit, Integer size) {
        System.out.println("分页查询了用户信息");
        return null;
    }

    @Override
    public Integer queryByUserCount() {
        System.out.println("查询用户总数");
        return null;
    }
}
