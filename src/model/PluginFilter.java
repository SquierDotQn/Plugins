package model;

import java.io.File;
import java.io.FilenameFilter;

public class PluginFilter implements FilenameFilter {

	private String directory;
	
	public PluginFilter(File directory) {
		this.directory=directory.getName();
	}

	@Override
	public boolean accept(File arg0, String arg1) {
		if(arg0.getName().equals(this.directory))
			if(arg1.endsWith(".class"))
				return true;
		return false;
	}
}
