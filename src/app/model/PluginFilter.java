package app.model;

import java.io.File;
import java.io.FilenameFilter;

/**
 * A simple FilenameFilter, searching for .class,
 * in a specified folder 
 */
public class PluginFilter implements FilenameFilter {

	private String directory;
	
	/**
	 * The constructor of a PluginFilter for a specific directory
	 * @param directory The folder in which the PluginFilter is expecting to find the .class
	 */
	public PluginFilter(File directory) {
		this.directory=directory.getName();
	}

	@Override
	/**
	 * Method accept() is expecting to find .class in the directory specified at instantiation.
	 */
	public boolean accept(File arg0, String arg1) {
		if(arg0.getName().equals(this.directory))
			if(arg1.endsWith(".class"))
				return true;
		return false;
	}
}
