package com.epam.spring.core.config;

import com.epam.spring.core.beans.otherbeans.OtherBeanA;
import com.epam.spring.core.beans.otherbeans.OtherBeanB;
import com.epam.spring.core.beans.otherbeans.OtherBeanC;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
//@ComponentScan(basePackages = "com.epam.spring.core.beans.injection")
public class AppConfigOthers {
    @Bean
    public OtherBeanA otherBeanA() {
        return new OtherBeanA();
    }
    @Bean(name="otherBeanA2")
    public OtherBeanA otherBeanA2() {
        return new OtherBeanA();
    }
    @Bean(name="otherBeanA3")
    public OtherBeanA otherBeanA3() {
        return new OtherBeanA();
    }
    @Bean
    public OtherBeanB otherBeanB() {
        return new OtherBeanB();
    }
    @Bean
    public OtherBeanC otherBeanC() {
        return new OtherBeanC();
    }

}
