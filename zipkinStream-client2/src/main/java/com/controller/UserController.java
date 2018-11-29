package com.controller;

import org.springframework.cloud.sleuth.sampler.AlwaysSampler;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author YangQing
 * @version 1.0.0
 */
@RestController
public class UserController {


    @RequestMapping("/user/{id}")
    public String user(@PathVariable String id) {
        return "hello" + id;
    }

    @Bean
    public AlwaysSampler defaultSampler() {
        return new AlwaysSampler();
    }
}
