package spring;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 * web .
 *
 * @description: .
 * @author: Chenglin Zhu .
 * @date: 19-9-6 .
 */
@Configuration
@ComponentScan(basePackages = { "com.project.*" })
public class BeanConfig {
}
