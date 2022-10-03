package com.digitalbooks.login.app.service;

import com.digitalbooks.login.app.model.AuthorLogin;

public interface LoginService {
		
	public String signUp(AuthorLogin authorLogin);

	public String signIn(AuthorLogin authorLogin);

}
