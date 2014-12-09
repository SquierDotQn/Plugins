package app.model;

/**
 * Observer design pattern implementation
 * @author Théo Plockyn & Valentin Caulier
 */
public interface Observer {

	/**
	 * Method update(), should be used to warn/fire the observer from the Observable
	 */
	public void update();
	
}
