package arrays;

import static org.junit.Assert.*;
import org.junit.Test;


public class MoveZeroesTest {

	@Test
	public void testMoveZeroes() {
		MoveZeroes moveZeroes = new MoveZeroes();
		int[] a = {0, 1, 0, 3, 1, 2};
		int[] expected = {1, 3, 1, 2, 0, 0};
		moveZeroes.moveZeroes(a);
		assertArrayEquals(expected, a);
	}

}
