package spring;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.context.annotation.Import;

/**
 * web .
 *
 * @description: .
 * @author: Chenglin Zhu .
 * @date: 19-9-4 .
 */
@Configuration
@EnableAspectJAutoProxy
@Import(BeanConfig.class)
public class SpringConfiguration {
}
