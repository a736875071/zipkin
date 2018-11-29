package com.service;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author YangQing
 * @version 1.0.0
 */
@org.springframework.cloud.netflix.feign.FeignClient(name = "zipkinStream-client2",
        fallback = FeignClientImpl.class)
public interface FeignClient {
    @RequestMapping("/user/{id}")
     String user(@PathVariable("id") String id);
}
