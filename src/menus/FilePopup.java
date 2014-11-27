package menus;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

import javax.swing.JFileChooser;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPopupMenu;


@SuppressWarnings("serial")
public class FilePopup extends JPopupMenu {

	private JMenuItem newbutton, open, exit;
	public FilePopup()  {
		this.build();
	}
	/**
	 * Permet de construire les éléments graphiques du menu contextuel
	 */
	public void build(){
		FileListener fl = new FileListener();
		newbutton = new JMenuItem("Nouveau"/*, new ImageIcon("ressources/icon/new.png")*/);
		newbutton.addActionListener(fl);
		open = new JMenuItem("Ouvrir"/*,new ImageIcon("ressources/icon/open.png")*/);
		open.addActionListener(fl);
		exit = new JMenuItem("Quitter"/*, new ImageIcon("ressources/icon/remove.png")*/);
		exit.addActionListener(fl);
		this.add(newbutton);
		this.add(open);
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
			if(e.getSource().equals(open)) {
				JFileChooser fc = new JFileChooser();
				fc.showOpenDialog(null);
				File fichier = fc.getSelectedFile();
				//paint.open(fichier.getAbsolutePath()); Ouvrir fichier
			}else if(e.getSource().equals(newbutton)){
				int reponse = JOptionPane.showConfirmDialog(null, "Toutes les modifications non enregistrées seront perdues. Continuer?", "Créer un nouveau document?", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
				if(reponse == JOptionPane.YES_OPTION){
					// Remettre à zéro
				}
			}else if(e.getSource().equals(exit)){
				int reponse = JOptionPane.showConfirmDialog(null, "Toutes les modifications non enregistrées seront perdues. Continuer?", "Quitter?", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
				if(reponse == JOptionPane.YES_OPTION){
					System.exit(0);
				}
			}
		}

	}


}