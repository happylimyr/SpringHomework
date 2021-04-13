package com.epam.spring.boot.SpringHomework2.config;

import com.epam.spring.boot.SpringHomework2.beans.BeanB;
import com.epam.spring.boot.SpringHomework2.beans.BeanC;
import com.epam.spring.boot.SpringHomework2.beans.BeanD;
import com.epam.spring.boot.SpringHomework2.beans.BeanF;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.*;
import org.springframework.core.annotation.Order;

@Configuration
@PropertySource("application.properties")
public class AppConfig1 {
    @Value("${beanb.name}")
    private String beanBName;
    @Value("${beanb.value}")
    private int beanBValue;
    @Value("${beanc.name}")
    private String beanCName;
    @Value("${beanc.value}")
    private int beanCValue;
    @Value("${beand.name}")
    private String beanDName;
    @Value("${beand.value}")
    private int beanDValue;

    @Bean(initMethod = "init", destroyMethod = "destroy")
    @Order(2)
    public BeanB getBeanB() {
        return new BeanB(beanBName, beanBValue);
    }

    @Bean(initMethod = "init", destroyMethod = "destroy")
    @Order(3)
    public BeanC getBeanC() {
        return new BeanC(beanCName, beanCValue);
    }

    @Bean(initMethod = "init", destroyMethod = "destroy")
    @Order(1)
    public BeanD getBeanD() {
        return new BeanD(beanDName, beanDValue);
    }

    @Bean
    @Lazy
    public BeanF geBeanF() {
        return new BeanF("qwe", 123);
    }
}
