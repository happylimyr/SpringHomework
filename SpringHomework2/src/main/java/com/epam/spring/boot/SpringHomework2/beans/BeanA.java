package com.epam.spring.boot.SpringHomework2.beans;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.stereotype.Component;

@Component
public class BeanA implements InitializingBean, DisposableBean, BeanValidator {
    private static Logger logger = LogManager.getLogger(BeanA.class.getName());
    private String name = "";
    private int value = 0;

    @Override
    public String toString() {
        return "BeanA{" +
                "name='" + name + '\'' +
                ", value=" + value +
                '}';
    }

    @Override
    public void destroy() throws Exception {
        logger.info(this.getClass().getName() + " destroy from DisposableBean ");
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        logger.info(this.getClass().getName() + " afterPropertiesSet from InitializingBean ");

    }

    @Override
    public boolean validate() {
        if (name.isEmpty() || value < 0) {
            return false;
        }
        return true;
    }
}
