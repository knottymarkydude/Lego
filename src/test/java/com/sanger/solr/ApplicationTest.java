package com.sanger.solr;

import java.util.Arrays;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ComponentScan.Filter;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;

//@SpringBootApplication  // because it's on the root package
// @SpringBootApplication is same as adding all 3:
@Configuration
@EnableAutoConfiguration
@ComponentScan(basePackages = { "com.sanger.solr" }, excludeFilters = { @Filter(type = FilterType.ANNOTATION, value = Configuration.class) })
public class ApplicationTest {

    public static void main(String[] args) {
        //SpringApplication.run(Application.class, args);
        
        ApplicationContext ctx = SpringApplication.run(Application.class, args);
        System.out.println(ctx.getDisplayName());
        
        
        String[] beanNames = ctx.getBeanDefinitionNames();
        Arrays.sort(beanNames);
        for (String beanName : beanNames) {
            System.out.println(beanName);
        }
        
    }

}
