package com.epam.spring.core.config;

import com.epam.spring.core.beans.beans3.BeanD;
import com.epam.spring.core.beans.beans3.BeanF;
import org.springframework.context.annotation.*;

@Configuration

@ComponentScans({
        @ComponentScan(basePackages = "com.epam.spring.core.beans.beans2"),
        @ComponentScan(
                basePackages = "com.epam.spring.core.beans.beans3",
                excludeFilters = {
                        @ComponentScan.Filter(type = FilterType.REGEX, pattern = "^(?!.*(.*BeanD)|(.*BeanF)).*")
                }
        )
})

public class AppConfig2 {

}
