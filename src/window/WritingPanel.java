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
	protected final JTextArea textarea;
	protected final JScrollPane sp;

	public WritingPanel( WritingModel wrim) {
		super();
		this.wm = wrim;
		this.wm.addObserver(this);
		setLayout(new FlowLayout());
		textarea = new JTextArea(5, 35);
		textarea.setText(wm.getText());
		sp = new JScrollPane(textarea);
		// Observer qui permet de changer le texte dès qu'on tape quelque chose
		textarea.addKeyListener(new KeyListener() {
			@Override
			public void keyTyped(KeyEvent arg0) {
				wm.setText(textarea.getText());
			}

			@Override
			public void keyPressed(KeyEvent e) {
				// not used
			}

			@Override
			public void keyReleased(KeyEvent e) {
				// not used
			}
		});
		this.add(sp);
		setVisible(true);
	}

	@Override
	public void update(Observable o, Object arg) {
		System.out.println("PIPO LE POPPIN");
		textarea.setText(wm.getText());
	}

	
}