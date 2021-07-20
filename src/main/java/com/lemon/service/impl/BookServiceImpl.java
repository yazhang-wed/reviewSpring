package com.lemon.service.impl;

import com.lemon.annotation.MyAutoWired;
import com.lemon.annotation.MyBean;
import com.lemon.dimain.Book;
import com.lemon.model.BookModel;
import com.lemon.model.impl.BookModelImpl;
import com.lemon.service.BookService;

import java.util.HashMap;
import java.util.Map;

/**
 * @author lbk
 * @create 2021-03-14 11:54
 */
@MyBean
public class BookServiceImpl implements BookService {

    @MyAutoWired
    private BookModel bookModel;

    @Override
    public Book queryById(String name) {
        return bookModel.queryById(name);
    }

    @Override
    public Map<String, Object> queryByBooks(Integer limit, Integer size) {

        Map<String, Object> map = new HashMap<>();

        map.put("list", bookModel.queryByBooks(limit, size));
        map.put("count", bookModel.queryByBookCount());

        return map;
    }
}
