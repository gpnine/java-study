package spring;

import org.springframework.security.web.context.AbstractSecurityWebApplicationInitializer;

/**
 * 这个类用来加载Spring Security的DelegatingFilterProxy.
 * 通过继承AbstractSecurityWebApplicationInitializer类.
 * 该类已经实现了springSecurityFilterChain的注册.
 * 相当与在web.xml中配置spring security 的filter
 *
 * @author zcl
 * @date 2019-09-26.
 */
public class SecurityWebApplicationInitializer extends AbstractSecurityWebApplicationInitializer {

}
