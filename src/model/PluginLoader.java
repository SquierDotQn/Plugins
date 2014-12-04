package model;

import java.io.File;
import java.net.URL;
import java.util.ArrayList;
import java.util.Collection;

import plugins.Plugin;

public class PluginLoader implements Observer {

	private Observable observed;
	@SuppressWarnings("rawtypes")
	private Collection<Class> classes;
	
	@SuppressWarnings("rawtypes")
	public PluginLoader(PluginFinder finder){
		this.observed = finder;
		this.classes = new ArrayList<Class>();
		this.observed.addObserver(this);
	}
	
	@Override
	public void update() {
		ClassLoader cl = Plugin.class.getClassLoader();
		this.classes.clear();
		String path = new String("file:./plugins/dropins/");
		Collection<File> plugins = this.observed.getState();
		
		for(File f: plugins){
			String name = f.getName().replace(".class", "");
			try {
				this.classes.add(cl.loadClass(name));
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			}
		}
		/*
		this.classes.clear();
		this.classes.addAll(this.observed.getState());*/
		System.out.println("Trouve !");
		//System.out.println();		
		//for (@SuppressWarnings("rawtypes") Class c : this.classes){
		//	System.out.println(c.getName());
		//}
	}

}
