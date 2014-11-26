package model;

import java.io.File;
import java.util.ArrayList;
import java.util.Collection;


public class PluginFinder {

	
	
	public PluginFinder() {
		// TODO Auto-generated constructor stub
	}

	
	@SuppressWarnings("rawtypes")
	private Collection<Class> getFolderClasses (){
		File dropins = new File("./plugins/dropins");
		File [] names = dropins.listFiles(new PluginFilter());
		ArrayList<Class> classes = new ArrayList<Class>();
		
		for(File plugin : names){
			classes.add(plugin.getClass());
		}
		
		return classes;
	}	
	
	@SuppressWarnings("rawtypes")
	public Collection<Class> getPlugins (){
		ArrayList<Class> plugins = new ArrayList<Class>();
		plugins.addAll(getFolderClasses());
		

		
		return plugins;
	}
	
}
