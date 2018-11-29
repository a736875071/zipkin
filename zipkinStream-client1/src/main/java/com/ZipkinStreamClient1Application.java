package com;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.feign.EnableFeignClients;

/**
 * @author YangQing
 * @version 1.0.0
 */
@SpringBootApplication
@EnableEurekaClient
@EnableFeignClients
public class ZipkinStreamClient1Application{
    public static void main(String[] args) {
        SpringApplication.run(ZipkinStreamClient1Application.class,args);
    }

}
