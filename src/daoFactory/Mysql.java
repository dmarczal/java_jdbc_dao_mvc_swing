package daoFactory;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import dao.concrete.MysqlUserDao;
import dao.interfaces.UserDao;

public class Mysql extends DaoFactory {
	
	private static String url = "jdbc:mysql://127.0.0.1:3306/";
	private static String database = "mailsystem";
	private static String driver = "com.mysql.jdbc.Driver";
	private static String user = "root";
	private static String password = "mysql";
	
	public Connection openConnection() {   
		try {
			Class.forName(driver).newInstance();
			Connection connection = DriverManager.getConnection(url + database, user, password);
			return connection;
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (Exception ex){
			System.err.println(
				"Não foi possével salvar os dados! O Banco de dados não estão respondendo!");
		}
		return null;
	}
	
	@Override
	public UserDao getUserDao() {
		return new MysqlUserDao();
	}
}
