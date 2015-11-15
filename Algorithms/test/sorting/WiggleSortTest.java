package sorting;

import static org.junit.Assert.*;

import org.junit.Test;

public class WiggleSortTest {

	@Test
	public void testWiggleSort() {
		WiggleSort ws = new WiggleSort();
		int[] nums = {1,2,3,4,5,6};
		int[] expected = {1,3,2,5,4,6};
		ws.wiggleSort(nums);
		assertArrayEquals(expected, nums);
	}
}
