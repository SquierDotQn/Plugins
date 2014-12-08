package window;

import java.awt.BorderLayout;
import java.awt.Container;

import javax.swing.JFrame;
import javax.swing.JMenuBar;

import menus.TopMenuBar;
import model.WritingModel;

@SuppressWarnings("serial")
public class MainWindow extends JFrame{
	private final WritingPanel wp;
	private final WritingModel wm;
	private final JMenuBar mb;
	
	public MainWindow(WritingModel wm){
		super("Plugin");
		this.wm = wm;
		this.wp = new WritingPanel(wm);
		this.mb = new TopMenuBar(wm);
		this.buildContentPane();
		this.setVisible(true);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	public void buildContentPane(){
		Container c = this.getContentPane();
		c.setLayout(new BorderLayout());
		this.setJMenuBar(mb);
		c.add(wp, BorderLayout.SOUTH);
		this.pack();
	}

	

}
