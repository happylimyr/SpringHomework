package com.epam.spring.boot.SpringHomework2.beans;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.config.BeanFactoryPostProcessor;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;

public class MyBeanFactoryPostProcessor implements BeanFactoryPostProcessor {
    @Override
    public void postProcessBeanFactory(
            ConfigurableListableBeanFactory configurableListableBeanFactory) throws BeansException {
        for (String beanName : configurableListableBeanFactory.getBeanDefinitionNames()) {
            if (beanName.equals("beanB")) {
                BeanDefinition beanDefinition = configurableListableBeanFactory.getBeanDefinition(beanName);
                beanDefinition.setInitMethodName(" anotherInit ");
            }
        }
    }
}
