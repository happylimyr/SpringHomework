package com.epam.spring.core.config;

import com.epam.spring.core.beans.interface_beans.CollectionBean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackageClasses = CollectionBean.class)
public class AppConfingInterface {

}
