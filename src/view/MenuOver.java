package view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;

import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.KeyStroke;

import util.Util;

public class MenuOver extends JMenuBar {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JMenu jmFile;
	private JMenuItem jmiExit;
	
	private JMenu jmEdit;
	private JMenuItem jmiAdd;
	private JMenuItem jmiEdit;

	public MenuOver(){
		configure();
		addListeners();
	}
	

	private void configure() {
		jmFile = createMenu("Arquivo", 'A');
		
		jmEdit = createMenu("Editar", 'E');
		
		jmiExit = createMenuItem(jmFile, "Sair", 'S', "close_view",
				KeyStroke.getKeyStroke(KeyEvent.VK_F4, InputEvent.ALT_MASK));
		
		
		jmiAdd = createMenuItem(jmEdit, "Adicionar User", 'A', "add_obj",
				KeyStroke.getKeyStroke(KeyEvent.VK_INSERT, 0));
		
		
		jmiEdit = createMenuItem(jmEdit, "Editar tarefa...", 'E', "configs",
				KeyStroke.getKeyStroke(KeyEvent.VK_ENTER, InputEvent.ALT_MASK));
		
	}
	
	
	private JMenu createMenu(String nome, char mnemonic) {
		JMenu jMenu = new JMenu(nome);
		jMenu.setMnemonic(mnemonic);
		this.add(jMenu);	
		return jMenu;
	}
	
	private JMenuItem createMenuItem(JMenu jMenu, String name,
			char mnmonic, String icone, KeyStroke keyStroke){
		
		JMenuItem jMenuItem = new JMenuItem(name);
		jMenuItem.setAccelerator(keyStroke);
		jMenuItem.setIcon(Util.getIcone(getClass(), icone));
		jMenuItem.setMnemonic(mnmonic);
		jMenu.add(jMenuItem);
		
		return jMenuItem;
	}


	private void addListeners(){
		jmiExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				cmdSair();
			}
		});	
		
		jmiAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				cmdAdd();
			}
		});
		
		jmiEdit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				cmdEdit();
			}
		});
	}
	
	public void cmdSair(){
		System.out.println("Sair");
	}
	
	public void cmdAdd(){
		System.out.println("Adicionar");
	}
	
	public void cmdEdit(){
		System.out.println("Editar");
	}
}
