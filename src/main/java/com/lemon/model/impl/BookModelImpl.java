package com.lemon.model.impl;

import com.lemon.annotation.MyBean;
import com.lemon.dimain.Book;
import com.lemon.model.BookModel;

import java.util.List;

/**
 * @author lbk
 * @create 2021-03-14 11:41
 */
@MyBean
public class BookModelImpl implements BookModel {
    @Override
    public Book queryById(String name) {
        System.out.println("根据书名，查询了到了一本《" + name + "》");
        return null;
    }

    @Override
    public List<Book> queryByBooks(Integer limit, Integer size) {
        System.out.println("分页查询书");
        return null;
    }

    @Override
    public Integer queryByBookCount() {
        System.out.println("查询书的总数");
        return null;
    }
}
