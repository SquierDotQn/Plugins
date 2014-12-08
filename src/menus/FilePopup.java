package menus;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPopupMenu;

import model.WritingModel;


@SuppressWarnings("serial")
public class FilePopup extends JPopupMenu {
	protected WritingModel wm;
	private JMenuItem newbutton, /*open,*/ exit;
	public FilePopup(WritingModel wm)  {
		this.wm = wm;
		this.build();
	}
	/**
	 * Permet de construire les éléments graphiques du menu contextuel
	 */
	public void build(){
		FileListener fl = new FileListener();
		newbutton = new JMenuItem("Nouveau");
		newbutton.addActionListener(fl);
		exit = new JMenuItem("Quitter");
		exit.addActionListener(fl);
		this.add(newbutton);
		this.add(new Separator());
		this.add(exit);
	}

	/**
	 * Listener du menu contextuel "Fichier".
	 * Gère les actions entrainé par les différentes actions proposées.
	 */
	class FileListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			if(e.getSource().equals(newbutton)){
				wm.setText("");
			}else if(e.getSource().equals(exit)){
				int reponse = JOptionPane.showConfirmDialog(null, "Voulez vous vraiment quitter?", "Quitter?", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
				if(reponse == JOptionPane.YES_OPTION){
					System.exit(0);
				}
			}
		}

	}


}