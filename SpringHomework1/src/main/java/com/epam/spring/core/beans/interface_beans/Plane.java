package com.epam.spring.core.beans.interface_beans;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Component
@Order(1)
@Qualifier("Plane")
public class Plane implements Transport{
    private String name;

    public Plane() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String getTransport() {
        return "Plane";
    }
}
