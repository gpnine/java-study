package spring;

import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

/**
 * The Webapplication initializer.
 *
 * @author zcl
 * @date 2019-09-26
 */
public class WebApplication extends AbstractAnnotationConfigDispatcherServletInitializer {

	/**
	 * {@inheritDoc}
	 */
	@Override
	protected Class<?>[] getRootConfigClasses() {
		return new Class[]{SpringSecurityConfig.class};
	}

	@Override
	protected Class<?>[] getServletConfigClasses() {
		return new Class[0];
	}

	@Override
	protected String[] getServletMappings() {
		return new String[]{"/"};
	}
}
