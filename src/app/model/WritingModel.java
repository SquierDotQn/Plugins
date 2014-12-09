package app.model;

import java.util.Collection;
import java.util.Observable;
import java.util.Timer;

import app.timer.PluginUpdateTask;

import plugins.Plugin;
/**
 * WritingModel is the central class in the text editor's hierarchy,
 * it is here that the plugins will modify the text, and centralize all the behaviour of our project
 * ie it contains all the classes that finds, load, and use the plugins.
 * @author Théo Plockyn & Valentin Caulier 
 */
public class WritingModel extends Observable{

	protected String text;
	private Timer loadingTask;
	private PluginFinder finder;
	private PluginLoader loader;
	
	/**
	 * The constructor initialize the text to an empty string, and begins the plugin finder's timer.
	 */
	public WritingModel() {
		this.text = "";
		this.initTimer();
	}

	public String getText() {
		return text;
	}
	
	public void setText(String text){
		this.text = text;
		this.setChanged();
		this.notifyObservers();
	}
	
	/**
	 * This method applies the plugin's transformation to the model's text
	 * @args Plugin p the plugin used
	 */
	public void transformText(Plugin p){
		this.text = p.transform(this.text);
		System.out.println("Transformed to : "+text);
		this.setChanged();
		this.notifyObservers();
	}

	/**
	 * This method starts the timer in order to look for plugin updates
	 */
	public void initTimer(){
		this.loadingTask = new Timer();
		this.finder = new PluginFinder();
		this.loader =  new PluginLoader(this.finder,this);
		this.loadingTask.schedule(new PluginUpdateTask(this.finder), 0, 1000);
	}
	
	/**
	 * Plugins' getter
	 * @returns the collection of plugins actually loaded ( ie .class is in the dropins/plugins folder)
	 */
	public Collection<Plugin> getPlugins(){
		return this.loader.getInstances();
	}
	
	/**
	 * is called when there is a change in the loaded plugins, updating the current collection
	 */
	public void fireModel(){
		this.loader.getInstances();
	}
	
	
}
