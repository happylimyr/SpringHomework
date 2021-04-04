package com.epam.spring.core.beans.beans3;

import org.springframework.stereotype.Component;


@Component
public class BeanF  {

    private String name;

    public BeanF() {

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
