package com.example.dubbo.controller;

import com.example.dubbo.api.ServiceA;
import com.example.dubbo.dto.MessageRequest;
import org.apache.dubbo.config.annotation.DubboReference;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class ServiceController {
    
    private static final Logger logger = LoggerFactory.getLogger(ServiceController.class);
    
    @DubboReference(timeout = 8000, retries = 0, scope = "remote")
    private ServiceA serviceA;
    
    @PostMapping("/call")
    public String callServiceB(@RequestBody MessageRequest request) {
        long startTime = System.currentTimeMillis();
        logger.info("【Controller】开始处理请求，msg={}, name={}", request.getMsg(), request.getName());
        
        String result = serviceA.callServiceB(request.getMsg(), request.getName());
        
        long endTime = System.currentTimeMillis();
        logger.info("【Controller】请求处理结束，总耗时={}ms，返回结果={}",
            (endTime - startTime),
            result);
            
        return result;
    }
}
