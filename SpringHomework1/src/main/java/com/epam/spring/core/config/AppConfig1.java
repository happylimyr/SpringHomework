package com.epam.spring.core.config;

import com.epam.spring.core.beans.beans1.BeanA;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackages = "com.epam.spring.core.beans.beans1")
public class AppConfig1 {

}
