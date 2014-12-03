package view.users;

import java.sql.SQLException;

import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import model.User;
import view.listeners.EventListerner;
import controllers.users.UserController;
import controllers.users.listeners.MailEvent;
import controllers.users.listeners.UserListener;

public class JTableList extends JTable implements UserListener, EventListerner {
	
	private static final long serialVersionUID = 1L;
	
	private TableModel model = new TableModel();

	public JTableList() {
		this.setModel(model);
		this.getTableHeader().setReorderingAllowed(false);
		UserController.getInstance().addUserListener(this);
		loadUsers();
	}
	
	public void loadUsers(){
		try {
			for (User user : UserController.getInstance().allUsers()) {
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

	@Override
	public void cmdEdit() {
		System.out.println(this.getSelectedRow());
	}

	@Override
	public void cmdRemove() {
		if (this.getSelectedRow() != -1) {
			int row = this.getSelectedRow();
			Long userId = Long.parseLong((String) this.getValueAt(row, 0));
			try {
				UserController.getInstance().remove(userId);
				model.removeRow(row);
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
	
	@Override
	public void cmdDetails() {
		System.out.println(this.getSelectedRow());
	}
	
	@Override
	public void cmdAdd() {
		Form.toggle();
	}

}
