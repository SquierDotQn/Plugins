package window;

import java.awt.FlowLayout;
import java.util.Observable;
import java.util.Observer;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;


import model.WritingModel;

/*
 * Doit être un observer vis à vis de Writing Model
 */
public class WritingPanel extends JPanel{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	protected final WritingModel wm;
	protected final JTextArea textfield;
	protected final JScrollPane sp;

	public WritingPanel(WritingModel wm) {
		super();
		this.wm = wm;
		setLayout(new FlowLayout());
		textfield = new JTextArea(5, 35);
		textfield.setText(wm.getText());
		sp = new JScrollPane(textfield);
		this.add(sp);
		setVisible(true);
	}
	//Main Program that starts Execution
	public static void main(String args[]) {
		JFrame testFrame = new JFrame("test");
		WritingPanel test = new WritingPanel(null);
		testFrame.add(test);
		testFrame.setSize(325, 100);
		testFrame.pack();
		testFrame.setVisible(true);
		testFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

}