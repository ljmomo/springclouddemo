package com.junli.springclouddemo;

import com.junli.dto.User;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author lijun
 * @time 2017-12-28 17:10
 */
@RestController
public class HelloController {
    private  final Logger logger = Logger.getLogger(getClass());

    @Autowired
    private DiscoveryClient client;

    @GetMapping("/hello")
    public  String index(){
        StringBuilder buf = new StringBuilder();
        List<String> serviceIds = client.getServices();
        if(!CollectionUtils.isEmpty(serviceIds)){
            for(String s : serviceIds){
                System.out.println("serviceId:" + s);
                List<ServiceInstance> serviceInstances =  client.getInstances(s);
                if(!CollectionUtils.isEmpty(serviceInstances)){
                    for(ServiceInstance si:serviceInstances){
                        buf.append("["+si.getServiceId() +" host=" +si.getHost()+" port="+si.getPort()+" uri="+si.getUri()+"]");
                    }
                }else{
                    buf.append("no service.");
                }
            }
        }

        logger.info("/hello"+buf.toString());
        System.out.println("/hello"+buf.toString());
        return "Hello World";
    }


    @GetMapping("/hello1")
    public  String hello(@RequestParam String name){
        return "Hello  "+name;
    }

    @GetMapping("/hello2")
    public User hello(@RequestHeader String name, @RequestHeader Integer age){
        return new User(name,age);
    }

    @PostMapping("/hello3")
    public  String hello(@RequestBody User user){
        return "Hello  " + user.getName() + "," + user.getAge();
    }
}
