package com.lemon.dimain;

import lombok.Data;

import java.io.Serializable;

/**
 * 用户实体类
 * @author lbk
 * @create 2021-03-14 11:03
 */
@Data
public class User implements Serializable {
    private static final long serialVersionUID = -4113908649517320917L;

    private String name;
    private Integer age;
    private String sex;
    private String hobby;
}
