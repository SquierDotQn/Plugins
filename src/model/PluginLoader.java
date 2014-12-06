package model;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLClassLoader;
import java.util.ArrayList;
import java.util.Collection;

import plugins.Plugin;

public class PluginLoader implements Observer {

	private WritingModel model;
	
	private Observable observed;
	private Collection<Class<Plugin>> classes;
	private Collection<Plugin> instances;
	
	public PluginLoader(PluginFinder finder, WritingModel model){
		this.model = model;
		this.instances = new ArrayList<Plugin>();
		this.observed = finder;
		this.classes = new ArrayList<Class<Plugin>>();
		this.observed.addObserver(this);
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public void update() {
		URL[] dropins = null;
		try {
			URL[] path={new URL("file:./dropins/")};
			dropins = path;
		} catch (MalformedURLException e1){
			e1.printStackTrace();
		}
		ClassLoader cl = new URLClassLoader(dropins);
		
		System.out.println("Class list cleared");
		this.classes.clear();
		
		Collection<File> plugins = this.observed.getState();
		
		for(File f: plugins){
			
			String name = f.getName().replace(".class", "");
			Class<Plugin> newPlugin = null;
			
			try {
				newPlugin = (Class<Plugin>) Class.forName("plugins."+name, true, cl);
			} catch (ClassNotFoundException e1) {
				e1.printStackTrace();
			}
			
			if(newPlugin!=null){
				this.classes.add(newPlugin);
				System.out.println("Classe "+newPlugin+" loaded !");
			}
		}
		this.model.fireModel();
	}
	
	private void createInstances(){
		this.instances.clear();
		for(Class<Plugin> plugin : this.classes){
			
			Plugin tmp = null;
			try {
				tmp = plugin.newInstance();
			} catch (InstantiationException | IllegalAccessException e) {
				e.printStackTrace();
			}
			
			if(tmp!=null){
				System.out.println("New instance of "+tmp.getLabel()+" created !");
			}
			
			try {
				this.instances.add( plugin.newInstance() );
			} catch (InstantiationException | IllegalAccessException e) {
				e.printStackTrace();
			}
		}
	}
	
	public Collection<Class<Plugin>> getClasses(){
		return this.classes;
	}
	
	public Collection<Plugin> getInstances(){
		this.createInstances();
		return this.instances;
	}

}
