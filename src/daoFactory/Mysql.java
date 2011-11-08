package daoFactory;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import dao.concrete.MysqlUserDao;

public class Mysql extends DaoFactory{
	
	private static String url = "jdbc:mysql://127.0.0.1:3306/";
	private static String database = "mailsystem";
	private static String driver = "com.mysql.jdbc.Driver";
	private static String user = "root";
	private static String password = "";
	
	public Connection openConnection() {   
		try {
			Class.forName(driver).newInstance();
			Connection connection = DriverManager.getConnection(url + database, user, password);
			return connection;
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (Exception ex){
			System.err.println(
				"Não foi possível salvar os dados! O Banco de dados não está respondendo!");
		}
		return null;
	}
	
	@Override
	public MysqlUserDao getUserDao() {
		return new MysqlUserDao();
	}
}
