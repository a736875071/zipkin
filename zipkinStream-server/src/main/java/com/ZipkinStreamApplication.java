package com;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.sleuth.zipkin.stream.EnableZipkinStreamServer;

/**
 * @author YangQing
 * @version 1.0.0
 */
//@EnableZipkinServer
@EnableZipkinStreamServer
@SpringBootApplication
@EnableEurekaClient
public class ZipkinStreamApplication {
    public static void main(String[] args) {
        SpringApplication.run(ZipkinStreamApplication.class, args);
    }
}
