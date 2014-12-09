package app.model;

import junit.framework.Assert;

import org.junit.Before;
import org.junit.Test;

import plugins.Plugin;

public class WritingModelTest {

	WritingModel wm;
	String transformer = "42";
	
	@Before
	public void setUp(){
		wm = new WritingModel();
	}
	
	@Test
	public void testTransformText(){
		String text = "tata";
		wm.setText(text);
		wm.transformText(new MockupPlugin());
		Assert.assertEquals(transformer, wm.getText());
	}


	class MockupPlugin implements Plugin{

		@Override
		public String transform(String s) {
			return transformer;
		}

		@Override
		public String getLabel() {
			return "mockup";
		}

		@Override
		public String helpMessage() {
			return "mockup";
		}
		
	}

}
