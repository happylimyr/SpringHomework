package com.epam.spring.core.beans.beans1;

import org.springframework.stereotype.Component;


@Component
public class BeanB  {

    private String name;

    public BeanB() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
