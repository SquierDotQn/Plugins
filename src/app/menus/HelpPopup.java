package app.menus;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPopupMenu;

import app.model.WritingModel;

import plugins.Plugin;
/**
* This is the menu of all the loaded plugins, where their help can be viewed
* @author Théo Plockyn & Valentin Caulier
*/
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
	* Builds all the items in the dropdown menu
	*/
	public void build(){
		HelpListener hl = new HelpListener();
		JMenuItem menuItem;
		plugins.clear();
		plugins.addAll(wm.getPlugins());
		for(Plugin p : plugins){
			System.out.println("J'ai rajouté "+p.getLabel());
			menuItem = new JMenuItem(p.getLabel());
			menuItem.addActionListener(hl);
			this.add(menuItem);
		}
		
		
	}

	/**
	* Help dropdown menu's listener
	* Handles the actions when a item is clicked ( ie shows the help message of the selected plugin )
	*/
	class HelpListener implements ActionListener {

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
