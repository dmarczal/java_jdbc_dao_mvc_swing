package model;

import static org.junit.Assert.*;

import java.sql.SQLException;

import org.junit.Before;
import org.junit.Test;

public class UserTest {
	
	private User user;
	
	@Before
	public void before_each_test() throws SQLException{
		User.deleteAll();
		user = new User("Diego", "marczal");
	}

	@Test
	public void should_create_a_user() throws SQLException{
		user.save();
		assertEquals("Diego", user.getName());
		assertEquals("marczal", user.getLogin());
		assertNotNull(user.getId());
	}
	
}
