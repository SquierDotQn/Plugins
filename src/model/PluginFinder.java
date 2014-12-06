package model;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;


public class PluginFinder extends Observable {

	private Collection<File> plugins;
	
	public PluginFinder() {
		this.observers = new ArrayList<Observer>();
		this.plugins = new ArrayList<File>();
	}

	
	public void updateClasses() throws ClassNotFoundException, IOException{
		
		boolean found=false;
		
		File dropins = new File("./dropins/plugins/");
		File [] names = dropins.listFiles(new PluginFilter());
				
		Collection<File> pluginstmp = new ArrayList<File>();
		
		for(File plugin : names){
			
			pluginstmp.add(plugin);
			if(!this.plugins.contains(plugin)){
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
			this.somethingHappen();
		
	}	
	
	public Collection<File> getState(){
		return this.plugins;
	}
	
}
