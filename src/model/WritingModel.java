package model;

import plugins.Plugin;

public class WritingModel {

	protected String text;
	
	public WritingModel() {
		this.text = "";
	}

	public String getText() {
		return null;
	}
	
	public void setText(String text){
		this.text = text;
	}
	
	public void transformText(Plugin p){
		this.text = p.transform(this.text);
	}

}
