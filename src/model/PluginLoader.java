package model;

import java.util.Collection;

public class PluginLoader implements Observer {

	private Observable observed;
	@SuppressWarnings("rawtypes")
	private Collection<Class> classes;
	
	
	@Override
	public void update() {
		this.classes = this.observed.getState();
	}

}
