# Dubbo Timeout Simulation

基于Spring Boot和Dubbo 3.x的分布式服务超时模拟示例，实现A → B → C的调用链路，针对高并发场景进行了优化配置。

## 项目结构

```
dubbo-timeout-simulation/
├── src/main/java/com/example/dubbo/
│   ├── api/                    # 服务接口定义
│   │   ├── ServiceA.java
│   │   ├── ServiceB.java
│   │   └── ServiceC.java
│   ├── service/                # 服务实现
│   │   ├── ServiceAImpl.java
│   │   ├── ServiceBImpl.java
│   │   └── ServiceCImpl.java
│   ├── controller/             # HTTP接口
│   │   └── ServiceController.java
│   ├── dto/                    # 数据传输对象
│   │   └── MessageRequest.java
│   └── DubboApplication.java   # 启动类
└── src/main/resources/
    └── application.yml         # 配置文件
```

## 技术栈

- Spring Boot 2.7.18
- Dubbo 3.2.5
- Zookeeper 3.7.0
- Maven

## 服务调用链路

```
HTTP请求 → Controller → ServiceA → ServiceB → ServiceC
```

## 环境准备

### 1. 安装Zookeeper

```bash
# Windows
bin/zkServer.cmd

# Linux/Mac
bin/zkServer.sh start
```

默认端口: 2181

### 2. 构建项目

```bash
mvn clean install
```

## 启动步骤

1. 启动Zookeeper
2. 启动应用: `mvn spring-boot:run` 或运行 `DubboApplication`
3. 测试接口

## 接口测试

### POST接口

```bash
curl -X POST http://localhost:8088/api/call \
  -H "Content-Type: application/json" \
  -d '{"msg":"hello","name":"world"}'
```

### 预期返回

```
world: hello
```

## 高并发配置说明

### 超时时间配置

| 服务 | 提供者超时 | 消费者超时 |
|------|------------|------------|
| ServiceA | 8000ms | 8000ms |
| ServiceB | 8000ms | 5000ms |
| ServiceC | 5000ms | - |

### 重试次数

所有服务均设置为 `retries = 0`，避免高并发场景下的雪崩效应。

### 线程池配置

- 业务线程池: 500线程
- 最大连接数: 1000
- Tomcat线程: 500

## 耗时统计

每个服务都会打印详细的耗时日志：

```
【Controller】开始处理请求，msg=hello, name=world
【ServiceA】开始调用，msg=hello, name=world
【ServiceB】开始调用，msg=hello, name=world
【ServiceC】开始调用，msg=hello, name=world
【ServiceC】调用结束，总耗时=2000ms，返回结果=world: hello
【ServiceB】调用结束，总耗时=3000ms，自身处理耗时=1000ms，调用ServiceC耗时=2000ms
【ServiceA】调用结束，总耗时=3100ms，自身处理耗时=100ms，调用ServiceB耗时=3000ms
【Controller】请求处理结束，总耗时=3150ms，返回结果=world: hello
```

## 注意事项

1. 确保Zookeeper已启动
2. 端口8088和20880未被占用
3. 使用 `scope = "remote"` 强制远程调用，避免本地调用优化

## 许可证

MIT License
