package menus;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;

import model.WritingModel;

@SuppressWarnings("serial")
public class TopMenuBar extends JPanel{
	
	private JMenuItem file, tools, help;
	private WritingModel wm;
	
	public TopMenuBar(){
		super();
		this.wm = new WritingModel();
		build();
	}
	
	public TopMenuBar(WritingModel wm) {
		this.wm = wm;
	}

	/**
	 * Crée les onglets Fichier, Edition, Affichage et "?".
	 */
	public void build(){
		JMenuBar panel = new JMenuBar();
		MenuListener ml = new MenuListener();
		file = new JMenuItem("Fichier");
		file.addActionListener(ml);
		tools = new JMenuItem("Edition");
		tools.addActionListener(ml);
		help = new JMenuItem("?");
		help.addActionListener(ml);
		setLayout(new BorderLayout(5, 0));
		panel.add(file);
		panel.add(tools);
		panel.add(help);
		this.add(panel,BorderLayout.WEST);
		setPreferredSize(new Dimension(450,30));
	}
	
	/**
	 * Listener de la barre de menu.
	 */
	class MenuListener implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			Component source = (Component) e.getSource();
			if(e.getSource().equals(file)){
				new FilePopup().show(source,0,getHeight());
			}else if(e.getSource().equals(tools)){
				new ToolPopup().show(source,0,getHeight());
			}else if(e.getSource().equals(help)){
				new HelpPopup().show(source,0,getHeight());
			}
			
		}
		
	}


}
