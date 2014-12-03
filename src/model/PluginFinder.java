package model;

import java.io.File;
import java.util.ArrayList;
import java.util.Collection;

import plugins.Plugin;


public class PluginFinder extends Observable {

	@SuppressWarnings("rawtypes")
	private Collection<Class> classes;
	
	@SuppressWarnings("rawtypes")
	public PluginFinder() {
		this.observers = new ArrayList<Observer>();
		this.classes = new ArrayList<Class>();
	}

	
	@SuppressWarnings("rawtypes")
	public void updateClasses(){
		
		boolean found=false;
		
		File dropins = new File("./plugins/dropins");
		File [] names = dropins.listFiles(new PluginFilter());
				
		Collection<Class> classestmp = new ArrayList<Class>();
		
		for(File plugin : names){
			System.out.println(plugin.getClass().getCanonicalName()+"\t\t"+plugin.getClass().getInterfaces().getClass().getCanonicalName());
			if(plugin.getClass().getInterfaces().getClass().equals(Plugin.class)){
				
				classestmp.add(plugin.getClass());
				
				if(!this.classes.contains(plugin.getClass())){
					found=true;
				}
			}
		}
		
		this.classes.clear();
		this.classes.addAll(classestmp);
		
		if(found)
			this.somethingHappen();
		
	}	
	
	@SuppressWarnings("rawtypes")
	public Collection<Class> getState(){
		return this.classes;
	}
	
}
