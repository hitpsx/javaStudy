package com.example.dubbo.api;

import org.apache.dubbo.config.annotation.DubboReference;


public interface ServiceB {
    String forwardRequest(String msg, String name);
}
