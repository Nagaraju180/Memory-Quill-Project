package com.ynr.springboot.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.ynr.springboot.entities.User;

public interface UserRepository extends JpaRepository<User, Integer> {
	
	@Query
	public User findUserByUsername(String username);
	
//	@Query(value = "update users set password =:password where username =:username LIMIT 1",nativeQuery=true)
//	public User updateUserPasswordByUsername(String username,String password);
}
