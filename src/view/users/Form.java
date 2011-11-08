package view.users;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.text.JTextComponent;

import model.User;

public class Form extends JDialog{

	private static final long serialVersionUID = 1L;
	
	private static Form form = new Form();

	private JTextField jtfName;
	private JTextField jtfLogin;

	private JButton jbSave;
	private JButton jbCancel;

	public Form() {
		createForms();
		createButtons();
		registerListeners();
		configure();
	}	

	private void configure(){
		this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		this.pack();
		this.setLocationRelativeTo(this.getRootPane());
	}
	
	private void createForms(){
		JPanel jpForm = new JPanel(new GridLayout(6, 1, 0, 5));

		jpForm.setBorder(BorderFactory.createTitledBorder("Dados Pessoais"));

		jpForm.add(new JLabel("Nome: "));
		jpForm.add(jtfName = new JTextField(40));

		jpForm.add(new JLabel("Login: "));
		jpForm.add(jtfLogin = new JTextField(40));

		this.add(jpForm, BorderLayout.CENTER);
	}

	private void createButtons(){
		JPanel jpButtons = new JPanel();    

		jpButtons.add(jbSave = new JButton("Salvar"));
		jpButtons.add(jbCancel = new JButton("Cancelar"));	
		this.add(jpButtons, BorderLayout.SOUTH);		
	}
	
	private void registerListeners() {
		jbSave.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				cmdSave();
			}
		});
		jbCancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				cmdCancel();
			}
		});
	}
	
	private void cmdSave(){
		try {
			User user = new User(jtfName.getText(), jtfLogin.getText());
			user.save();
			JOptionPane.showMessageDialog(this, "Usu‡rio Salvo Com Sucesso", "", JOptionPane.INFORMATION_MESSAGE);
			dispose();
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(this, e.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
			//e.printStackTrace();
		}
	}
	
	private void cmdCancel(){
		dispose();
	}
	
	private void clearForm(JTextComponent... jtcomponets){
		for (JTextComponent component : jtcomponets) {
			component.setText("");
		}
	}
	
	@Override
	public void dispose(){
		super.dispose();
		clearForm(jtfName, jtfLogin);
	}
	
	public static void toggle(){
		form.setVisible(!form.isVisible());
	}
}