package com.change.config;


import com.google.gson.Gson;
import com.netflix.appinfo.InstanceInfo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.cloud.netflix.eureka.server.event.*;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @author YangQing
 * @version 1.0.0
 */

@Component
public class EurekaStateChangeListener {
    private static final Logger logger = LoggerFactory.getLogger(EurekaStateChangeListener.class);
    @Autowired
    private DiscoveryClient discoveryClient;

    /**
     * 服务下线事件
     *
     * @param eurekaInstanceCanceledEvent
     */
    @EventListener
    public void listen(EurekaInstanceCanceledEvent eurekaInstanceCanceledEvent) {
        //服务断线事件
        String appName = eurekaInstanceCanceledEvent.getAppName();
        String serverId = eurekaInstanceCanceledEvent.getServerId();
        System.out.println(appName);
        System.out.println(serverId);
        logger.error("服务断线事件:服务名{},服务id{}", appName, serverId);
    }

    /**
     * 服务注册事件
     *
     * @param event
     */
    @EventListener
    public void listen(EurekaInstanceRegisteredEvent event) {
        InstanceInfo instanceInfo = event.getInstanceInfo();
        System.out.println(instanceInfo);
        logger.error("服务注册事件:服务名{},服务id{}", new Gson().toJson(instanceInfo));
    }

    /**
     * 服务续约事件
     *
     * @param event
     */
    @EventListener
    public void listen(EurekaInstanceRenewedEvent event) {
        event.getAppName();
        event.getServerId();
        logger.error("服务续约事件:服务名{},服务id{}", new Gson().toJson(event));
        List<ServiceInstance> list = discoveryClient.getInstances(event.getServerId());
        System.out.println(discoveryClient.getLocalServiceInstance());
        System.out.println("discoveryClient.getServices().size() = " + discoveryClient.getServices().size());

        for( String s :  discoveryClient.getServices()){
            System.out.println("services " + s);
            List<ServiceInstance> serviceInstances =  discoveryClient.getInstances(s);
            for(ServiceInstance si : serviceInstances){
                System.out.println("    services:" + s + ":getHost()=" + si.getHost());
                System.out.println("    services:" + s + ":getPort()=" + si.getPort());
                System.out.println("    services:" + s + ":getServiceId()=" + si.getServiceId());
                System.out.println("    services:" + s + ":getUri()=" + si.getUri());
                System.out.println("    services:" + s + ":getMetadata()=" + si.getMetadata());
            }

        }

        System.out.println(list.size());
        if (list != null && list.size() > 0 ) {
            System.out.println( list.get(0).getUri()  );
        }
    }

    /**
     * 注册中心启动事件
     *
     * @param event
     */
    @EventListener
    public void listen(EurekaRegistryAvailableEvent event) {
        logger.error("注册中心启动事件:服务名{},服务id{}", new Gson().toJson(event));

    }

    /**
     * 启动事件
     *
     * @param event
     */
    @EventListener
    public void listen(EurekaServerStartedEvent event) {
        //Server启动
        logger.error("注册中心启动事件:服务名{},服务id{}", new Gson().toJson(event));

    }

}
