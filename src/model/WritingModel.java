package model;

import java.util.Collection;
import java.util.Observable;
import java.util.Timer;

import plugins.Plugin;
import timer.PluginUpdateTask;

public class WritingModel extends Observable{

	protected String text;
	private Timer loadingTask;
	private PluginFinder finder;
	private PluginLoader loader;
	
	public WritingModel() {
		this.text = "";
		this.initTimer();
	}

	public String getText() {
		return text;
	}
	
	public void setText(String text){
		this.text = text;
		System.out.println("J'ai changé de texte : "+text);
		this.notifyObservers();
	}
	
	public void transformText(Plugin p){
		this.text = p.transform(this.text);
		System.out.println("J'ai changé de texte : "+text);
		this.notifyObservers();
	}

	public void initTimer(){
		this.loadingTask = new Timer();
		this.finder = new PluginFinder();
		this.loader =  new PluginLoader(this.finder,this);
		this.loadingTask.schedule(new PluginUpdateTask(this.finder), 0, 1000);
	}
	
	public Collection<Plugin> getPlugins(){
		return this.loader.getInstances();
	}
	
	public void fireModel(){
		this.loader.getInstances();
	}
	
	
}
