package com.lemon.service;

import com.lemon.dimain.Book;

import java.util.Map;

/**
 * @author lbk
 * @create 2021-03-14 11:52
 */
public interface BookService {

    /**
     * 根据书名查询书
     *
     * @param name
     * @return
     */
    Book queryById(String name);

    /**
     * 查询书分页数据
     * @param limit
     * @param size
     * @return
     */
    Map<String, Object> queryByBooks(Integer limit, Integer size);
}
