package com.epam.spring.core.beans.beans3;

import org.springframework.stereotype.Component;


@Component
public class BeanD  {

    private String name;

    public BeanD() {

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
