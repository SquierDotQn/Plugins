package app.model;

import java.io.File;
import java.io.IOException;
import java.util.Collection;

public class MockPluginFinder extends PluginFinder {

	public int nbTimesFilesUpdated;
	public int nbTimesStateGet;
	
	public MockPluginFinder(){
		super();
		this.nbTimesFilesUpdated = 0;
		this.nbTimesStateGet = 0;
	}
	
	public void updateFiles() throws ClassNotFoundException, IOException{
		super.updateFiles();
		nbTimesFilesUpdated++;
	}
	
	public Collection<File> getState(){
		nbTimesStateGet++;
		return super.getState();
	}
	
}
