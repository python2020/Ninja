package numbers;

public class NimGame {
	public boolean canWinNim(int n) {
		// 123456789..
		// axxbaxxba...
		// 1 + 4m = n - [0,1,2]
		// => (n + 3) mod 4 = 0, 1, or 2
		return (n + 3) % 4 <= 2;
	}
}
