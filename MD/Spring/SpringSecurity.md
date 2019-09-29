# SpringSecurity
### 注解形式
- 1.pom.xml中添加依赖jar包
- 2.配置类添加注解，继承WebSecurityConfigurerAdapter
- 3.重写configure添加HttpSecurity（过滤器）认证
- 4.通过继承AbstractSecurityWebApplicationInitializer加入安全校验需要的Filter链
- 5.启用Spring Security，通过继承AbstractAnnotationConfigDispatcherServletInitializer初始化配置