package view;

import javax.swing.JFrame;

public class MainJFrame extends JFrame {

	private static final long serialVersionUID = 1L;
	
	public MainJFrame() {
		super("Lista de Usu‡rios");
		setJMenuBar(new MenuOver());
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
