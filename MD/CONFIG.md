# 相关配置
- maven配置
在maven的apache-maven/confsetting.xml中配置仓库路径
```
<localRepository>改成你的路径</localRepository>
```
- [checkstyle.xml](https://github.com/gpnine/JAVAWeb-Advanced/blob/master/zcl-webapp/checkstyle.xml)  用于代码规范，在IDEA上安装插件，配置
- [.gitignore.xml](https://github.com/gpnine/JAVAWeb-Advanced/blob/master/zcl-webapp/.gitignore)  用于代码提交时忽略一些文件不予提交

* jndi连接
```
//env.properties配置
/*jdbc.sftqzk.jndiName=java\:comp/env/jdbc/sftqzk*/

//实际连接数据库dbname，jndi的配置name为这里的name
/*
<Resource autoConnectRetry="true" connectionsPerHost="100" dbname="justice-lams" factory="org.apache.naming.factory.BeanFactory" host="10.222.1.14" maxWaitTime="20000" name="mongodb/justice-lams" port="27017" type="com.homolo.mongo.MongoDBSource"/>
*/
//继承这个类extends Initializer------------------------------------------------------------------
@Value("${jdbc.sftqzk.jndiName}")
private String jndiName;

@Override
public void initialize() {
	try {
		Context context = new InitialContext();
		DataSource dataSource = (DataSource) context.lookup(this.jndiName);
		this.jt = new JdbcTemplate(dataSource);
	} catch (NamingException e) {
		this.LOGGER.error("(⊙﹏⊙✿)(⊙﹏⊙✿)(⊙﹏⊙✿)(⊙﹏⊙✿) no data source found with name:{}, can't sync big data.{}", this.jndiName, e.getLocalizedMessage());
	}
}
```
<code>配置bean</code>
```
@Bean(name = "tk.file.datasource.mongodb")
Object fileMongoSource(@Value("${tk.file.mongodb.jndiName}") String jndiName) {
	JndiObjectFactoryBean factory = new JndiObjectFactoryBean();
	factory.setJndiName(jndiName);
	return factory;
}
```

- jdbc链接
```
//pom配置
/*
<dependency>
	<groupId>mysql</groupId>
	<artifactId>mysql-connector-java</artifactId>
	<version>5.1.30</version>
</dependency>
*/
//env.properties配置
/*
mysql.data.url=jdbc:mysql://localhost:3306/xjxzxk?useUnicode=true&characterEncoding=utf-8&useSSL=true
mysql.data.user=root
mysql.data.password=123456
*/
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
