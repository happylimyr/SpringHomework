package com.epam.spring.core.beans.injection;

import com.epam.spring.core.beans.otherbeans.OtherBeanA;
import com.epam.spring.core.beans.otherbeans.OtherBeanC;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

public class FieldInjectedOtherBeanC {
    @Autowired
    private OtherBeanC otherBeanC;
    @Autowired
    @Qualifier("otherBean2")
    private OtherBeanA otherBeanA;

    @Autowired
    @Qualifier("otherBean3")
    private OtherBeanA otherBeanA2;
}
