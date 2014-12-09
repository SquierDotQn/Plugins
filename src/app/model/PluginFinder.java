package app.model;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;

/**
 * A PluginFinder will search for new plugins in the hard-coded folder "dropins"
 * @author Théo Plockyn & Valentin Caulier
 */
public class PluginFinder extends Observable {

	/**
	 * Containing the list of plugins
	 */
	private Collection<File> plugins;
	
	/**
	 * PluginFinder constructor
	 */
	public PluginFinder() {
		this.observers = new ArrayList<Observer>();
		this.plugins = new ArrayList<File>();
	}

	/**
	 * Updates Plugin's File list
	 * @throws ClassNotFoundException
	 * @throws IOException
	 */
	public void updateFiles() throws ClassNotFoundException, IOException{
		
		boolean found=false;
		
		File dropins = new File("./dropins/plugins/");
		File [] names = dropins.listFiles(new PluginFilter(dropins));
		if(names.length==0){
			return;
		}
		Collection<File> pluginstmp = new ArrayList<File>();
		
		for(File plugin : names){
			pluginstmp.add(plugin);
			if(!this.plugins.contains(plugin)){ // something has been added
				found=true;
			}
		}
		
		for(File f : this.plugins){
			if(!pluginstmp.contains(f))
				found=true; // something has been removed
		}
		
		this.plugins.clear();
		this.plugins.addAll(pluginstmp);
		
		if(found)
			this.somethingHappens();
		
	}	
	
	/**
	 * getState() will returns the current list of Plugin's Files, as the current state of the finder.
	 */
	public Collection<File> getState(){
		return this.plugins;
	}
	
}
