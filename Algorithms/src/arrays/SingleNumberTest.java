package arrays;

import static org.junit.Assert.*;

import org.junit.Test;

public class SingleNumberTest {

	@Test
	public void testSingleNumber() {
		//fail("Not yet implemented");
		SingleNumber a = new SingleNumber();
		int[] input = {1,1,2,2,3};
		
		assertEquals(3,a.singleNumber(input));
	}

}
