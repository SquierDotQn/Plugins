package menus;

import java.awt.BorderLayout;
import java.awt.event.ActionListener;

import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;

@SuppressWarnings("serial")
public class TopMenuBar extends JPanel{
	
	private JMenuItem file, tools, help;
	
	public TopMenuBar(){
		super();
		build();
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
		panel.add(edit);
		panel.add(display);
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
				new FilePopup(dw).show(source,0,getHeight());
			}else if(e.getSource().equals(edit)){
				new EditPopup(paint).show(source,0,getHeight());
			}else if(e.getSource().equals(display)){
				new DisplayPopup(dw).show(source,0,getHeight());
			}else if(e.getSource().equals(help)){
				new HelpPopup().show(source,0,getHeight());
			}
			
		}
		
	}


}
