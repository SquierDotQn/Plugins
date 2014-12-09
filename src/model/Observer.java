package model;

/**
 * Observer design pattern implementation
 */
public interface Observer {

	/**
	 * Method update(), should be used to warn/fire the observer from the Observable
	 */
	public void update();
	
}
