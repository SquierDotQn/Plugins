package timer;

import java.io.IOException;
import java.util.TimerTask;

import model.PluginFinder;

public class PluginUpdateTask extends TimerTask {

	private PluginFinder finder;
	
	public PluginUpdateTask(PluginFinder finder){
		super();
		this.finder = finder;
	}

	@Override
	public void run() {
		try {
			this.finder.updateFiles();
		} catch (ClassNotFoundException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
}
