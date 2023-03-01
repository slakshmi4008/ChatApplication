package com.slakshmi.chatapp.home;

import java.util.List;

import com.slakshmi.chatapp.dto.Message;
import com.slakshmi.chatapp.dto.User;
import com.slakshmi.chatapp.login.LoginController;
import com.slakshmi.chatapp.repository.ChatRepository;

public class HomeModel {

	private HomeModelControlerCallBack homeController;

	public HomeModel(HomeModelControlerCallBack homeConroller) {
		this.homeController = homeController;
	}

	public List<Message> getReceivedMessage(User user) {
		List<Message> receivedMessages = ChatRepository.getInstance().getReceivedMessage(user);
		return receivedMessages;
	}

	public List<Message> getSentMessage(User user) {
		List<Message> sentMessages = ChatRepository.getInstance().getSentMessage(user);
		return sentMessages;
	}

	public boolean updateNewMessage(Message newMessage) {
		return ChatRepository.getInstance().updateNewMessage(newMessage);

	}

	public boolean validateSender(String receiverUserName) {
		return ChatRepository.getInstance().checkValidReceiver(receiverUserName);

	}

	public interface HomeModelControlerCallBack {

	}
}
