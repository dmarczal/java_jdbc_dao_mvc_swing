package view.listeners;

import java.util.EventListener;

import model.User;

import view.events.MailEvent;

public interface UserListener extends EventListener{
	
	void useradd(MailEvent<User> event);
}
