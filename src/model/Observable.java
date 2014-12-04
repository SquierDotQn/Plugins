package model;

import java.io.File;
import java.util.Collection;
import java.util.List;

public abstract class Observable {

	protected List<Observer> observers;
	
	public void addObserver(Observer o){
		this.observers.add(o);
	}
	
	public void removeObserver(Observer o){
		this.observers.remove(o);
	}
	
	public void somethingHappen(){
		this.fireObservers();
	}
	
	protected void fireObservers(){
		for(Observer o : this.observers){
			o.update();
		}
	}

	public abstract Collection<File> getState();
	
}
