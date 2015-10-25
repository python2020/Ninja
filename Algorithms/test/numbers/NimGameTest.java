package numbers;

import static org.junit.Assert.*;

import org.junit.Test;

public class NimGameTest {

	@Test
	public void testCanWinNim() {
		NimGame nimGame = new NimGame();
		assertEquals(true, nimGame.canWinNim(13));
		assertEquals(false, nimGame.canWinNim(12));
	}

}
