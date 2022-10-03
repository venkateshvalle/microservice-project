package com.digitalbooks.login.app.serviceimpl;

import java.sql.Timestamp;
import java.util.Date;
import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.digitalbooks.login.app.dao.LoginDao;
import com.digitalbooks.login.app.entity.AuthorLoginEntity;
import com.digitalbooks.login.app.model.AuthorLogin;
import com.digitalbooks.login.app.service.LoginService;


@Service
public class LoginServiceImpl implements LoginService {
		
	@Autowired
	LoginDao loginDao;
	
	public String signUp(AuthorLogin authorLogin) {
		
		AuthorLoginEntity entity = new AuthorLoginEntity();
		BeanUtils.copyProperties(authorLogin, entity);
		Optional<AuthorLoginEntity> entityResponse = loginDao.findByUserName(authorLogin.getUserName());
		if(!entityResponse.isEmpty()) {
			return "UserName already exists";
		}
		Date date = new Date();
		long l = date.getTime();
		Timestamp timestamp = new Timestamp(l);
		entity.setCreatedTime(timestamp);
		entity = loginDao.signUp(entity);
		if(entity.getUserId() != 0) {
			return "success";
		} else {
			return "Error in Creating user";
		}
		
	}

	
	public String signIn(AuthorLogin authorLogin) {
		
		Optional<AuthorLoginEntity> entityResponse = loginDao.findByUserName(authorLogin.getUserName());
		if(entityResponse.isEmpty()) {
			return "UserName is not registered. Please do signUp first...";
		} else {
			AuthorLoginEntity entity = entityResponse.get();
			if(!entity.getPassword().equals(authorLogin.getPassword())) {
				return "Password doesn't matches...";
			} else {
				return "successful login";
			}
		}		
	}
}
