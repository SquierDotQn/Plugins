package model;

import java.util.ArrayList;
import java.util.Collection;

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
		this.classes.clear();
		this.classes.addAll(this.observed.getState());
	}

}
