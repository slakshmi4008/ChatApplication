package com.slakshmi.chatapp.login;

import com.slakshmi.chatapp.dto.User;
import com.slakshmi.chatapp.repository.ChatRepository;

public class LoginModel implements LoginModelCallBack {
	private LoginModelControlerCallBack loginController;

	public LoginModel(LoginModelControlerCallBack loginController) {
		this.loginController = loginController;
	}

	public void checkCredentials(String userName, String password) {

		User user = ChatRepository.getInstance().checkValidUser(userName, password);
		if (user != null) {
			loginController.loginSuccess(user);
		} else {
			loginController.loginFailiure("\nInvalid Credentials. Please try again!\n");
		}

	}

	public interface LoginModelControlerCallBack {

		void loginSuccess(User user);

		void loginFailiure(String string);

	}

}
