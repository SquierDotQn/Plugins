package app.model;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.io.File;
import java.io.IOException;

import org.junit.Before;
import org.junit.Test;

public class PluginFinderTest extends ObservableTest<PluginFinder> {

	
	@Before
	public void initObservable(){
		super.initMockObserver();
		this.observable = new PluginFinder();
		this.observable.addObserver(this.mockObserver);
	}
	
	@Test
	public void UpdateFilesTest() {
		assertEquals(this.mockObserver.nbTimesUpdated,0);
		File dropins = new File("./dropins/plugins/");
		File wrongPlugin = new File(dropins.getAbsolutePath()+"/JUnitTest_wrongPlugin.java");
		System.out.println(wrongPlugin.getAbsolutePath());
		try {
			wrongPlugin.createNewFile();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		try {
			this.observable.updateFiles();
		} catch (ClassNotFoundException e1) {
			e1.printStackTrace();
		} catch (IOException e1) {
			e1.printStackTrace();
		}
		
		assertEquals(this.mockObserver.nbTimesUpdated,0); // nothing found
		
		File acceptablePlugin = new File(dropins.getAbsolutePath()+"/JUnitTest_acceptablePlugin.class");
		try {
			acceptablePlugin.createNewFile();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		try {
			this.observable.updateFiles();
		} catch (ClassNotFoundException e1) {
			e1.printStackTrace();
		} catch (IOException e1) {
			e1.printStackTrace();
		}
		
		assertEquals(this.mockObserver.nbTimesUpdated,1); // something found
		
		acceptablePlugin.delete();
		wrongPlugin.delete();
		
	}

	@Test
	public void getStateTest() {
		assertTrue(this.observable.getState().isEmpty());
		
		File dropins = new File("./dropins/plugins/");
		File acceptablePlugin = new File(dropins.getAbsolutePath()+"/JUnitTest_acceptablePlugin.class");
		try {
			acceptablePlugin.createNewFile();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		try {
			this.observable.updateFiles();
		} catch (ClassNotFoundException e1) {
			e1.printStackTrace();
		} catch (IOException e1) {
			e1.printStackTrace();
		}
		
		try {
			this.observable.updateFiles();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		assertTrue(this.observable.getState().contains(acceptablePlugin));
		
		acceptablePlugin.delete();
	}

}
