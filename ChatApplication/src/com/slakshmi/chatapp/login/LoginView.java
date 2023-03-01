package com.slakshmi.chatapp.login;

import java.util.Scanner;

import com.slakshmi.chatapp.dto.User;
import com.slakshmi.chatapp.home.HomeView;

public class LoginView implements LoginViewCallBack {
	private LoginControllerCallBack loginController;
	private Scanner scanner = new Scanner(System.in);

	public LoginView() {
		loginController = new LoginController(this);
	}

	static public void main(String[] args) {
		LoginView loginView = new LoginView();
		loginView.create();
	}

	public void create() {
		checkForLogin();
	}

	private void checkForLogin() {
		System.out.println("Welcome to chat application\n ------------------------");
		System.out.println("Enter User Name");
		String userName = scanner.next();
		System.out.println("Enter password");
		String password = scanner.next();
		loginController.checkCredentials(userName, password);
	}

	public void loginSuccess(User user) {
		System.out.println("\n-->Hello " + user.getUserName() + "<--\n");
		HomeView homeView = new HomeView();
		homeView.create(user);
	}

	public void loginFailed(String errorMessage) {
		System.out.println(errorMessage);
		checkForLogin();
	}

}
