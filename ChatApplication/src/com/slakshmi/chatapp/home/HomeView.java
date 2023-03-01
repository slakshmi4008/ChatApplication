package com.slakshmi.chatapp.home;

import java.util.List;
import java.util.Scanner;

import com.slakshmi.chatapp.dto.Message;
import com.slakshmi.chatapp.dto.User;

public class HomeView implements HomeViewCallBack {
	private HomeConrollerCallBack homeController;
	private Scanner scanner = new Scanner(System.in);
	private User user;

	public HomeView() {
		homeController = new HomeConroller(this);
	}

	/*
	 * static public void main(String[] args) { HomeView homeView = new HomeView();
	 * //homeView.create(); }
	 */

	public void create(User user) {
		this.user = user;
		index();

	}

	public void index() {
		System.out.println("Welcome to home page");
		System.out.println("------------------------");
		System.out.println("1)Inbox");
		System.out.println("2)Outbox");
		System.out.println("3)New Message");
		System.out.println("4)Login page");
		System.out.println("Enter the option");
		int option = scanner.nextInt();
		scanner.nextLine();
		homeController.processOption(option, user);

	}

	public void printMessage(List<Message> messages) {
		for (Message message : messages) {
			System.out.println(message);
		}

	}

	public Message getNewMessage() {
		System.out.println("New message page------------------------");
		System.out.println("Enter receiver UserName: ");
		String receiverUserName = scanner.nextLine();
		System.out.println("Enter the message");
		String message = scanner.nextLine();
		return new Message(message, receiverUserName, user.getUserName());

	}

	public void notify(String notificationMessage) {

		System.out.println(notificationMessage);
	}

}
