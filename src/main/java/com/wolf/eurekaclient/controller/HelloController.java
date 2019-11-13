package com.wolf.eurekaclient.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Slf4j
@RestController
public class HelloController {
    @Autowired
    private DiscoveryClient client;

    @GetMapping("/hello")
    public String index() {
        List<ServiceInstance> instances = client.getInstances("hello-service");
        for (ServiceInstance instance : instances) {
            log.info("/hello, host: " + instance.getHost() + " , service_id: " + instance.getServiceId());
        }
        return "Hello World!";
    }
}
