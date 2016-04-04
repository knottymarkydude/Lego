package com.sanger.solr;

import java.util.Arrays;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication  // because it's on the root package
// @SpringBootApplication is same as adding all 3:
// @Configuration, @EnableAutoConfiguration, @ComponentScan
public class Application {

    
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
