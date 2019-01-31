package com.project.util;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;
import java.util.List;
import java.util.Map;

/**
 * zcl-webapp .
 *
 * @description: .
 * @author: ChengLin Zhu .
 * @date: 19-1-31 .
 */
@Component
public class JNDIConnect {

	private static final Logger LOGGER = LoggerFactory.getLogger(JNDIConnect.class);

	@Value("${jdbc.project.jndiName}")
	private String jndiName;

	public List<Map<String, Object>> jndiConnect() {
		try {
			Context context = new InitialContext();
			DataSource dataSource = (DataSource) context.lookup(this.jndiName);
			JdbcTemplate jt = new JdbcTemplate(dataSource);
			String sql = "SELECT * FROM user";
			return jt.queryForList(sql);
		} catch (NamingException e) {
			LOGGER.error("(⊙﹏⊙✿)(⊙﹏⊙✿)(⊙﹏⊙✿)(⊙﹏⊙✿) no data source found with name:{}, can't sync data.{}", this.jndiName, e.getLocalizedMessage());
		}
		return null;
	}
}
