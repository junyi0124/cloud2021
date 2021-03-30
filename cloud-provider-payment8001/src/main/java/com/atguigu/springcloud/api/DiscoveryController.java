package com.atguigu.springcloud.api;

import com.atguigu.springcloud.common.CommonResult;
import com.netflix.appinfo.InstanceInfo;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

@RestController
@RequestMapping("/api/discovery")
@Slf4j
public class DiscoveryController {

    @Autowired
    private DiscoveryClient _discoveryClient;


    @GetMapping()
    public CommonResult discovery() {
        //_discoveryClient.getApplications().getRegisteredApplications().stream().forEach(x->log.info(x.getName()));
        _discoveryClient.getServices().forEach(x->log.info(x));


        //List<InstanceInfo> instances = _discoveryClient.getApplication("cloud-payment-service").getInstances();
        List<ServiceInstance> instances = _discoveryClient.getInstances("cloud-payment-service");
        for(ServiceInstance instance:instances) {
            log.info("********" + instance.getUri());
        }

        return new CommonResult(200, "", instances);
    }
}
