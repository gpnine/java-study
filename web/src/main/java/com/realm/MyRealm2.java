package com.realm;

import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.realm.Realm;

/**
 * web .
 *
 * @description: .
 * @author: Chenglin Zhu .
 * @date: 19-7-26 .
 */
public class MyRealm2 implements Realm {

	public String getName() {
		return "myrealm2";
	}

	public boolean supports(AuthenticationToken token) {
		return token instanceof UsernamePasswordToken;
	}

	public AuthenticationInfo getAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
		String username = (String) token.getPrincipal();
		String password = new String((char[]) token.getCredentials());
		if (!"wang".equals(username)){
			throw new UnknownAccountException(); // 如果用户名错误
		}
		if (!"123".equals(password)){
			throw new IncorrectCredentialsException(); // 如果密码错误
		}
		//　如果身份认证验证成功，返回一个AuthenticationInfo实现;
		return new SimpleAuthenticationInfo(username, password, getName());
	}
}
