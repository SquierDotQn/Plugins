package timer;

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
		this.finder.updateClasses();
	}
	
}
