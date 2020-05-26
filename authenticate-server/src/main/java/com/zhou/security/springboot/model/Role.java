package com.zhou.security.springboot.model;

import lombok.Data;

import java.io.Serializable;

/**
* Created by Mybatis Generator 2019/12/09
*/
@Data
public class Role implements Serializable {
    private Integer id;

    private String role;

    private String name;

    private String modules;

    private String description;

    private static final long serialVersionUID = 1L;
}