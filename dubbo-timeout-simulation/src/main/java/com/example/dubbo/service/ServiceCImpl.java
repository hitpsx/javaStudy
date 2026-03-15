package com.example.dubbo.service;

import com.example.dubbo.api.ServiceC;
import org.apache.dubbo.config.annotation.DubboService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@DubboService(timeout = 5000, retries = 0)
public class ServiceCImpl implements ServiceC {
    
    private static final Logger logger = LoggerFactory.getLogger(ServiceCImpl.class);
    
    @Override
    public String sayHello(String msg, String name) {
        long startTime = System.currentTimeMillis();
        logger.info("【ServiceC】开始调用，msg={}, name={}", msg, name);
        
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
        
        String result = name + ": " + msg;
        long endTime = System.currentTimeMillis();
        
        logger.info("【ServiceC】调用结束，总耗时={}ms，返回结果={}",
            (endTime - startTime),
            result);
            
        return result;
    }
}
