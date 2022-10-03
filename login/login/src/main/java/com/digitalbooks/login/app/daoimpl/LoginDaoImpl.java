package com.digitalbooks.login.app.daoimpl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.digitalbooks.login.app.dao.LoginDao;
import com.digitalbooks.login.app.entity.AuthorLoginEntity;
import com.digitalbooks.login.app.repository.LoginRepository;

@Repository
public class LoginDaoImpl implements LoginDao {

	@Autowired
	private LoginRepository LoginRepository;
	
	@Override
	public AuthorLoginEntity signUp(AuthorLoginEntity entity) {
		
		return LoginRepository.save(entity);
	}

	@Override
	public Optional<AuthorLoginEntity> findByUserName(String userName) {
		return LoginRepository.findByUserName(userName);
	}

	@Override
	public Optional<AuthorLoginEntity> findByUserId(int userId) {
		return LoginRepository.findByUserId(userId);
	}
	
	

}
