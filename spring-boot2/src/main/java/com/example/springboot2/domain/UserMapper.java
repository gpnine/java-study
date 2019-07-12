package com.example.springboot2.domain;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;
import java.util.Map;

/**
 * spring-boot2 .
 *
 * @description: .
 * @author: Chenglin Zhu .
 * @date: 19-7-12 .
 */
@Mapper
public interface UserMapper {

	@Select("select * from user where name = #{name}")
	User findByName(@Param("name") String name);

	@Insert("insert into user(name,age) values(#{name},#{age})")
	int insert(@Param("name") String name, @Param("age") Integer age);

	@Insert("insert into user(name,age) values(#{name,jdbcType=VARCHAR},#{age,jdbcType=INTEGER})")
	int insertByMap(Map<String, Object> map);

	@Insert("insert into user(name,age) values(#{name},#{age})")
	int insertByUser(User user);

	@Update("update user set age = #{age} where name = #{name}")
	void update(User user);

	@Delete("delete from user where id = #{id}")
	void delete(Long id);

	@Results({
			@Result(property = "name", column = "name"),
			@Result(property = "age", column = "age")
	})
	@Select("select name,age from user")
	List<User> findAll();

}
