package com.digitalbooks.login.app.dao;

import java.util.Optional;

import com.digitalbooks.login.app.entity.AuthorLoginEntity;

public interface LoginDao {

	AuthorLoginEntity signUp(AuthorLoginEntity entity);
	
	Optional<AuthorLoginEntity> findByUserName(String userName);
	
	Optional<AuthorLoginEntity> findByUserId(int userId);
	

}
