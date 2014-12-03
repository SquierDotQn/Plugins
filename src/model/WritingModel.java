package model;

import java.util.Observable;

import plugins.Plugin;

public class WritingModel extends Observable{

	protected String text;
	
	public WritingModel() {
		this.text = "";
	}

	public String getText() {
		return text;
	}
	
	public void setText(String text){
		this.text = text;
		notifyObservers();
	}
	
	public void transformText(Plugin p){
		this.text = p.transform(this.text);
		notifyObservers();
	}

}
