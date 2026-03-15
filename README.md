# Java Study Projects

日常问题模拟和排除的工程集合，包含多个技术栈的实践项目。

## 项目结构

```
javaStudy/
├── dubbo-timeout-simulation/    # Dubbo分布式服务超时模拟
└── thread/                        # 线程学习项目
```

## 项目说明

### 1. Dubbo Timeout Simulation

**路径**: `dubbo-timeout-simulation/`

**描述**: 基于Spring Boot和Dubbo 3.x的分布式服务超时模拟示例

**技术栈**:
- Spring Boot 2.7.18
- Dubbo 3.2.5
- Zookeeper 3.7.0

**功能**:
- 实现A → B → C的调用链路
- 高并发场景优化配置
- 详细的耗时统计日志
- 超时和重试机制配置

**启动方式**:
```bash
cd dubbo-timeout-simulation
mvn spring-boot:run
```

**测试接口**:
```bash
curl -X POST http://localhost:8088/api/call \
  -H "Content-Type: application/json" \
  -d '{"msg":"hello","name":"world"}'
```

### 2. Thread Study

**路径**: `thread/`

**描述**: Java多线程基础学习项目

**技术栈**:
- Java 8+
- Maven

**功能**:
- 无返回值线程实现
- 有返回值线程实现
- Callable接口使用

**启动方式**:
```bash
cd thread
mvn compile exec:java -Dexec.mainClass="com.psx.service.thread.simpleTread.noReturn.runableStudy"
```

## 环境要求

### 通用要求
- JDK 8+
- Maven 3.6+
- IDE (IntelliJ IDEA / Eclipse)

### Dubbo项目额外要求
- Zookeeper 3.7.0+
- 确保端口2181、8088、20880未被占用

## 开发指南

### 1. 克隆项目
```bash
git clone <repository-url>
cd javaStudy
```

### 2. 选择项目
根据需要选择相应的子项目进行学习和测试。

### 3. 构建项目
```bash
# Dubbo项目
cd dubbo-timeout-simulation
mvn clean install

# Thread项目
cd thread
mvn clean compile
```

### 4. 运行项目
参考各子项目的README文档。

## 学习路径建议

### 初学者
1. **Thread Study** → 学习Java多线程基础
2. **Dubbo Timeout Simulation** → 学习分布式服务调用

### 进阶学习
1. **Dubbo Timeout Simulation** → 深入理解高并发场景
2. **Thread Study** → 掌握并发编程

## 常见问题

### Dubbo项目
- **Q**: Zookeeper连接失败
  **A**: 检查Zookeeper是否启动，端口2181是否正常监听

- **Q**: 服务调用超时
  **A**: 检查超时配置是否合理，参考README中的配置说明

### Thread项目
- **Q**: 编译失败
  **A**: 检查JDK版本是否为8+

## 贡献指南

欢迎提交Issue和Pull Request来改进这些学习项目。

## 许可证

MIT License
