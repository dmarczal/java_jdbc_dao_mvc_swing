package controllers.users.listeners;

import java.util.EventListener;

import model.User;

public interface UserListener extends EventListener {	
	void useradd(MailEvent<User> event);
}
