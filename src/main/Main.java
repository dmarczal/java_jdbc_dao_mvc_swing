package main;

import java.sql.SQLException;

import model.User;
import view.layout.MainJFrame;

public class Main {
	
	public static void main(String[] args) throws SQLException {
		//textMode();
		MainJFrame.createAndShowGUI();
	}		

	@SuppressWarnings("unused")
	private static void textMode() throws SQLException{
		System.out.println("Apagando todos os usuários do Banco de Dados");
		System.out.println(User.deleteAll() + " usuários deletados");
		
		System.out.println("Criando Usuários");
		User user = new User("Diego", "marczal");
		user.save();
		
		User user_a = new User("Diego", "marczal_a");
		user_a.save();
		
		User user_b = new User("Diego", "marczal_b");
		user_b.save();
		
		System.out.println("====================================");
		System.out.println("Listar Usuários Criados");
		
		for (User u : User.all()) {
			System.out.println(u);
		}
	}
}
