package com.lemon.model;

import com.lemon.dimain.Book;

import java.util.List;

/**
 * @author lbk
 * @create 2021-03-14 11:37
 */
public interface BookModel {

    /**
     * 根据书名查询书
     *
     * @param name 书名
     * @return
     */
    Book queryById(String name);

    /**
     * 分页查询书
     *
     * @param limit 当前页
     * @param size  每页大小
     * @return
     */
    List<Book> queryByBooks(Integer limit, Integer size);

    /**
     * 查询书的总书
     *
     * @return
     */
    Integer queryByBookCount();
}
