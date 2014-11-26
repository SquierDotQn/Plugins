package model;

public class WritingModel {

	protected String text;
	
	public WritingModel() {
	}

	public String getText() {
		return null;
	}
	
	public void transformText(Plugin p){
		this.text = p.transform(this.text);
	}

}
