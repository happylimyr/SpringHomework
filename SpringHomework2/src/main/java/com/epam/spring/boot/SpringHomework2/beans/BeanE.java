package com.epam.spring.boot.SpringHomework2.beans;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

//@Component
public class BeanE implements BeanValidator{
    private static Logger logger = LogManager.getLogger(BeanE.class.getName());
    private String name = "";
    private int value = 0;

    public BeanE(String name, int value) {
        this.name = name;
        this.value = value;
    }

    @Override
    public String toString() {
        return "BeanF{" +
                "name='" + name + '\'' +
                '}';
    }

    @PostConstruct
    public void init() {
        logger.info(this.getClass().getName() + " init PostConstruct");
    }

    @PreDestroy
    public void destroy() {
        logger.info(this.getClass().getName() + " destroy PreDestroy");
    }

    @Override
    public boolean validate() {
        if (name.isEmpty() || value < 0) {
            return false;
        }
        return true;
    }
}
