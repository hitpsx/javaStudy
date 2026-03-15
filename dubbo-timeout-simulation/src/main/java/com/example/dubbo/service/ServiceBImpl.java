package com.example.dubbo.service;

import com.example.dubbo.api.ServiceB;
import com.example.dubbo.api.ServiceC;
import org.apache.dubbo.config.annotation.DubboReference;
import org.apache.dubbo.config.annotation.DubboService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@DubboService(timeout = 8000, retries = 0)
public class ServiceBImpl implements ServiceB {
    
    private static final Logger logger = LoggerFactory.getLogger(ServiceBImpl.class);
    
    @DubboReference(timeout = 5000, retries = 0, scope = "remote")
    private ServiceC serviceC;
    
    @Override
    public String forwardRequest(String msg, String name) {
        long startTime = System.currentTimeMillis();
        logger.info("【ServiceB】开始调用，msg={}, name={}", msg, name);
        
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
        
        long beforeCallTime = System.currentTimeMillis();
        String result = serviceC.sayHello(msg, name);
        long afterCallTime = System.currentTimeMillis();
        
        logger.info("【ServiceB】调用结束，总耗时={}ms，自身处理耗时={}ms，调用ServiceC耗时={}ms，返回结果={}",
            (afterCallTime - startTime),
            (beforeCallTime - startTime),
            (afterCallTime - beforeCallTime),
            result);
            
        return result;
    }
}
