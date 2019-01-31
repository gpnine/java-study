# 相关配置
### maven配置
在maven的apache-maven/confsetting.xml中配置仓库路径
```
<localRepository>改成你的路径</localRepository>
```
### [checkstyle.xml](https://github.com/gpnine/JAVAWeb-Advanced/blob/master/zcl-webapp/checkstyle.xml)  用于代码规范，在IDEA上安装插件，配置
### [.gitignore.xml](https://github.com/gpnine/JAVAWeb-Advanced/blob/master/zcl-webapp/.gitignore)  用于代码提交时忽略一些文件不予提交

### jndi连接
<code>[相关链接](https://www.cnblogs.com/xdp-gacl/p/4040019.html)</code>
```
<!-- 在tomcatde的lib文件夹下添加druid-1.1.12.jar和mysql-connector-java-6.0.6.jar -->
<!-- env.properties配置
jdbc.project.jndiName=java\:comp/env/jdbc/project
-->
```
实际连接数据库dbname，jndi的配置tomcat>conf>[context.xml](https://github.com/gpnine/JAVAWeb-Advanced/blob/master/context.xml)
```
<!-- 注入文件
<context:property-placeholder location="classpath:env.properties"/>
等效于注入
@Configuration
@PropertySource(name = "web.env", value = "classpath:env.properties")
-->
<!--
@Value("${jdbc.project.jndiName}")
private String jndiName;
会得到java\:comp/env/jdbc/project
通过jdbc/project找到对应的数据库
-->
```
通过这个name找到对应的
[数据源](https://github.com/gpnine/JAVAWeb-Advanced/blob/master/zcl-webapp/src/main/java/com/project/controller/LoginController.java)
```
Context context = new InitialContext();
DataSource dataSource = (DataSource) context.lookup(this.jndiName);
```


### jdbc链接
```
//pom配置
<dependency>
	<groupId>mysql</groupId>
	<artifactId>mysql-connector-java</artifactId>
	<version>5.1.30</version>
</dependency>
//env.properties配置
<!--
mysql.data.url=jdbc:mysql://localhost:3306/xjxzxk?useUnicode=true&characterEncoding=utf-8&useSSL=true
mysql.data.user=root
mysql.data.password=123456
-->
-------------------------------------------------------------------------------------------------
@Value("${mysql.data.url}")
private String URL;
@Value("${mysql.data.user}")
private String USER;
@Value("${mysql.data.password}")
private String PASSWORD;

@PostConstruct
public void init() {
    DriverManagerDataSource source = new DriverManagerDataSource();
    source.setDriverClassName("com.mysql.jdbc.Driver");
    source.setUrl(URL);
    source.setUsername(USER);
    source.setPassword(PASSWORD);
    jt = new JdbcTemplate(source);
}
```
