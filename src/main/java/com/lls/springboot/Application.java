package com.lls.springboot;
 
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import javax.sql.DataSource;


@SpringBootApplication
public class Application {
 
    public static void main(String[] args) {
//        SpringApplication.run(Application.class, args);
        ConfigurableApplicationContext context = SpringApplication.run(Application.class, args);
        DataSource dataSource = context.getBean(DataSource.class);

        System.out.println(dataSource.getClass());
    }
 
}