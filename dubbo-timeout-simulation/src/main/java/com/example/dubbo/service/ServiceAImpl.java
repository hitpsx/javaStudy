package com.example.dubbo.service;

import com.example.dubbo.api.ServiceA;
import com.example.dubbo.api.ServiceB;
import org.apache.dubbo.config.annotation.DubboReference;
import org.apache.dubbo.config.annotation.DubboService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@DubboService(timeout = 8000, retries = 0)
public class ServiceAImpl implements ServiceA {
    
    private static final Logger logger = LoggerFactory.getLogger(ServiceAImpl.class);
    
    @DubboReference(timeout = 8000, retries = 0, scope = "remote")
    private ServiceB serviceB;
    
    @Override
    public String callServiceB(String msg, String name) {
        long startTime = System.currentTimeMillis();
        logger.info("【ServiceA】开始调用，msg={}, name={}", msg, name);
        
        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
        
        long beforeCallTime = System.currentTimeMillis();
        String result = serviceB.forwardRequest(msg, name);
        long afterCallTime = System.currentTimeMillis();
        
        logger.info("【ServiceA】调用结束，总耗时={}ms，自身处理耗时={}ms，调用ServiceB耗时={}ms，返回结果={}",
            (afterCallTime - startTime),
            (beforeCallTime - startTime),
            (afterCallTime - beforeCallTime),
            result);
            
        return result;
    }
}
