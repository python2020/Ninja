package arrays;

public class Candy {
	public int candy(int[] ratings) {
		int[] c = new int[ratings.length];
		c[0] = 1;

		for (int i = 1; i < c.length; i++) 
			if (ratings[i] > ratings[i-1]) c[i] = c[i-1] + 1;
			else c[i] = 1;

		int s = c[c.length-1];
		for (int i = c.length-2; i >= 0; i--) {
			if (ratings[i] > ratings[i+1] && c[i] <= c[i+1]) c[i] = c[i+1] + 1;
			s += c[i];
		}

		return s;
	}
}
