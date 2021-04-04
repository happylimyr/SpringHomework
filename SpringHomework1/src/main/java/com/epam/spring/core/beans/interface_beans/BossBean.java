package com.epam.spring.core.beans.interface_beans;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

public class BossBean {
    @Autowired
    private BossBean bicycle;
    @Autowired
    @Qualifier("Car")
    private BossBean car;
    @Autowired
    @Qualifier("Plane")
    private BossBean plane;
}
