package app.window;

import static org.junit.Assert.*;

import org.junit.Assert;
import org.junit.Test;

import app.model.WritingModel;

public class WritingPanelTest {

	@Test
	public void testUpdateObservableObject() {
		WritingModel wrim = new WritingModel();
		WritingPanel mp = new WritingPanel(wrim);
		wrim.setText("azerty");
		Assert.assertEquals("azerty", mp.textarea.getText());
	}

}
