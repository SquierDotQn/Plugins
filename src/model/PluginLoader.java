package model;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLClassLoader;
import java.util.ArrayList;
import java.util.Collection;

import plugins.Plugin;

public class PluginLoader implements Observer {

	private Observable observed;
	private Collection<Class<Plugin>> classes;
	
	public PluginLoader(PluginFinder finder){
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
				System.out.println("Classe "+newPlugin+" chargée !");
			}
		}
	}

}
