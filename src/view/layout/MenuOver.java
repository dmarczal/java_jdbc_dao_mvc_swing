package view.layout;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;

import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.KeyStroke;

import util.Util;
import view.listeners.EventListerner;
import view.users.Form;

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
	private JMenuItem jmiRemove;

	private JMenu jmHelp;
	private JMenuItem jmiAbout;
	

	private EventListerner eventListerner; 
	
	public MenuOver(EventListerner eventListerner) {
		this.eventListerner = eventListerner;
		configure();
		registerListeners();
	}
	

	private void configure() {
		jmFile = createMenu("Arquivo", 'A');
		
		jmEdit = createMenu("Editar", 'E');
		
		jmHelp = createMenu("Ajuda", 'H');
		
		jmiExit = createMenuItem(jmFile, "Sair", 'S', "close_view",
				KeyStroke.getKeyStroke(KeyEvent.VK_F4, InputEvent.ALT_MASK));
		
		
		jmiAdd = createMenuItem(jmEdit, "Adicionar", 'A', "add_obj",
				KeyStroke.getKeyStroke(KeyEvent.VK_INSERT, 0));
		
		
		jmiEdit = createMenuItem(jmEdit, "Editar", 'E', "edit",
				KeyStroke.getKeyStroke(KeyEvent.VK_ENTER, InputEvent.ALT_MASK));
		
		jmiRemove = createMenuItem(jmEdit, "Remover", 'R', "remove",
				KeyStroke.getKeyStroke(KeyEvent.VK_R, InputEvent.ALT_MASK));
		
		
		jmiAbout = createMenuItem(jmHelp, "Sobre", 'S', "about",
				KeyStroke.getKeyStroke(KeyEvent.VK_S, InputEvent.ALT_MASK));
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
		jMenuItem.setIcon(Util.getIcon(getClass(), icone));
		jMenuItem.setMnemonic(mnmonic);
		jMenu.add(jMenuItem);
		
		return jMenuItem;
	}


	private void registerListeners(){
		jmiExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				cmdSair();
			}
		});	
		
		jmiAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				eventListerner.cmdAdd();
			}
		});
		
		jmiEdit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				eventListerner.cmdEdit();
			}
		});
		
		jmiRemove.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				eventListerner.cmdRemove();
			}
		});
		
		jmiAbout.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				System.out.println("About");
			}
		});
	}
	
	public void cmdSair(){
		System.exit(0);
	}
}
