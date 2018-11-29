#eureka-service

打包启动
1.
--spring.config.location读取外部配置文件
java -jar eureka-service-0.0.1-SNAPSHOT.jar --spring.config.location=D:\change\eureka-service\src\main\resources\bootstrap-cluster1.yml

2.
--spring.profiles.active=cluster1读取jar内配置
java -jar eureka-service-0.0.1-SNAPSHOT.jar --spring.profiles.active=cluster1