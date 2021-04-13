package com.epam.spring.boot.SpringHomework2.beans;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;

public class MyBeanPostProcessor implements BeanPostProcessor {
    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        if (bean instanceof BeanValidator) {
            ((BeanValidator) bean).validate();
        }
        return bean;
    }
}
