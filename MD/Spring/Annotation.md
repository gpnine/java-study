# 注解

## @Configuration

1. 从Spring3.0，@Configuration用于定义配置类，可替换xml配置文件，被注解的类内部包含有一个或多个被@Bean注解的方法，这些方法将会被AnnotationConfigApplicationContext或AnnotationConfigWebApplicationContext类进行扫描，并用于构建bean定义，初始化Spring容器。
2. https://www.cnblogs.com/duanxz/p/7493276.html

## @Component

- 注解表明一个类会作为组件类，并告知Spring要为这个类创建bean。

## @Bean

1. 注解告诉Spring这个方法将会返回一个对象，这个对象要注册为Spring应用上下文中的bean。通常方法体中包含了最终产生bean实例的逻辑。
2. 当我们引用第三方库中的类需要装配到Spring容器时，则只能通过@Bean来实
  现
3. 只能用于在配置类中显式声明单个bean

> 相当于xml中的配置```
<context:component-scan base-package="com.zxt" />```,@Component和@Bean都是用来注册Bean并装配到Spring容器中，但是Bean比Component的自定义性更强。可以实现一些Component实现不了的自定义加载类

### @Scope注解
 - Spring默认产生的bean是单例的，如果不想使用单例，xml文件里面可以在bean里面配置scope属性。注解也一 样，配置@Scope即可，默认是"singleton"即单例，"prototype"表示原型即每次都会new一个新的出来

## @Controller 控制器（注入服务）

- 用于标注控制层，相当于struts中的action层

## @Service 服务（注入dao）

- 用于标注服务层，主要用来进行业务的逻辑处理

## @Repository（实现dao访问）

- 用于标注数据访问层，也可以说用于标注数据访问组件，即DAO组件

## @PostConstruct

1. 在生成对象时需要完成某些初始化操作，而偏偏这些初始化操作又依赖于依赖注入，那么久无法在构造函数中实现。为此，可以使用@PostConstruct注解一个方法来完成初始化
2. 不直接在构造函数初始化,因为构造函数可能被多次调用,而初始化操作只进行一次操作
3. https://www.jianshu.com/p/98cf7d8b9ec3

## @Autowired

1. @Autowired是spring自带的注解，通过‘AutowiredAnnotationBeanPostProcessor’ 类实现的依赖注入；
2. @Autowired是根据类型进行自动装配的，如果需要按名称进行装配，则需要配合@Qualifier；
3. @Autowired有个属性为required，可以配置为false，如果配置为false之后，当没有找到相应bean的时候，系统不会抛错；
4. @Autowired可以作用在变量、setter方法、构造函数上。
5. ``` <bean id="school" class="com.zxt.bean.School" ><property name="teacher" ref="teacher" /><property name="student" ref="student" /></bean> ```

### @Qualifier 有多个实现类时,不知道注入的接口注入的是哪一个时应用

- @Qualifier注解括号里面的必须是Person接口实现类的类名，不是bean的名字。写成"doctor"，结果会报错

## @Resource (J2EE的注解)

1. @Resource后面没有任何内容，默认通过name属性去匹配bean，找不到再按type去匹配。
2. 指定了name或者type则根据指定的类型去匹配bean。
3. 指定了name和type则根据指定的name和type去匹配bean，任何一个不匹配都会报错。

### @Autowired和@Resource两个注解的区别：

1. @Autowired默认按照byType方式进行bean匹配，@Resource默认按照byName方式
2. 进行bean匹配
3. @Autowired是Spring的注解，@Resource是J2EE的注解，根据导入注解的包名就可以知道。
Spring属于第三方的，J2EE是Java自己的东西。因此，建议使用@Resource注解，以减少代码和Spring之间的耦合。
4. https://www.cnblogs.com/pjfmeng/p/7551340.html

## @ComponentScan(basePackages = { "com.project.*" })

1. Bean扫描器
2. xml中配置```<context:component-scan base-package=“com.project.*”/>```
3. 某个类上带有特定的注解@Component、@Repository、@Service或@Controller，就会将这个对象作为Bean注入进spring容器
4. 子标签：context:include-filter和context:exclude-filter
5. https://www.jianshu.com/p/931cdba58cf7
  
## 注:spring并不支持不同的包下类名相同的设定

1. 对bean显式命名，@Service("yourName")
2. 使用xml的方式声明bean
