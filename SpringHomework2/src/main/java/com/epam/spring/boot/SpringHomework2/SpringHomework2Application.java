package com.epam.spring.boot.SpringHomework2;

import com.epam.spring.boot.SpringHomework2.config.AppConfig1;
import com.epam.spring.boot.SpringHomework2.config.AppConfig2;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextInitializer;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.Arrays;

@SpringBootApplication
public class SpringHomework2Application {

    public static void main(String[] args) {

        SpringApplication.run(SpringHomework2Application.class, args);

        //show all beans
        ApplicationContext context = new AnnotationConfigApplicationContext(AppConfig1.class);
        System.out.println("______Show all beans:______ ");
        for (String beanDefinitionName : context.getBeanDefinitionNames()) {
            System.out.println(beanDefinitionName);
        }
        // show beans config

        AnnotationConfigApplicationContext context1 =
                new AnnotationConfigApplicationContext(AppConfig1.class);
        System.out.println("______Show beans config:______ ");
        for (String name : context.getBeanDefinitionNames()) {
            BeanDefinition beanDefinition = context1.getBeanDefinition(name);
            System.out.println(beanDefinition);
        }


    }

}



