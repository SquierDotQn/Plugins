package model;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.net.URLClassLoader;
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
	public void updateClasses() throws ClassNotFoundException, IOException{
		
		boolean found=false;
		
		File dropins = new File("./plugins/dropins/");
		File [] names = dropins.listFiles(new PluginFilter());
				
		Collection<Class> classestmp = new ArrayList<Class>();
		
		URL[] pathes = {new URL("file:./plugins/dropins/")};
		
		URLClassLoader loader = new URLClassLoader(pathes);
		
		for(File plugin : names){
			Class c = loader.loadClass(plugin.getName().replace(".class", ""));
			
			System.out.println(c.getClass().getCanonicalName()+"\t\t"+c.getClass().getInterfaces().getClass().getCanonicalName());
			
			if(c.getClass().getInterfaces().getClass().equals(Plugin.class)){
				
				classestmp.add(c);
				
				if(!this.classes.contains(c.getClass())){
					found=true;
				}
			}
		}
		
		loader.close();
		
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
