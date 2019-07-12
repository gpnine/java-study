#  搭建一个springboot项目
Spring-boot

## 创建一个spring-boot项目

* 启动类放在根目录下（默认有@SpringBootApplication注解）
* pom.xml配置spring-boot 的相关jar包（设置一个parent,后面引入直接输对应单词，idea有默认提示）
* application.properties或application.yml配置文件

## 写一个接口
* 默认会扫描到根目录下文件
```
@RestController
public class HelloController {
	@RequestMapping("/hello")
	public String index() {
		return "Hello World!!!";
	}
}
```
启动项目后访问localhost:8080/hello
