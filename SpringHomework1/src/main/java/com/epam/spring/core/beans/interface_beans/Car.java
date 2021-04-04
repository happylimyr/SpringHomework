package com.epam.spring.core.beans.interface_beans;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Component
@Order(2)
@Qualifier("Car")
public class Car implements Transport{
    private String name;

    public Car() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String getTransport() {
        return "Car";
    }
}
