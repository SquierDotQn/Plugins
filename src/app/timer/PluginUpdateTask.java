package app.timer;

import java.io.IOException;
import java.util.TimerTask;

import app.model.PluginFinder;


/**
 * A TimerTask adapted to a Plugin's update
 * @author Théo Plockyn & Valentin Caulier
 */
public class PluginUpdateTask extends TimerTask {

	/**
	 * A PluginFinder, will be used by the TimerTask
	 */
	private PluginFinder finder;
	
	/**
	 * Constructor of a PluginUpdateTask for a given PluginFinder
	 * @param finder The PluginFinder the TimerTask will wake up and update
	 */
	public PluginUpdateTask(PluginFinder finder){
		super();
		this.finder = finder;
	}

	@Override
	/**
	 * The method run() of the TimerTask will ask the PluginFinder to update it's current Plugin's File list
	 */
	public void run() {
		try {
			this.finder.updateFiles();
		} catch (ClassNotFoundException | IOException e) {
			e.printStackTrace();
		}
	}
	
}
