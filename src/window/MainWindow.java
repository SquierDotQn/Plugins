package window;

import java.awt.BorderLayout;
import java.awt.Container;

import javax.swing.JFrame;
import javax.swing.JPanel;

import menus.TopMenuBar;
import model.WritingModel;

@SuppressWarnings("serial")
public class MainWindow extends JFrame{
	private final WritingPanel wp;
	private final WritingModel wm;
	private final TopMenuBar mb;
	
	public MainWindow(WritingModel wm){
		super("Plugin");
		this.wm = wm;
		this.wp = new WritingPanel(wm);
		this.mb = new TopMenuBar(wm);
		this.buildContentPane();
		this.setVisible(true);
	}
	
	public void buildContentPane(){
		Container c = this.getContentPane();
		c.setLayout(new BorderLayout());
		c.add(mb,BorderLayout.NORTH);
		c.add(wp, BorderLayout.CENTER);
		this.pack();
	}

	
	//Main Program that starts Execution
	public static void main(String args[]) {
		MainWindow testFrame = new MainWindow(null);
		testFrame.setSize(325, 100);
		testFrame.pack();
		testFrame.setVisible(true);
		testFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
}
