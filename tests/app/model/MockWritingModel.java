package app.model;

public class MockWritingModel extends WritingModel {

	protected int nbTimesFired;
	
	public MockWritingModel(){
		this.nbTimesFired = 0;
	}
	
	public void fireModel(){
		this.nbTimesFired++;
	}
	
}
