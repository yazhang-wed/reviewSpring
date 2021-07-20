package com.lemon.start;

import com.lemon.config.ApplicationContext;
import com.lemon.service.BookService;
import com.lemon.service.impl.BookServiceImpl;

/**
 * @author lbk
 * @create 2021-03-14 15:08
 */
public class Start {

    public static void main(String[] args) {
        ApplicationContext applicationContext = new ApplicationContext();
        applicationContext.initAnnotation();
        BookService bean = applicationContext.getBean(BookService.class);
        bean.queryById("曾国藩传2");
    }
}
