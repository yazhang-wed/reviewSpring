package com.lemon.dimain;

import lombok.Data;

import java.io.Serializable;

/**
 * 书实体类
 *
 * @author lbk
 * @create 2021-03-14 11:12
 */
@Data
public class Book implements Serializable {
    private static final long serialVersionUID = 6212867640123112112L;

    private String name;
    private double price;
    private String type;
}
