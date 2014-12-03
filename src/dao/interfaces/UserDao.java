package dao.interfaces;

import java.sql.SQLException;
import java.util.List;

import model.User;

public interface UserDao {
	
	User insert(User object) throws SQLException;
	List<User> all() throws SQLException;
	int deleteAll() throws SQLException;
	int delete(User user) throws SQLException;
	User findByLogin(String login) throws SQLException;
	User findById(Long id) throws SQLException;
}
