package menus;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

import model.WritingModel;

/**
 * This class is the top bar containing all three menus
 * @author Théo Plockyn & Valentin Caulier
 */
@SuppressWarnings("serial")
public class TopMenuBar extends JMenuBar{
	
	private JMenuItem file, tools, help;
	private WritingModel wm;
	
	public TopMenuBar(){
		this(new WritingModel());
	}
	
	public TopMenuBar(WritingModel wm) {
		this.wm = wm;
		build();
	}

	/**
	 * Creates the menus File, Tools and Help
	 */
	public void build(){
		MenuListener ml = new MenuListener();
		file = new JMenuItem("File");
		file.addActionListener(ml);
		tools = new JMenuItem("Tools");
		tools.addActionListener(ml);
		help = new JMenuItem("Help");
		help.addActionListener(ml);
		setLayout(new BorderLayout());
		this.add(file, BorderLayout.WEST);
		this.add(tools, BorderLayout.CENTER);
		this.add(help, BorderLayout.EAST);
		this.setVisible(true);
	}
	
	/**
	 * MenuBar listener, when clicked show the appropriate menu
	 * @author Théo Plockyn & Valentin Caulier
	 */
	class MenuListener implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			Component source = (Component) e.getSource();
			if(e.getSource().equals(file)){
				new FilePopup(wm).show(source,0,getHeight());
			}else if(e.getSource().equals(tools)){
				new ToolPopup(wm).show(source,0,getHeight());
			}else if(e.getSource().equals(help)){
				new HelpPopup(wm).show(source,0,getHeight());
			}
			
		}
		
	}

}
