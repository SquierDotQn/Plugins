package window;

import java.awt.FlowLayout;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Observable;
import java.util.Observer;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

import model.WritingModel;

/**
 * This class contains the text area, where the input is mad
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
	 * @args WritingModel wrim the writing model used everywhere else
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

	// TODO doesn't get called ?!
	@Override
	public void update(Observable o, Object arg) {
		textarea.setText(wm.getText());
	}

	
}