# Thread Study

Java多线程基础学习项目，包含无返回值和有返回值的线程实现示例。

## 项目结构

```
thread/
├── src/main/java/com/psx/service/thread/simpleTread/
│   ├── noReturn/              # 无返回值线程实现
│   │   ├── runableStudy.java
│   │   └── threadStudy.java
│   └── returnValue/           # 有返回值线程实现
│       └── callableStudy.java
└── pom.xml
```

## 技术栈

- Java 8+
- Maven

## 功能说明

### 1. 无返回值线程 (Runnable)

**类**: `runableStudy.java`
**接口**: `Runnable`
**功能**: 实现无返回值的多线程任务

**使用方式**:
```java
Runnable task = new runableStudy();
Thread thread = new Thread(task);
thread.start();
```

### 2. 有返回值线程 (Callable)

**类**: `callableStudy.java`
**接口**: `Callable<T>`
**功能**: 实现有返回值的多线程任务

**使用方式**:
```java
Callable<String> task = new callableStudy();
ExecutorService executor = Executors.newFixedThreadPool(1);
Future<String> future = executor.submit(task);
String result = future.get();
```

## 编译和运行

### 1. 编译项目
```bash
mvn clean compile
```

### 2. 运行无返回值示例
```bash
mvn exec:java -Dexec.mainClass="com.psx.service.thread.simpleTread.noReturn.runableStudy"
```

### 3. 运行有返回值示例
```bash
mvn exec:java -Dexec.mainClass="com.psx.service.thread.simpleTread.returnValue.callableStudy"
```

## 学习重点

### Runnable vs Callable

| 特性 | Runnable | Callable |
|------|----------|-----------|
| 返回值 | 无 | 有 |
| 抛异常 | 不能 | 可以 |
| 使用场景 | 简单任务 | 需要结果的任务 |

### 线程池使用

```java
// 创建线程池
ExecutorService executor = Executors.newFixedThreadPool(5);

// 提交任务
Future<String> future = executor.submit(new callableStudy());

// 获取结果
String result = future.get();

// 关闭线程池
executor.shutdown();
```

## 常见问题

### Q: 编译失败
**A**: 检查JDK版本是否为8+

### Q: 线程不执行
**A**: 检查是否调用了`start()`方法

### Q: 获取结果阻塞
**A**: 使用`Future.get(timeout, unit)`设置超时时间

## 进阶学习

1. **线程同步**: 学习synchronized、Lock等同步机制
2. **线程通信**: 学习wait/notify、Condition等通信方式
3. **线程池**: 深入理解ThreadPoolExecutor的使用
4. **并发工具**: 学习CountDownLatch、CyclicBarrier等工具类

## 许可证

MIT License
