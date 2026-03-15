package com.example.dubbo.dto;

public class MessageRequest {
    private String msg;
    private String name;

    public MessageRequest() {
    }

    public MessageRequest(String msg, String name) {
        this.msg = msg;
        this.name = name;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "MessageRequest{msg='" + msg + "', name='" + name + "'}";
    }
}
