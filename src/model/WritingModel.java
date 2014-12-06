package model;

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
		notifyObservers();
	}
	
	public void transformText(Plugin p){
		this.text = p.transform(this.text);
		notifyObservers();
	}

	public void initTimer(){
		this.loadingTask = new Timer();
		this.finder = new PluginFinder();
		this.loader =  new PluginLoader(this.finder,this);
		this.loadingTask.schedule(new PluginUpdateTask(this.finder), 0, 1000);
	}
	
	public void fireModel(){
		this.loader.getInstances();
	}
	
	
}
