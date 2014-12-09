package app.window;

import java.awt.FlowLayout;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Observable;
import java.util.Observer;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

import app.model.WritingModel;


/**
 * This class contains the text area, where the input is made
 * ( Note : it observe the WritingModel )
 * @author Théo Plockyn & Valentin Caulier
 */
public class WritingPanel extends JPanel implements Observer{
	private static final long serialVersionUID = 1L;

	protected final WritingModel wm;
	protected final JTextArea textarea;
	protected final JScrollPane sp;

	/**
	 * Creates the panel containing the text area, and updates the writing model when a key is typed.
	 * @param wrim the writing model used everywhere else
	 */
	public WritingPanel( WritingModel wrim) {
		super();
		this.wm = wrim;
		this.wm.addObserver(this);
		setLayout(new FlowLayout());
		textarea = new JTextArea(5, 35);
		textarea.setText(wm.getText());
		sp = new JScrollPane(textarea);
		// Observer that changes the model everytime a key is typed
		textarea.addKeyListener(new KeyListener() {
			@Override
			public void keyTyped(KeyEvent arg0) {
				// not used
			}

			@Override
			public void keyPressed(KeyEvent e) {
				// not used
			}

			@Override
			public void keyReleased(KeyEvent e) {
				wm.setText(textarea.getText());
			}
		});
		this.add(sp);
		setVisible(true);
	}

	@Override
	public void update(Observable o, Object arg) {
		textarea.setText(wm.getText());
	}

	
}
