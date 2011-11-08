package view;

import java.awt.BorderLayout;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;

public class MainJFrame extends JFrame {

	private static final long serialVersionUID = 1L;

	private JTable jtList = new JTableList();
	
	public MainJFrame() {
		super("Lista de Usu‡rios");
		configureTable();
	}
	
	
	private void configureTable() {
		JScrollPane jsPanel = new JScrollPane();
		jsPanel.setViewportView(jtList);
		
		this.add(jsPanel, BorderLayout.CENTER);
	}
	
	
	public static void createAndShowGUI() {
        //Create and set up the window.
        JFrame frame = new MainJFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
 
        //Display the window.
        frame.pack();
        frame.setVisible(true);
    }
}
