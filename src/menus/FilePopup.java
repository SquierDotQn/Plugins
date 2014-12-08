package menus;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPopupMenu;

import model.WritingModel;

/**
* This is the file menu, where the text can be reset and the window can be exited
* @author Théo Plockyn & Valentin Caulier
*/
@SuppressWarnings("serial")
public class FilePopup extends JPopupMenu {
	protected WritingModel wm;
	private JMenuItem newbutton, exit;
	public FilePopup(WritingModel wm)  {
		this.wm = wm;
		this.build();
	}
	/**
	* Builds all the items in the dropdown menu
	*/
	public void build(){
		FileListener fl = new FileListener();
		newbutton = new JMenuItem("New text");
		newbutton.addActionListener(fl);
		exit = new JMenuItem("Exit");
		exit.addActionListener(fl);
		this.add(newbutton);
		this.add(new Separator());
		this.add(exit);
	}

	/**
	* File dropdown menu's listener
	* Handles the actions when a item is clicked
	*/
	class FileListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			if(e.getSource().equals(newbutton)){
				wm.setText("");
			}else if(e.getSource().equals(exit)){
				int reponse = JOptionPane.showConfirmDialog(null, "Do you really want to exit ?", "Exit?", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
				if(reponse == JOptionPane.YES_OPTION){
					System.exit(0);
				}
			}
		}

	}


}
