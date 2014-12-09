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
	}
	
	@Test
	public void UpdateFilesTest() {
		this.observable.addObserver(this.mockObserver);
		
		assertEquals(this.mockObserver.nbTimesUpdated,0);
		File dropins = new File("./dropins/plugins/");
		int preUpdate=0;
		if(dropins.listFiles().length!=0){
			try {
				this.observable.updateFiles();
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}
			preUpdate++;
		}
		
		File wrongPlugin = new File(dropins.getAbsolutePath()+"/JUnitTest_wrongPlugin.java");
		wrongPlugin.deleteOnExit();
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
		
		assertEquals(this.mockObserver.nbTimesUpdated,0+preUpdate); // nothing found
		
		File acceptablePlugin = new File(dropins.getAbsolutePath()+"/JUnitTest_acceptablePlugin.class");
		acceptablePlugin.deleteOnExit();
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
		
		assertEquals(this.mockObserver.nbTimesUpdated,1+preUpdate); // something found
				
	}

	@Test
	public void getStateTest() {
		assertTrue(this.observable.getState().isEmpty());
		
		File dropins = new File("./dropins/plugins/");
		File plugin = new File(dropins.getAbsolutePath()+"/JUnitTest_plugin.class");
		plugin.deleteOnExit();
		try {
			plugin.createNewFile();
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
		
		boolean found = false;
		for(File f : this.observable.getState()){
			if(plugin.getName().equals(f.getName()))
				found=true;
		}
		
		assertTrue(found);
	}

}
