package com.epam.spring.boot.SpringHomework2.beans;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

//@Component
@PropertySource("application.properties")
public class BeanB implements BeanValidator{
    private static Logger logger = LogManager.getLogger(BeanB.class.getName());
    private String name = "";
    private int value = 0;


    public BeanB(String name, int value) {
        this.name = name;
        this.value = value;
    }

    @Override
    public String toString() {
        return "BeanB{" +
                "name='" + name + '\'' +
                ", value=" + value +
                '}';
    }

    public void init() {
        logger.info(this.getClass().getName() + " init ");
    }

    public void destroy(){
        logger.info(this.getClass().getName() + " destroy ");
    }

    @Override
    public boolean validate() {
        if (name.isEmpty() || value < 0) {
            return false;
        }
        return true;
    }
}
