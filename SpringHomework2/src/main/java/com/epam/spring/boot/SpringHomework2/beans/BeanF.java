package com.epam.spring.boot.SpringHomework2.beans;

import org.springframework.stereotype.Component;

//@Component
public class BeanF implements BeanValidator{
    private String name = "";
    private int value = 0;

    public BeanF(String name, int value) {
        this.name = name;
        this.value = value;
    }

    @Override
    public String toString() {
        return "BeanF{" +
                "name='" + name + '\'' +
                '}';
    }

    @Override
    public boolean validate() {
        if (name.isEmpty() || value < 0) {
            return false;
        }
        return true;
    }
}
