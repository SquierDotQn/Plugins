package model;

import org.junit.Before;
import org.junit.Test;

public class PluginFinderTest extends ObservableTest {

	@Before
	public void initObservable(){
		super.initMockObserver();
		this.observable = new PluginFinder();
		
	}
	
	@Test
	public void getStateTest() {
		// TODO Auto-generated method stub
		
	}

}
