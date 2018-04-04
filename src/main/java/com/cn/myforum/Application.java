package com.cn.myforum;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.core.env.Environment;

import java.net.UnknownHostException;

// same as @Configuration @EnableAutoConfiguration @ComponentScan
@SpringBootApplication
@ComponentScan("com.cn") //指定扫描的mapper接口所在的包


public class Application {
    public static void main(String[] args) throws UnknownHostException {
        SpringApplication app = new SpringApplication(Application.class);
        Environment environment = app.run(args).getEnvironment();
    }
}