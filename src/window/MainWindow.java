package window;

import java.awt.BorderLayout;
import java.awt.Container;

import javax.swing.JFrame;
import javax.swing.JMenuBar;

import menus.TopMenuBar;
import model.WritingModel;
/**
 * This class is the main window of the text editor, it contains the model ( WritingModel ),
 * the menubar  and the text area ( WritingPanel ).
 * @author Théo Plockyn & Valentin Caulier
 */
@SuppressWarnings("serial")
public class MainWindow extends JFrame{
	private final WritingPanel wp;
	private final WritingModel wm;
	private final JMenuBar mb;
	
	/**
	 * The constructor initialize the content of the window, build it then set the window visible.
	 * @args WritingModel wm the model
	 */
	public MainWindow(WritingModel wm){
		super("Plugin");
		this.wm = wm;
		this.wp = new WritingPanel(this.wm);
		this.mb = new TopMenuBar(this.wm);
		this.buildContentPane();
		this.setVisible(true);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	/**
	 * Builds all the content of the window, sets the content to their places
	 */
	public void buildContentPane(){
		Container c = this.getContentPane();
		c.setLayout(new BorderLayout());
		this.setJMenuBar(mb);
		c.add(wp, BorderLayout.SOUTH);
		this.pack();
	}

	

}
