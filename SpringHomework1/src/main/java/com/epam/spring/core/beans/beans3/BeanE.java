package com.epam.spring.core.beans.beans3;

import org.springframework.stereotype.Component;


@Component
public class BeanE  {

    private String name;

    public BeanE(){

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
