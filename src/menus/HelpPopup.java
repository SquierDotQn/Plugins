package menus;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPopupMenu;

import model.WritingModel;
import plugins.Plugin;

@SuppressWarnings("serial")
public class HelpPopup extends JPopupMenu {
	protected WritingModel wm;
	private List<Plugin> plugins;
	public HelpPopup(WritingModel wm)  {
		this.wm = wm;
		this.plugins = new ArrayList<Plugin>();
		this.build();
	}
	/**
	 * Permet de construire les éléments graphiques du menu contextuel
	 */
	public void build(){
		FileListener fl = new FileListener();
		JMenuItem menuItem;
		plugins.clear();
		plugins.addAll(wm.getPlugins());
		for(Plugin p : plugins){
			System.out.println("J'ai rajouté "+p.getLabel());
			menuItem = new JMenuItem(p.getLabel());
			menuItem.addActionListener(fl);
			this.add(menuItem);
		}
		
		
	}

	/**
	 * Listener du menu contextuel "Fichier".
	 * Gère les actions entrainé par les différentes actions proposées.
	 */
	class FileListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			for(Plugin p : plugins){
				if(p.getLabel().equals(((JMenuItem)e.getSource()).getText())){
					JOptionPane.showMessageDialog(null, p.helpMessage());
				}
			}
		}

	}

}
