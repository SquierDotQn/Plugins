package app.menus;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JMenuItem;
import javax.swing.JPopupMenu;

import app.model.WritingModel;
import plugins.Plugin;


/**
 * This is the menu of all the loaded plugins, where they can be used
 * @author Théo Plockyn & Valentin Caulier
 */
@SuppressWarnings("serial")
public class ToolPopup extends JPopupMenu {
	protected WritingModel wm;
	private List<Plugin> plugins;
	public ToolPopup(WritingModel wm)  {
		this.wm = wm;
		this.plugins = new ArrayList<Plugin>();
		this.build();
	}
	/**
	 * Builds all the items in the dropdown menu
	 */
	public void build(){
		ToolsListener tl = new ToolsListener();
		JMenuItem menuItem;
		plugins.clear();
		plugins.addAll(wm.getPlugins());
		for(Plugin p : plugins){
			System.out.println("J'ai rajouté "+p.getLabel());
			menuItem = new JMenuItem(p.getLabel());
			menuItem.addActionListener(tl);
			this.add(menuItem);
		}
		
		
	}

	/**
	 * Tools dropdown menu's listener
	 * Handles the actions when a item is clicked ( ie applies the plugin transformation to the wm text )
	 */
	class ToolsListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			for(Plugin p : plugins){
				if(p.getLabel().equals(((JMenuItem)e.getSource()).getText())){
					wm.transformText(p);
				}
			}
		}

	}
}
