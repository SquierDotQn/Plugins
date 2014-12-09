package app.model;

import java.util.List;

/**
 * Observable design pattern implementation
 */
public abstract class Observable {

	/**
	 * List of Observer(s) which will be fired every time something happens
	 */
	protected List<Observer> observers;
	
	/**
	 * Add an observer to the List of Observer(s)
	 * @param o The Observer we want to add to the list
	 */
	public void addObserver(Observer o){
		this.observers.add(o);
	}
	
	/**
	 * Remove an Observer from the List of Observer(s)
	 * @param o The Observer we want to remove from the list
	 */
	public void removeObserver(Observer o){
		this.observers.remove(o);
	}
	
	/**
	 * Something happens in the Observable, all Observer(s) from the list will be warned/fired
	 */
	public void somethingHappens(){
		this.fireObservers();
	}
	
	/**
	 * Firing all Observer(s) from the list
	 */
	protected void fireObservers(){
		for(Observer o : this.observers){
			o.update();
		}
	}

	/**
	 * Getting the current state of the Observable,
	 * @return The current Object of the Observable (something representing it's current state)
	 */
	public abstract Object getState();
	
}
