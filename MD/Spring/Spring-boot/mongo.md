#  mongodb连接
Spring-boot

## 连接mongodb
```xml
<dependency>
	<groupId>org.springframework.boot</groupId>
	<artifactId>spring-boot-starter-data-mongodb</artifactId>
</dependency>
```
在application.properties中配置数据库连接

```properties
# Mongo连接
spring.data.mongodb.uri=mongodb://localhost:27017/test
```
连接本地redis
```command
	mongo
	db
	db.help
	db.dog.find()
	db.dog.find().help()
	# 查询所有数据
	db.dog.find().pretty()
```

> JPARepository和MongoRepository是Spring Data Repositories的特定于技术的抽象。

> 如果您使用的是RDBMS，例如MySQL / PostgreSQL，则可以使用Spring Data Repositories，例如JpaRepository。如果使用像Mongo这样的NoSQL，你将需要MongoReposiroty。

- [mongo要存储的实体](https://github.com/gpnine/java-study/blob/master/spring-boot1/src/main/java/com/example/springboot1/domain/Dog.java)
- [实体数据访问对象](https://github.com/gpnine/java-study/blob/master/spring-boot1/src/main/java/com/example/springboot1/domain/DogRepository.java)
- [测试](https://github.com/gpnine/java-study/blob/master/spring-boot1/src/test/java/com/example/springboot1/MongoTests.java)