package com.change.config;

import com.netflix.appinfo.HealthCheckHandler;
import com.netflix.appinfo.InstanceInfo.InstanceStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.actuate.health.Status;
import org.springframework.stereotype.Component;

/**
 *
 * @author YangQing
 * @version 1.0.0
 */

@Component
public class MyHealthCheckHandler implements HealthCheckHandler {

    @Autowired
    private MyHealthIndicator myHealthIndicator;

    @Override
    public InstanceStatus getStatus(InstanceStatus instanceStatus) {
        Status status = myHealthIndicator.health().getStatus();
        if (status.equals(Status.UP)) {
            return InstanceStatus.UP;
        } else {
            return InstanceStatus.DOWN;
        }
    }

}
