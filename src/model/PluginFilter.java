package model;

import java.io.File;
import java.io.FilenameFilter;

public class PluginFilter implements FilenameFilter {

	public PluginFilter() {
	}

	@Override
	public boolean accept(File arg0, String arg1) {
		return arg1.endsWith(".class");
	}

}
