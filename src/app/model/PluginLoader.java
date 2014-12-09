package app.model;

import java.io.File;
import java.lang.reflect.Modifier;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLClassLoader;
import java.util.ArrayList;
import java.util.Collection;

import plugins.Plugin;

/**
 * A PluginLoader is able to return a list of classes, or instances of classes,
 * from a PluginFinder to a WritingModel
 * @author Théo Plockyn & Valentin Caulier
 */
public class PluginLoader implements Observer {

	private WritingModel model;
	
	private PluginFinder observed;
	private Collection<Class<Plugin>> classes;
	private Collection<Plugin> instances;
	
	/**
	 * Constructor of PluginLoader
	 * @param finder The PluginFinder which will be used by the PluginLoader to find new elements/plugins 
	 * @param model The WritingModel which will be "fired" each time new Plugin(s) is(are) pre-loaded
	 */
	public PluginLoader(PluginFinder finder, WritingModel model){
		this.model = model;
		this.instances = new ArrayList<Plugin>();
		this.observed = finder;
		this.classes = new ArrayList<Class<Plugin>>();
		this.observed.addObserver(this);
	}
	
	@SuppressWarnings("unchecked")
	@Override
	/**
	 * The method update() from the Observer design pattern, used to synchronized the PluginFinder and PluginLoader
	 */
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
				if(newPlugin!=null){
					this.classes.add(newPlugin);
					System.out.println(newPlugin+" pre-loaded !");
				}
			} catch (ClassNotFoundException e1) {
				e1.printStackTrace();
			}
			
		}
		this.model.fireModel();
	}
	
	/**
	 * Will create new instances of classes' objects from the ArrayList this.plugins
	 */
	private void createInstances(){
		this.instances.clear();
		for(Class<Plugin> plugin : this.classes){
			
			Plugin tmp = null;
			try {
				if(!plugin.isInterface() && !Modifier.isAbstract(plugin.getModifiers()))
					tmp = plugin.newInstance();
			} catch (InstantiationException | IllegalAccessException e) {
				e.printStackTrace();
			}
			
			if(tmp!=null){
				System.out.println("New instance of "+tmp.getLabel()+" created !");
				this.instances.add( tmp );
			}
		}
	}
	
	/**
	 * Getter of this.plugins
	 * @return the list of Plugin's classes stored in the PluginLoader
	 */
	public Collection<Class<Plugin>> getClasses(){
		return this.classes;
	}
	
	/**
	 * getter of this.instances
	 * Will recreate the list of Plugin's instances, and then, return it
	 * @return the list of Plugin's instances stored in the PluginLoader
	 */
	public Collection<Plugin> getInstances(){
		this.createInstances();
		return this.instances;
	}

}
