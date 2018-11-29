#zipkin

启动顺序：注册中心（eureka）->zipkinStream-server->zipkinStream-client1,zipkinStream-client2

该例子基于mq异步方式通信,并将结果持久化到数据库,好像现在只支持mysql,
有以下好处:
1）请求的耗时时间不会出现突然耗时特长的情况
2）当ZipkinServer不可用时（比如关闭、网络不通等），追踪信息不会丢失，因为这些信息会保存在Rabbitmq服务器上，直到Zipkin服务器可用时，再从Rabbitmq中取出这段时间的信息
如果采用http形式,数据是存放在内存中的
如果不想将结果持久化到数据库,只需要将
        <!--基于mq-->
        <dependency>
            <groupId>org.springframework.cloud</groupId>
            <artifactId>spring-cloud-sleuth-zipkin-stream</artifactId>
        </dependency>
        
  注释掉,并且放开
            <!--基于http-->
          <dependency>
              <groupId>io.zipkin.java</groupId>
              <artifactId>zipkin-server</artifactId>
          </dependency>
          
  zipkinStream-server,zipkinStream-client1,zipkinStream-client2服务中将数据库,mq相关配置删除,
 同时放开 @EnableZipkinServer
 注释  @EnableZipkinStreamServer
 
 