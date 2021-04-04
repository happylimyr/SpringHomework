package com.epam.spring.core.beans.injection;

import com.epam.spring.core.beans.otherbeans.OtherBeanA;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

public class ConstructorInjectedOtherBeanA {
    private OtherBeanA otherBeanA;

    @Autowired
    public ConstructorInjectedOtherBeanA(OtherBeanA otherBeanA) {
        this.otherBeanA = otherBeanA;
    }

}
