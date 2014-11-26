package window;

import javax.swing.JFrame;

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
		this.mb = new TopMenuBar();
	}
	
}
