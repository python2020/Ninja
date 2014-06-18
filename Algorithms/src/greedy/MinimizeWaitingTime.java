package greedy;

import java.util.ArrayList;
import java.util.Collections;

public class MinimizeWaitingTime {
	public int minimizeWaitingTime(ArrayList<Integer> times) {
			Collections.sort(times);
			
			int total = 0;
			int n = times.size();
			for (int i = 0; i < n; i++) {
				total += times.get(i) * (n - i - 1);
			}
			
			return total;
	}
	
}
