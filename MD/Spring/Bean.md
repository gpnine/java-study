# 注册一个Bean
 1. 解析xml文件，获取document对象
 2. 取出相应的元素，存到相应的Bean对象中
 3. 将bean对象封装到Map集合中map.put(beanName,bean)
 4. 检查IOC容器中是否存在bean
 5. 通过反射创建对象