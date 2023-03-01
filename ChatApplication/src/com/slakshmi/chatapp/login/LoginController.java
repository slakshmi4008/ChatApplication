package com.slakshmi.chatapp.login;

import com.slakshmi.chatapp.dto.User;
import com.slakshmi.chatapp.login.LoginModel.LoginModelControlerCallBack;

public class LoginController implements LoginControllerCallBack, LoginModelControlerCallBack {

	LoginViewCallBack loginView;
	LoginModelCallBack loginModel;

	public LoginController(LoginViewCallBack loginView) {
		this.loginView = loginView;
		this.loginModel = new LoginModel(this);
	}

	public void checkCredentials(String userName, String password) {
		loginModel.checkCredentials(userName, password);
	}

	public void loginSuccess(User user) {
		loginView.loginSuccess(user);
	}

	public void loginFailiure(String errorMessage) {
		loginView.loginFailed(errorMessage);
	}

}
