package com.epam.spring.core;

import com.epam.spring.core.beans.interface_beans.CollectionBean;
import com.epam.spring.core.config.AppConfig1;
import com.epam.spring.core.config.AppConfig2;
import com.epam.spring.core.config.AppConfigOthers;
import com.epam.spring.core.config.AppConfingInterface;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {


    public static void main(String[] args) {
        ApplicationContext ctx = new AnnotationConfigApplicationContext(AppConfig1.class);
        ApplicationContext ctx2 = new AnnotationConfigApplicationContext(AppConfig2.class);
        ApplicationContext ctx3 = new AnnotationConfigApplicationContext(AppConfigOthers.class);
        ApplicationContext ctx4 = new AnnotationConfigApplicationContext(AppConfingInterface.class);
//        ctx2.getBean(AppConfig2.class);
//        ctx4.getBean(CollectionBean.class).printTransport();
        for (String beanDefinitionName : ctx.getBeanDefinitionNames()) {
            System.out.println(beanDefinitionName);
        }
        for (String beanDefinitionName : ctx2.getBeanDefinitionNames()) {
            System.out.println(beanDefinitionName);
        }
        for (String beanDefinitionName : ctx3.getBeanDefinitionNames()) {
            System.out.println(beanDefinitionName);
        }
        for (String beanDefinitionName : ctx4.getBeanDefinitionNames()) {
            System.out.println(beanDefinitionName);
        }
    }
}
