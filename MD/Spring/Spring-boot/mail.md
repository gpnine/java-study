#  使用JavaMailSender发送邮件

```xml
<dependency>
	<groupId>org.springframework.boot</groupId>
	<artifactId>spring-boot-starter-mail</artifactId>
</dependency>
```

```properties
spring.mail.host=smtp.qq.com
spring.mail.username=用户名(改成你的qq邮箱名)
spring.mail.password=密码(改成授权码)
spring.mail.properties.mail.smtp.auth=true
spring.mail.properties.mail.smtp.starttls.enable=true
spring.mail.properties.mail.smtp.starttls.required=true
```

- [QQ邮箱设置授权码](https://service.mail.qq.com/cgi-bin/help?subtype=1&&id=28&&no=1001256)

> 使用JavaMailSender发送邮件
* 发送简单邮件SimpleMailMessage
* 发送带有附件MimeMessage （通过MimeMessageHelper来发送一封带有附件的邮件）
* 嵌入静态资源(addInline函数中资源名称weixin需要与正文中cid:weixin对应起来)
* 模板邮件
## 模板邮件
```xml
<!-- 引入带有版本的velocity -->
<dependency>
	<groupId>org.apache.velocity</groupId>
	<artifactId>velocity</artifactId>
	<version>1.6.4</version>
</dependency>
```
- [VelocityEngineUtils在spring3.2中被删除](https://stackoverflow.com/questions/14314143/velocityengineutils-has-been-removed-in-spring-3-2-so-what-else-to-use)

## 异常
535:密码改成授权码

501:帐号是否不同

VelocityEngineBean bean注入不了，新建一个子类继承VelocityEngineBean，加上@Component注解后引用这个子类

- [测试用例](https://github.com/gpnine/java-study/blob/master/spring-boot1/src/test/java/com/example/springboot1/MailTests.java)