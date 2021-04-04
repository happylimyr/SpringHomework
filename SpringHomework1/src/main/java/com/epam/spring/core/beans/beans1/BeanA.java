package com.epam.spring.core.beans.beans1;

import org.springframework.stereotype.Component;

@Component
public class BeanA {

    private String name;

    public BeanA() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
