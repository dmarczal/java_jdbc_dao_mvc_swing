package view.users;

import java.sql.SQLException;

import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import controllers.UserController;

import model.User;

import view.events.MailEvent;
import view.listeners.UserListener;

public class JTableList extends JTable implements UserListener{
	
	private static final long serialVersionUID = 1L;
	
	private TableModel model = new TableModel();

	public JTableList() {
		this.setModel(model);
		this.getTableHeader().setReorderingAllowed(false);
		UserController.instance.addUserListener(this);
		loadUsers();
	}
	
	public void loadUsers(){
		try {
			for (User user : UserController.instance.allUsers()) {
				model.insertRow(0, user.toArray());
			}
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(this, "Erro", e.getMessage(), JOptionPane.ERROR_MESSAGE);
			e.printStackTrace();
		}
	}
	
	
	private class TableModel extends DefaultTableModel{
		
		private static final long serialVersionUID = 1L;
		
		public TableModel() {
			super(new Object[][]{}, new String[] {"id", "Nome", "login"});	 
		}
		
		@Override
		public boolean isCellEditable(int row, int column) {
			return false;
		}
		
	}

	@Override
	public void useradd(MailEvent<User> event) {
		model.insertRow(0, event.getSource().toArray());
	}

}
