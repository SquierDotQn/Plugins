package app.model;

import app.model.Observer;

public class MockObserver implements Observer {

	protected int nbTimesUpdated;
	
	public MockObserver(){
		this.nbTimesUpdated = 0;
	}
	@Override
	public void update() {
		this.nbTimesUpdated++;
	}

}
