package local.framework.gabbster;

import org.testng.Assert;
import org.testng.annotations.Test;

public class BaseTest {

	private BaseTest() {
		
	}
	
	@Test
	public void dummy_test() {
		boolean expected = true;
		boolean actual = false;
		Assert.assertEquals(expected, actual);		
	}
}
