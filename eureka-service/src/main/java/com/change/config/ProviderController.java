package com.change.config;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author YangQing
 * @version 1.0.0
 */
@RestController
public class ProviderController {
    public static Boolean isCanLinkDb = true;

    @RequestMapping(value = "/linkDb/{can}", method = RequestMethod.GET)
    public void LinkDb(@PathVariable Boolean can) {
        isCanLinkDb = can;
    }
}
