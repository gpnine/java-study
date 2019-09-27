package spring;

import com.project.entity.Student;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;

/**
 * web .
 *
 * @description: .
 * @author: Chenglin Zhu .
 * @date: 19-9-6 .
 */
@ComponentScan
public class BeanConfig {

	@Bean
	public Student student() {
		return new Student(11, "zcl");
	}
}
