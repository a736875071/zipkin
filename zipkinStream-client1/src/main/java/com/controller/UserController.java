package com.controller;

import com.service.FeignClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.sleuth.sampler.AlwaysSampler;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 * @author YangQing
 * @version 1.0.0
 */
@RestController
public class UserController {

    @Autowired
    private FeignClient feignClient;
    @Autowired
    private RestTemplate restTemplate;

    @Bean
    public RestTemplate getRestTemplate() {
        return new RestTemplate();
    }

    @RequestMapping("/user/{id}")
    public String user(@PathVariable String id) {
        String result = this.restTemplate.getForObject("http://localhost:8802/user/" + id, String.class);
        return result + " world";
    }

    @RequestMapping("/user/feign/{id}")
    public String feignuser(@PathVariable String id) {
        String result = feignClient.user(id);
        return result + " world";
    }

    @Bean
    public AlwaysSampler defaultSampler() {
        return new AlwaysSampler();
    }
}
