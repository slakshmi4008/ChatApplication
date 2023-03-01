package com.slakshmi.chatapp.repository;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import com.slakshmi.chatapp.dto.Message;
import com.slakshmi.chatapp.dto.User;

public class ChatRepository {
	private static ChatRepository chatDbRepository;
	private List<User> allUser = new ArrayList();
	private List<Message> allMessages = new ArrayList<>();
	private int userId = 3;
	private int messageId = 3;

	private ChatRepository() {

	}

	public static ChatRepository getInstance() {
		if (chatDbRepository == null) {
			chatDbRepository = new ChatRepository();
			chatDbRepository.initialSetup();
		}
		return chatDbRepository;
	}

	private void initialSetup() {
		allUser.add(new User(1, "lakshmi", "1234", "Lakshmi", "lakshmi@gmail.com"));
		allUser.add(new User(2, "Abi", "abi", "Abirami", "abirami@gmail.com"));
		allMessages.add(new Message(1, "how are you", 1, 2, "lakshmi", "Abi",LocalDateTime.now()));
		allMessages.add(new Message(2, "I am fine", 2, 1, "Abi", "lakshmi",LocalDateTime.now()));

	}

	public User checkValidUser(String userName, String password) {
		for (User user : allUser) {
			if (user.getUserName().equals(userName) && user.getPassword().equals(password)) {
				return user;
			}
		}
		return null;
	}

	public List<Message> getReceivedMessage(User user) {
		List<Message> receivedMessages = new ArrayList<>();
		for (Message message : allMessages) {
			if (message.getReceiverUserName().equalsIgnoreCase(user.getUserName()))
				receivedMessages.add(message);
		}
		return receivedMessages;
	}

	public List<Message> getSentMessage(User user) {
		List<Message> sentMessages = new ArrayList<>();
		for (Message message : allMessages) {
			if (message.getSenderUserName().equalsIgnoreCase(user.getUserName()))
				sentMessages .add(message);
		}
		return sentMessages ;
	}

	public boolean updateNewMessage(Message newMessage) {
		int receiverUserID= getUserID(newMessage.getReceiverUserName());
		int senderUserID= getUserID(newMessage.getSenderUserName());
		newMessage.setReceiverUserID(receiverUserID);
		newMessage.setReceiverUserID(senderUserID);
		System.out.println(LocalDateTime.now());
		return allMessages.add(new Message(messageId++,newMessage.getMessage(),newMessage.getReceiverUserID(),newMessage.getSenderUserID(),
				newMessage.getReceiverUserName(),newMessage.getSenderUserName(),LocalDateTime.now()));
		
	}

	public int getUserID(String userName) {
		for(User user : allUser)
		if(user.getUserName().equals(userName))
		return user.getUserId();
		return 0;
	}
	
	public boolean checkValidReceiver(String userName) {
		for(User user : allUser) {
		if(user.getUserName().equals(userName))
		return true;}
		return false;
	}
	
	
}
