package spring;

import com.project.service.MyUserDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.firewall.HttpFirewall;
import org.springframework.security.web.firewall.StrictHttpFirewall;

/**
 * web .
 *
 * @description: .
 * @author: Chenglin Zhu .
 * @date: 19-9-26 .
 */
@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(securedEnabled = true, jsr250Enabled = true, prePostEnabled = true)
public class SpringSecurityConfig extends WebSecurityConfigurerAdapter {

	// 配置PasswordEncoder
	@Bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}


	@Autowired
	private UserDetailsService detailsService() {
		return new MyUserDetailsService();
	}

	@Autowired
	private PasswordEncoder passwordEncoder;

	@Bean
	public DaoAuthenticationProvider daoAuthenticationProvider() {
		DaoAuthenticationProvider daoAuthenticationProvider = new DaoAuthenticationProvider();
		daoAuthenticationProvider.setHideUserNotFoundExceptions(false);
		daoAuthenticationProvider.setUserDetailsService(this.detailsService());
		daoAuthenticationProvider.setPasswordEncoder(this.passwordEncoder);
		return daoAuthenticationProvider;
	}

	@Bean
	public HttpFirewall allowUrlEncodedSlashHttpFirewall() {
		StrictHttpFirewall firewall = new StrictHttpFirewall();
		firewall.setAllowUrlEncodedSlash(true);
		return firewall;
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.authorizeRequests()
				//添加不需要认证的路径
				.antMatchers("/login.jsp").permitAll()
				.antMatchers("/index.jsp").authenticated()
				.antMatchers("/hello").authenticated()
				.antMatchers("/img/**").permitAll()
				.antMatchers("/login").permitAll()
				.antMatchers("/oauth/**").permitAll()
				//任何请求需要认证
				.anyRequest().authenticated()
				//权限前缀不要给
				//.anyRequest().hasRole("ACCESS")
				//.anyRequest().hasAnyAuthority()
				//.anyRequest().fullyAuthenticated()
				//关闭csrf 关闭跨域的验证
				.and().csrf().disable()
				//自定义配置登陆页面
				.formLogin().loginPage("/login.jsp")
				//自定义登陆请求地址
				.loginProcessingUrl("/hello").
				//验证成功的跳转页面
//						successForwardUrl("/index-success.jsp").
				//验证失败的跳转路径
						failureForwardUrl("/index-error.jsp")
				//退出的请求路径
				.and().logout().logoutUrl("/index.jsp").
				//退出请求后销毁session
						invalidateHttpSession(true).
				//退出成功跳转的页面
						logoutSuccessUrl("/index.jsp")
				//权限不足跳转的路径
				.and().exceptionHandling().accessDeniedPage("/index.jsp");
	}

}
