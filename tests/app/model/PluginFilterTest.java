package app.model;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.io.File;
import java.io.IOException;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TemporaryFolder;

public class PluginFilterTest {

	private File correctFile;
	private File wrongFile;
	private PluginFilter filter;
	
	@Rule
	public TemporaryFolder directory = new TemporaryFolder();
	
	@Before
	public void initFilesAndFolder() throws IOException{
		correctFile = directory.newFile("testFile.class");
		wrongFile = directory.newFile("testFile.java");
		filter = new PluginFilter(directory.getRoot());
	}
	
	@Test
	public void acceptTest(){
		assertTrue(filter.accept(correctFile.getParentFile(), correctFile.toString()));
		assertFalse(filter.accept(wrongFile.getParentFile(), wrongFile.toString()));
	}
}
