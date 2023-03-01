package com.slakshmi.chatapp.home;

import java.util.List;

import com.slakshmi.chatapp.dto.Message;

public interface HomeViewCallBack {

	void printMessage(List<Message> receivedMessages);

	void index();

	Message getNewMessage();

	void notify(String string);

}
