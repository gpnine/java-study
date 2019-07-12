#  mysql连接
Spring-boot

## 连接mysql
```xml
<dependency>
	<groupId>mysql</groupId>
	<artifactId>mysql-connector-java</artifactId>
	<version>5.1.21</version>
</dependency>
```
在application.properties中配置数据库连接

```properties
# 因为连接池的实际类型没有被公开，所以在您的自定义数据源的元数据中没有生成密钥，而且在IDE中没有完成(因为DataSource接口没有暴露属性)。另外，如果您碰巧在类路径上有Hikari，那么这个基本设置就不起作用了，因为Hikari没有url属性(但是确实有一个jdbcUrl属性)。在这种情况下，spring-datasource-url需要改成spring.datasource.jdbc-url

spring.datasource.jdbc-url=jdbc:mysql://localhost:3306/test?autoReconnect=true&useUnicode=true&characterEncoding=UTF-8&useSSL=false&useLegacyDatetimeCode=false&serverTimezone=Asia/Shanghai
spring.datasource.username=root
spring.datasource.password=123456
spring.datasource.driver-class-name=com.mysql.jdbc.Driver

spring.jpa.properties.hibernate.hbm2ddl.auto=create-drop
```
spring.jpa.properties.hibernate.hbm2ddl.auto是hibernate的配置属性，其主要作用是：自动创建、更新、验证数据库表结构。该参数的几种配置如下：
* validate               加载hibernate时，验证创建数据库表结构
* create                  每次加载hibernate，重新创建数据库表结构，这就是导致数据库表数据丢失的原因。
* create-drop        加载hibernate时创建，退出是删除表结构
* update                 加载hibernate自动更新数据库结构

参阅：https://blog.csdn.net/lgq_0714/article/details/4814693 

## JdbcTemplate
<em>通过sql语句或对应的方法操作数据库</em>
```xml
<dependency>
	<groupId>org.springframework.boot</groupId>
	<artifactId>spring-boot-starter-jdbc</artifactId>
</dependency>
```

##  Java Persistence API
<em>JPA通过orm对象关系映射操作对象来操作数据库</em>
```xml
<dependency
    <groupId>org.springframework.boot</groupId>
    <artifactId>spring-boot-starter-data-jpa</artifactId>
</dependency>
```

> JPA:将实体对象持久化到数据库中，通过ORM框架其会被映射到数据库表中，由于配置了hibernate.hbm2ddl.auto，在应用启动的时候框架会自动去数据库中创建对应的表
* @Table(name="JPA_CUSTOMERS") 需要对应的表名，默认就是类名
* @Entity 注解到类上，类会在数据库中生成对应的表
* @Id 主键
* @GeneratedValue(strategy = GenerationType.AUTO)
	* AUTO 
          表示持久性提供程序应为特定数据库选择适当的策略。
	* IDENTITY 
          指示持久性提供程序必须使用数据库标识列为实体分配主键。
	* SEQUENCE 
          指示持久性提供程序必须使用数据库序列列为实体分配主键。
	* TABLE 
          指示持久性提供程序必须使用基础数据库表为实体分配主键，以确保唯一性。
* @Column(name="LAST_NAME")
	* 属性或方法级别的注解，用于指定持久化属性映射到数据库表的列。如果没有指定列注释，则使用其默认值。

##	创建数据访问接口
下面针对实体创建对应的Repository接口实现对该实体的数据访问

接口继承JpaRepository，JpaRepository接口本身已经实现了创建（save）、更新（save）、删除（delete）、查询（findAll、findOne）等基本操作的函数，因此对于这些基础操作的数据访问就不需要开发者再自己定义。

## 多数据源
```properties
spring.datasource.primary.jdbc-url=jdbc:mysql://localhost:3306/test?autoReconnect=true&useUnicode=true&characterEncoding=UTF-8&useSSL=false&useLegacyDatetimeCode=false&serverTimezone=Asia/Shanghai
spring.datasource.primary.username=root
spring.datasource.primary.password=123456
spring.datasource.primary.driver-class-name=com.mysql.jdbc.Driver
spring.datasource.secondary.jdbc-url=jdbc:mysql://localhost:3306/test2?autoReconnect=true&useUnicode=true&characterEncoding=UTF-8&useSSL=false&useLegacyDatetimeCode=false&serverTimezone=Asia/Shanghai
spring.datasource.secondary.username=root
spring.datasource.secondary.password=123456
spring.datasource.secondary.driver-class-name=com.mysql.jdbc.Driver
```

JdbcTemplate支持

- [jpa持久化到数据库的类Person.java](https://github.com/gpnine/java-study/blob/master/spring-boot1/src/main/java/com/example/springboot1/domain/s/Person.java)
- [继承JpaRepository的类PersonRepository.java](https://github.com/gpnine/java-study/blob/master/spring-boot1/src/main/java/com/example/springboot1/domain/s/PersonRepository.java)
- [数据源配置DataSourceConfig.java](https://github.com/gpnine/java-study/blob/master/spring-boot1/src/main/java/com/example/springboot1/DataSourceConfig.java)
- [JdbcTemplate操作](https://github.com/gpnine/java-study/blob/master/spring-boot1/src/test/java/com/example/springboot1/MultipleDataSourcesTests.java)

JPA支持

- [第一个表的配置](https://github.com/gpnine/java-study/blob/master/spring-boot1/src/main/java/com/example/springboot1/PrimaryConfig.java)
- [第二个表的配置](https://github.com/gpnine/java-study/blob/master/spring-boot1/src/main/java/com/example/springboot1/SecondaryConfig.java)
- [jpa操作](https://github.com/gpnine/java-study/blob/master/spring-boot1/src/test/java/com/example/springboot1/JpaMultipleDataSourcesTests.java)