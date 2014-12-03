package window;

import java.awt.FlowLayout;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Observable;
import java.util.Observer;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;


import model.WritingModel;

/*
 * Doit être un observer vis à vis de Writing Model
 */
public class WritingPanel extends JPanel implements Observer{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	protected final WritingModel wm;
	protected final JTextArea textfield;
	protected final JScrollPane sp;

	public WritingPanel( WritingModel wm) {
		super();
		this.wm = wm;
		setLayout(new FlowLayout());
		textfield = new JTextArea(5, 35);
		textfield.setText(wm.getText());
		sp = new JScrollPane(textfield);
		// textfield.; METTRE UN OBSERVER QUI VERIFIE QUAND LE TEXTE DU TEXTFIELD CHANGE, ET FAIRE UN wm.setText(textfield.getText());
		this.add(sp);
		setVisible(true);
	}

	@Override
	public void update(Observable o, Object arg) {
		textfield.setText(wm.getText());
	}

	
}