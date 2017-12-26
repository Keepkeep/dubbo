# dubbo 入门
***
##  理解dubbo的基本  官网:http://dubbo.io 
> Dubbo  是一个高性能，基于Java的RPC框架，由阿里巴巴开源。和许多RPC系统一样，dubbo基于定义一个服务的思想，指定可以通过参数和返回类型远程调用的方法。在服务器端，服务器实现这个接口并运行一个dubbo服务器来处理客户端调用。在客户端，客户端有一个存根，提供与服务器相同的方法。

![](http://dubbo.io/images//dubbo-architecture.png)

## 环境要求
- Linux 环境下配置好Zookeeper和Dubbo也可Window下配置 本次测试基于CentOS 7.4版本
- Eclipse 
- JDK：版本1.6或更高版本 
- Maven：版本3或更高
- Tomcat：版本7或更高

### 入门 消费者Maven Pom配置代码
```XML
<project xmlns="http://maven.apache.org/POM/4.0.0" xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
	xsi:schemaLocation="http://maven.apache.org/POM/4.0.0 http://maven.apache.org/xsd/maven-4.0.0.xsd">
	<modelVersion>4.0.0</modelVersion>
	<groupId>demo.dubbo</groupId>
	<artifactId>calcclient</artifactId>
	<version>0.0.1-SNAPSHOT</version>
	<dependencies>
		<dependency>
			<groupId>org.springframework</groupId>
			<artifactId>spring-context</artifactId>
			<version>4.3.10.RELEASE</version>
		</dependency>

		<dependency>
			<groupId>com.alibaba</groupId>
			<artifactId>dubbo</artifactId>
			<version>2.5.8</version>
		</dependency>

		<dependency>
			<groupId>com.101tec</groupId>
			<artifactId>zkclient</artifactId>
			<version>0.10</version>
		</dependency>
	</dependencies>
</project>
```
### 入门 消费者 XML配置代码
```XML
 <?xml version="1.0" encoding="UTF-8"?>
<beans xmlns="http://www.springframework.org/schema/beans"
	xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
	xmlns:context="http://www.springframework.org/schema/context"
	xmlns:dubbo="http://code.alibabatech.com/schema/dubbo"
	xsi:schemaLocation="http://www.springframework.org/schema/beans http://www.springframework.org/schema/beans/spring-beans.xsd
		http://www.springframework.org/schema/context http://www.springframework.org/schema/context/spring-context-4.3.xsd
		http://code.alibabatech.com/schema/dubbo http://code.alibabatech.com/schema/dubbo/dubbo.xsd">

	<dubbo:application name="calcclient-consumer"></dubbo:application>
	<dubbo:registry address="zookeeper://10.0.13.188:2181"></dubbo:registry>
	
	<dubbo:reference id="calcService"  interface="demo.calc.CalcService"></dubbo:reference>

</beans>
  
``` 
### 入门 消费者请求类测试
```Java
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestCalcClient {
	public static void main(String[] args) throws Exception {
		ApplicationContext context = new ClassPathXmlApplicationContext("/app-client.xml");
		CalcService calcservice =(CalcService)context.getBean("calcService"); //加载配置文件
		System.out.println(calcservice.add(100, 200));   //调用接口方法
		System.out.println(calcservice.multi(100, 200));
		System.in.read();
	}

}
```

