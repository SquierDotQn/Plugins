package app.model;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

import app.model.Observable;

public abstract class ObservableTest<T extends Observable> {

	protected MockObserver mockObserver;
	protected T observable;
	
	
	public void initMockObserver(){
		this.mockObserver = new MockObserver();
	}
	
	@Before
	public abstract void initObservable();
	
	@Test
	public void addObserverTest(){
		int current = this.observable.observers.size();
		this.observable.addObserver(this.mockObserver);
		assertEquals(this.observable.observers.size(),1+current);
	}
	
	@Test
	public void removeObserverTest(){
		this.addObserverTest();
		assertEquals(this.observable.observers.size(),1);
		this.observable.removeObserver(this.mockObserver);
		assertEquals(this.observable.observers.size(),0);
	}
	
	@Test
	public void somethingHappensTest(){
		this.addObserverTest();
		assertEquals(this.mockObserver.nbTimesUpdated,0);
		this.observable.somethingHappens();
		assertEquals(this.mockObserver.nbTimesUpdated,1);
	}
	
	@Test
	public void fireObserversTest(){
		this.addObserverTest();
		assertEquals(this.mockObserver.nbTimesUpdated,0);
		this.observable.fireObservers();
		assertEquals(this.mockObserver.nbTimesUpdated,1);
		
		MockObserver o = new MockObserver();
		this.observable.addObserver(o);
		this.observable.fireObservers();
		assertEquals(this.mockObserver.nbTimesUpdated,2);
		assertEquals(o.nbTimesUpdated,1);
	}
	
	@Test
	public abstract void getStateTest();
}
