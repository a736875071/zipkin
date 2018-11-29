package com.service;

import org.springframework.stereotype.Service;

/**
 * @author YangQing
 * @version 1.0.0
 */
@Service
public class FeignClientImpl implements FeignClient {
    @Override
    public String user(String id) {
        return null;
    }
}
