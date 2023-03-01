package com.slakshmi.chatapp.login;

import com.slakshmi.chatapp.dto.User;

public interface LoginViewCallBack {

	void loginSuccess(User user);

	void loginFailed(String errorMessage);

}
