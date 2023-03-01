package com.slakshmi.chatapp.home;

import java.util.List;

import com.slakshmi.chatapp.dto.Message;
import com.slakshmi.chatapp.dto.User;
import com.slakshmi.chatapp.home.HomeModel.HomeModelControlerCallBack;
import com.slakshmi.chatapp.login.LoginView;

public class HomeConroller implements HomeConrollerCallBack, HomeModelControlerCallBack {

	private HomeViewCallBack homeView;
	private HomeModel homeModel;

	public HomeConroller(HomeViewCallBack homeView) {
		this.homeView = homeView;
		this.homeModel = new HomeModel(this);
	}

	public void processOption(int option, User user) {
		switch (option) {
		case 1: {
			List<Message> receivedMessages = homeModel.getReceivedMessage(user);
			homeView.printMessage(receivedMessages);
			homeView.index();
			break;
		}
		case 2: {
			List<Message> sentMessages = homeModel.getSentMessage(user);
			homeView.printMessage(sentMessages);
			homeView.index();
			break;
		}
		case 3: {
			Message newMessage = homeView.getNewMessage();
			boolean isValidReceiver = homeModel.validateSender(newMessage.getReceiverUserName());
			if (isValidReceiver) {
				homeModel.updateNewMessage(newMessage);
				homeView.notify("message sent successfully");
			} else {
				homeView.notify("There is some error.try again");
			}
			homeView.index();
			break;
		}
		case 4: {
			LoginView loginView = new LoginView();
			loginView.create();
		}
		default: {
			System.out.println("Please enter valid option");
			homeView.index();
		}
		}

	}

}
