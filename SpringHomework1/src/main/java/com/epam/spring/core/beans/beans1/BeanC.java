package com.epam.spring.core.beans.beans1;

import org.springframework.stereotype.Component;


@Component
public class BeanC  {

    private String name;

    public BeanC() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
