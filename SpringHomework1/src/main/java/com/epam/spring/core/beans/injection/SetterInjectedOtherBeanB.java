package com.epam.spring.core.beans.injection;

import com.epam.spring.core.beans.otherbeans.OtherBeanB;
import org.springframework.beans.factory.annotation.Autowired;

public class SetterInjectedOtherBeanB {
    private OtherBeanB otherBeanB;

    @Autowired
        public void setOtherBeanB(OtherBeanB otherBeanB){
        this.otherBeanB = otherBeanB;
    }
}
