package app.model;

import static org.junit.Assert.assertTrue;

import java.io.File;
import java.io.IOException;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class PluginFilterTest {

	private File correctFile;
	private File wrongFile;
	private File directory;
	
	@Before
	public void initFilesAndFolder() throws IOException{
		directory = new File("./testDir");
		directory.mkdir();
		correctFile = new File("./testDir/testFile.class");
		correctFile.createNewFile();
		wrongFile = new File("./testDir/testFile.java");
		wrongFile.createNewFile();
	}
	
	@Test
	public void acceptTest(){
		File [] names = directory.listFiles(new PluginFilter(directory));
		boolean correctFileFound=false;
		boolean wrongFileFound=false;
		for(File f : names){
			if(f.toString()==correctFile.toString())
				correctFileFound=true;
			if(f.toString()==wrongFile.toString())
				wrongFileFound=true;
		}
		assertTrue(correctFileFound && !wrongFileFound);
	}
	
	@After
	public void removeFilesAndFolder(){
		correctFile.delete();
		wrongFile.delete();
		directory.delete();
	}
}
