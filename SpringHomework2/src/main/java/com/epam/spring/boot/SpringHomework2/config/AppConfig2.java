package com.epam.spring.boot.SpringHomework2.config;

import com.epam.spring.boot.SpringHomework2.beans.MyBeanFactoryPostProcessor;
import com.epam.spring.boot.SpringHomework2.beans.MyBeanPostProcessor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Configuration
@Import(AppConfig1.class)
public class AppConfig2 {
    @Bean
    public MyBeanFactoryPostProcessor myBeanFactoryPostProcessor() {
        return new MyBeanFactoryPostProcessor();
    }
    @Bean
    public MyBeanPostProcessor myBeanPostProcessor() {
        return new MyBeanPostProcessor();
    }
}
