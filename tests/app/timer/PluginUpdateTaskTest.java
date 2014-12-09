package app.timer;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

import app.model.MockPluginFinder;

public class PluginUpdateTaskTest {

	private MockPluginFinder mockFinder;
	private PluginUpdateTask task;
	
	@Before
	public void init(){
		mockFinder = new MockPluginFinder();
		task = new PluginUpdateTask(mockFinder);
	}
	
	@Test
	public void runTest(){
		assertEquals(this.mockFinder.nbTimesFilesUpdated,0);
		this.task.run();
		assertEquals(this.mockFinder.nbTimesFilesUpdated,1);
	}
	
}
