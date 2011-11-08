package controllers;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.User;

import view.events.MailEvent;
import view.listeners.UserListener;

public class UserController {
	
	public static UserController instance = new UserController();
	
	private UserController(){}
	
	private List<UserListener> userListeners = new ArrayList<UserListener>();
	
	public User save(User user) throws SQLException {
		if (user != null) {
			user.save();
			notifyListeners(user);
		}
		return user;
	}
	
	public List<User> allUsers() throws SQLException{
		return User.all();
	}
	
	public synchronized void addUserListener(UserListener l) {
		if(!userListeners.contains(l)) {
			userListeners.add(l);
		}
	}

	private void notifyListeners(User user) {
		MailEvent<User> event = new MailEvent<User>(user);

		for (UserListener listener : userListeners) {
			listener.useradd(event);
		}
	}

}
