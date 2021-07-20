package com.lemon.service.impl;

import com.lemon.annotation.MyAutoWired;
import com.lemon.annotation.MyBean;
import com.lemon.dimain.User;
import com.lemon.model.UserModel;
import com.lemon.model.impl.UserModelImpl;
import com.lemon.service.UserService;

import java.util.HashMap;
import java.util.Map;

/**
 * @author lbk
 * @create 2021-03-14 11:47
 */
@MyBean
public class UserServiceImpl implements UserService {

    @MyAutoWired
    private UserModel userModel;

    @Override
    public User queryById(Integer id) {
        return userModel.queryByUserId(id);
    }

    @Override
    public Map<String, Object> queryByUsers(Integer limit, Integer size) {
        Map<String, Object> map = new HashMap<>();
        map.put("list", userModel.queryByUsers(limit, size));
        map.put("count", userModel.queryByUserCount());

        return map;
    }
}
