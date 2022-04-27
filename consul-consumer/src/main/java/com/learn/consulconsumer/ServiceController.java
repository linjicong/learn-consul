package com.learn.consulconsumer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RefreshScope
public class ServiceController {

    @Autowired
    private LoadBalancerClient loadBalancerClient;
    @Autowired
    private DiscoveryClient discoveryClient;
    @Value("${test.a}")
    private String a;

    /**
     * 获取所有的服务
     *
     * @return
     */
    @RequestMapping("services")
    public Object getServices() {
        List<String> services = discoveryClient.getServices();
        System.out.printf("services:%s", services);
        List<ServiceInstance> instances = discoveryClient.getInstances("consul-producer");
        System.out.println(instances.toString());
        return instances;
    }

    /**
     * 轮训获取服务中的其中一个
     *
     * @return
     */
    @RequestMapping("discover")
    public String discover() {

        return loadBalancerClient.choose("consul-producer").toString();
    }

    /**
     * 获取配置文件
     *
     * @return
     */
    @RequestMapping("config")
    public String config() {
        return a;
    }
}
