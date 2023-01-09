package com.example.reactiveoracle.modules.xt.entity;

import org.springframework.data.relational.core.mapping.Table;

/**
 * @author zhangyong created on 2023-01-06
 **/
@Table("xt_user")
public class XtUser {

    private Long id;
    private String name;
    private String mobile;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }
}
