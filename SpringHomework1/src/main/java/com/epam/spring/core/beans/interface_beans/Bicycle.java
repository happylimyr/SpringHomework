package com.epam.spring.core.beans.interface_beans;

import org.springframework.context.annotation.Primary;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Component
@Order(3)
@Primary
public class Bicycle implements Transport {
    private String name;

    public Bicycle() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String getTransport() {
        return "Bicycle";
    }
}
