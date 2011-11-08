package view;

import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class JTableList extends JTable {
	
	private static final long serialVersionUID = 1L;
	
	private TableModel model = new TableModel();

	public JTableList() {
		this.setModel(model);
		this.getTableHeader().setReorderingAllowed(false);
	}
	
	private class TableModel extends DefaultTableModel{
		
		private static final long serialVersionUID = 1L;

		public TableModel() {
			super(new Object[][]{{"Diego 0", "marczal 00"},
								 {"Diego 1", "marczal 01"}},
								 
					new String[] {"Nome", "login"});
			 
		}
		
		@Override
		public boolean isCellEditable(int row, int column) {
			return false;
		}
		
	}

}
