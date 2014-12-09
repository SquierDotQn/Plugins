package app.model;

import static org.junit.Assert.fail;

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
		fail("Not yet implemented");
	}
	
	@Test
	public void createInstancesTest(){
		fail("Not yet implemented");
	}
	
	@Test
	public void getClassesTest(){
		fail("Not yet implemented");
	}
	
	@Test
	public void getInstancesTest(){
		fail("Not yet implemented");
	}
	
}
