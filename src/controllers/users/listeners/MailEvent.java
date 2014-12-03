package controllers.users.listeners;

import java.util.EventObject;

public class MailEvent<T> extends EventObject {

	private static final long serialVersionUID = 1L;

	public MailEvent(Object source) {
		super(source);
	}
	
	@SuppressWarnings("unchecked")
	public T getSource(){
		return ((T) super.getSource());
	}
}