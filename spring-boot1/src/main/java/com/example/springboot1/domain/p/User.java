package com.example.springboot1.domain.p;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.io.Serializable;

/**
 * spring-boot1 .
 *
 * @description: .
 * @author: Chenglin Zhu .
 * @date: 19-7-10 .
 */
@Entity
public class User implements Serializable {
	// 序列化 (Serialization)将对象的状态信息转换为可以存储或传输的形式的过程。
	// 在序列化期间，对象将其当前状态写入到临时或持久性存储区。
	// 之后，可以通过从存储区中读取或反序列化对象的状态，重新创建该对象。
	// 例如此处，我们将java对象转化为bytes数组的过程称为序列化，将bytes转化为java对象的过程称为反序列化。
	private static final long serialVersionUID = -1L;

	@Id
	@GeneratedValue
	private Long id;

	@Column(nullable = false)
	private String name;

	@Column(nullable = false)
	private Integer age;

	public User() {
	}

	public User(String name, Integer age) {
		this.name = name;
		this.age = age;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}
}
