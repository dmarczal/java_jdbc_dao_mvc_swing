package view.layout;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JToolBar;

import util.Util;
import view.users.Form;

public class Options extends JPanel{

	private static final long serialVersionUID = 1L;

	private JButton jbAdd;
	private JButton jbEdit;
	private JButton jbDetails;
	private JButton jbRemove;
	
	private JToolBar jtbOptions;
	
	public Options() {
		// Flowlayout is the default layout of panel
		setLayout(new BorderLayout());
		configure();
		registerListeners();
	}
	
	private void configure(){
		jtbOptions = new JToolBar("Barra De Opções"); 
		
		jbAdd = createButton("Adicionar", "add_obj");
		jbEdit = createButton("Editar", "edit");
		jbDetails = createButton("Editar", "details");
		jbRemove = createButton("Editar", "remove");
		
		this.add(jtbOptions, BorderLayout.CENTER);
	}
	
	private JButton createButton(String hint, String icon){
		JButton jButton = new JButton();
		
		jButton.setIcon(Util.getIcon(getClass(), icon));
		jButton.setToolTipText(hint);
		jtbOptions.add(jButton);
		
		return jButton;
	}
	
	private void registerListeners(){
		jbEdit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				cmdEdit();
			}
		});
		
		jbAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				cmdAdd();
			}
		});
		
		jbDetails.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				cmdDetails();
			}
		});
		
		jbRemove.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				cmdRemove();
			}
		});
	}
	
	public void cmdSair(){
		System.exit(0);
	}
	
	public void cmdAdd(){
		Form.toggle();
	}
	
	public void cmdEdit(){
		System.out.println("Editar");
	}
	
	public void cmdDetails(){
		System.out.println("Details");
	}
	
	public void cmdRemove(){
		System.out.println("Remove");
	}
	
}
