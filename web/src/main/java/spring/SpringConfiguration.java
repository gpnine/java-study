package spring;

import com.project.entity.Logging;
import com.project.entity.Student;
import org.springframework.context.annotation.Bean;
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
@Import({BeanConfig.class})
public class SpringConfiguration {

	@Bean
	public Student student() {
		return new Student(11, "zcl");
	}

	@Bean
	public Logging logging() {
		return new Logging();
	}
}
