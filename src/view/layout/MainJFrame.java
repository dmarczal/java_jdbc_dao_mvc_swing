package view.layout;

import java.awt.BorderLayout;
import java.awt.Dimension;

import javax.swing.JFrame;
import javax.swing.JPanel;


public class MainJFrame extends JFrame {

	private static final long serialVersionUID = 1L;
	
	public MainJFrame() {
		super("Lista de Usu‡rios");
		setJMenuBar(new MenuOver());
		
		JPanel jpBody = new JPanel();
		jpBody.setLayout(new BorderLayout());
		
		jpBody.add(new Options(), BorderLayout.SOUTH);
		
		this.setContentPane(jpBody);
	}
	
	public static void createAndShowGUI() {
        //Create and set up the window.
        JFrame frame = new MainJFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setMinimumSize(new Dimension(400,200));
 
        //Center the frame
        frame.setLocationRelativeTo(null);
        //Display the window.
        frame.pack();
        frame.setVisible(true);
    }
}
