package com.example.springboot1.domain.p;

import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * spring-boot1 .
 *
 * @description: .
 * @author: Chenglin Zhu .
 * @date: 19-7-10 .
 */
@CacheConfig(cacheNames = "users")
public interface UserRepository extends JpaRepository<User, Long> {

	@Cacheable(key = "#p0")
	User findByName(String name);

	@CachePut(key = "#p0.name")
	User save(User user);
}
