package com.zcl;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.config.IniSecurityManagerFactory;
import org.apache.shiro.mgt.SecurityManager;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.subject.Subject;
import org.apache.shiro.util.Factory;
import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;

/**
 * web .
 *
 * @description: .
 * @author: Chenglin Zhu .
 * @date: 19-7-26 .
 */
public class TestShiro {
	@Test
	public void test() {
		// 1、获取SecurityManager工厂，此处使用Ini配置文件初始化SecurityManager
		Factory<SecurityManager> factory =
				new IniSecurityManagerFactory("classpath:shiro.ini");
		// 2、得到securityManager实例，绑定给SecurityUtils
		SecurityManager securityManager = factory.getInstance();
		SecurityUtils.setSecurityManager(securityManager);
		// 3、得到Subject及创建用户名／密码身份验证Token（即用户身份／凭证）
		Subject subject = SecurityUtils.getSubject();
		UsernamePasswordToken token = new UsernamePasswordToken("zhang", "123");
		try {
			//4、登录，即身份验证
			subject.login(token);
		} catch (AuthenticationException e) {
			//5、身份验证失败
		}
		Assert.assertEquals(true, subject.isAuthenticated()); //断言用户已经登录
		//6、退出
		subject.logout();
	}

	@Test
	public void test1() {
		// 1、获取SecurityManager工厂，此处使用Ini配置文件初始化SecurityManager
		Factory<SecurityManager> factory =
				new IniSecurityManagerFactory("classpath:shiro-realm.ini");
		// 2、得到securityManager实例，绑定给SecurityUtils
		SecurityManager securityManager = factory.getInstance();
		SecurityUtils.setSecurityManager(securityManager);
		// 3、得到Subject及创建用户名／密码身份验证Token（即用户身份／凭证）
		Subject subject = SecurityUtils.getSubject();
		UsernamePasswordToken token = new UsernamePasswordToken("zhang", "123");
		try {
			//4、登录，即身份验证
			subject.login(token);
		} catch (AuthenticationException e) {
			//5、身份验证失败
		}
		Assert.assertEquals(true, subject.isAuthenticated()); //断言用户已经登录
		//6、退出
		subject.logout();
	}

	@Test
	public void test2() {
		// 1、获取SecurityManager工厂，此处使用Ini配置文件初始化SecurityManager
		Factory<SecurityManager> factory =
				new IniSecurityManagerFactory("classpath:shiro-multi-realm.ini");
		// 2、得到securityManager实例，绑定给SecurityUtils
		SecurityManager securityManager = factory.getInstance();
		SecurityUtils.setSecurityManager(securityManager);
		// 3、得到Subject及创建用户名／密码身份验证Token（即用户身份／凭证）
		Subject subject = SecurityUtils.getSubject();
		UsernamePasswordToken token = new UsernamePasswordToken("wang", "123");
		try {
			//4、登录，即身份验证
			subject.login(token);
		} catch (AuthenticationException e) {
			//5、身份验证失败
		}
		Assert.assertEquals(true, subject.isAuthenticated()); //断言用户已经登录
		//6、退出
		subject.logout();
	}

	@Test
	public void testAllSuccessfulStrategyWithSuccess() {
		login("classpath:shiro-authenticator-all-success.ini");
		Subject subject = SecurityUtils.getSubject();
		//得到一个身份集合，其包含了Realm验证成功的身份信息
		PrincipalCollection principalCollection = subject.getPrincipals();
		Assert.assertEquals(2, principalCollection.asList().size());
	}

	@Test(expected = UnknownAccountException.class)
	public void testAllSuccessfulStrategyWithFail() {
		login("classpath:shiro-authenticator-all-fail.ini");
		Subject subject = SecurityUtils.getSubject();
	}

	public Subject subject() {
		return SecurityUtils.getSubject();
	}

	@Test
	public void testHasRole() {
		login("classpath:shiro-role.ini");
		//判断拥有角色：role1
		Assert.assertTrue(subject().hasRole("role1"));
		//判断拥有角色：role1 and role2
		Assert.assertTrue(subject().hasAllRoles(Arrays.asList("role1", "role2")));
		//判断拥有角色：role1 and role2 and !role3
		boolean[] result = subject().hasRoles(Arrays.asList("role1", "role2", "role3"));
		Assert.assertTrue(result[0]);
		Assert.assertTrue(result[1]);
		Assert.assertFalse(result[2]);
	}

	@Test
	public void testIsPermitted() {
		login("classpath:shiro-permission.ini");
		//判断拥有权限：user:create
		Assert.assertTrue(subject().isPermitted("user:create"));
		//判断拥有权限：user:update and user:delete
		Assert.assertTrue(subject().isPermittedAll("user:update", "user:delete"));
		//判断没有权限：user:view
		Assert.assertFalse(subject().isPermitted("user:view"));
	}

	private void login(String configFile) {
		//1、获取SecurityManager工厂，此处使用Ini配置文件初始化SecurityManager
		Factory<org.apache.shiro.mgt.SecurityManager> factory =
				new IniSecurityManagerFactory(configFile);
		//2、得到SecurityManager实例 并绑定给SecurityUtils
		SecurityManager securityManager = factory.getInstance();
		SecurityUtils.setSecurityManager(securityManager);
		//3、得到Subject及创建用户名/密码身份验证Token（即用户身份/凭证）
		Subject subject = SecurityUtils.getSubject();
		UsernamePasswordToken token = new UsernamePasswordToken("zhang", "123");
		try {
			//4、登录，即身份验证
			subject.login(token);
		} catch (AuthenticationException e) {
			//5、身份验证失败
		}
	}
}
