package com.epam.spring.core.beans.interface_beans;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class CollectionBean {
    @Autowired
    private List<Transport> transports;

    public void printTransport(){
        for (Transport transport : transports){
            System.out.println(transport.getTransport());
        }
    }
}
