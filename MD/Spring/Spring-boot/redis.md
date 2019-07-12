#  redis连接
Spring-boot

## 连接redis
```xml
<dependency>
	<groupId>org.springframework.data</groupId>
	<artifactId>spring-data-redis</artifactId>
</dependency>
<dependency>
	<groupId>redis.clients</groupId>
	<artifactId>jedis</artifactId>
</dependency>
```
在application.properties中配置数据库连接

```properties
# REDIS (RedisProperties)
# Redis数据库索引(默认为0)
spring.redis.database=0
# Redis服务器地址
spring.redis.host=127.0.0.1
# Redis服务器连接端口
spring.redis.port=6379
# Redis服务器连接密码（默认为空）
spring.redis.password=
# 连接池最大连接数（使用负值表示没有限制）
spring.redis.jedis.pool.max-active=8
# 连接池最大阻塞等待时间（使用负值表示没有限制）
spring.redis.jedis.pool.max-wait=-1
# 连接池的最大空闲连接
spring.redis.jedis.pool.max-idle=8
# 连接池的最小空闲连接
spring.redis.jedis.pool.min-idle=0
# 连接超时时间（毫秒）
spring.redis.timeout=5000
```
连接本地redis
```command
	redis-cli
	get key
```

通过自动配置的StringRedisTemplate对象进行Redis的读写操作
- [StringRedisTemplate操作](https://github.com/gpnine/java-study/blob/master/spring-boot1/src/test/java/com/example/springboot1/RedisTests.java)

除了String类型，实战中我们还经常会在Redis中存储对象
- [序列化实体类](https://github.com/gpnine/java-study/blob/master/spring-boot1/src/main/java/com/example/springboot1/domain/User.java)
- [实现对象的序列化接口](https://github.com/gpnine/java-study/blob/master/spring-boot1/src/main/java/com/example/springboot1/RedisObjectSerializer.java)
- [配置针对User的RedisTemplate实例](https://github.com/gpnine/java-study/blob/master/spring-boot1/src/main/java/com/example/springboot1/RedisConfig.java)
- [RedisTemplate操作](https://github.com/gpnine/java-study/blob/master/spring-boot1/src/test/java/com/example/springboot1/RedisObjectTests.java)