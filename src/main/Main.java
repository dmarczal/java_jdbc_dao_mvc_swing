package main;

import java.sql.SQLException;

import model.User;
import view.MainJFrame;

public class Main {
	
	public static void main(String[] args) throws SQLException {
		//textMode();

		//Schedule a job for the event-dispatching thread:
        //creating and showing this application's GUI.
        javax.swing.SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                MainJFrame.createAndShowGUI();
            }
        });
	}		
	
	@SuppressWarnings("unused")
	private static void textMode() throws SQLException{
		System.out.println("Apagando todos os usu‡rios do Banco de Dados");
		System.out.println(User.deleteAll() + " usu‡rios deletados");
		
		System.out.println("Criando Usu‡rios");
		User user = new User("Diego", "marczal");
		user.save();
		
		User user_a = new User("Diego", "marczal_a");
		user_a.save();
		
		User user_b = new User("Diego", "marczal_b");
		user_b.save();
		
		System.out.println("====================================");
		System.out.println("Listar Usu‡rios Criados");
		
		for (User u : User.all()) {
			System.out.println(u);
		}
	}
}
