# RabbitMq  
## 安装:
```

 sudo apt-get install erlang
 sudo apt-get install rabbitmq-server

运行
 service rabbitmq-server start 
 service rabbitmq-server status 查看状态
 service rabbitmq-server stop

rabbitmq-server （前台启动）或者rabbitmq-server -detached（后台启动）
http://localhost:15672
报错

报错:node with name ”rabbit“ already running”, but also “unable to connect to node 'rabbit'”
ps aux | grep erl
kill -9 该进程

问题
启动RabbitMQ后，没法访问Web管理页面
解决
RabbitMQ安装后默认是不启动管理模块的，所以需要配置将管理模块启动 
启动管理模块命令如下
 rabbitmqctl start_app
 rabbitmq-plugins enable rabbitmq_management
 rabbitmqctl stop
```
## 异常
- [org.springframework.amqp.AmqpIOException: java.io.IOException](https://blog.csdn.net/qq_22638399/article/details/81705606)
- org.springframework.amqp.AmqpTimeoutException: java.util.concurrent.TimeoutException 连接失败，端口不是5672,不是15672（web管理界面ui端口）