package app.model;

import org.junit.Before;
import org.junit.Test;

public class PluginLoaderTest implements ObserverTest {

	private PluginLoader loader;
	private MockWritingModel model;
	private MockPluginFinder finder;
	
	@Before
	public void init(){
		loader = new PluginLoader(finder, model);		
	}
	
	@Test
	public void updateTest() {
		
	}
	
	@Test
	public void createInstancesTest(){
		
	}
	
	@Test
	public void getClassesTest(){
		
	}
	
	@Test
	public void getInstancesTest(){
	}
	
}
