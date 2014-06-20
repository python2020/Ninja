package numbers;

import java.util.ArrayList;
import java.util.List;

public class GrayCode {
	public List<Integer> grayCode(int n) {
		List<Integer> res = new ArrayList<Integer>();
		res.add(0);
		int m = 0, size = 0;
		for (int i = 1; i <= n; i++) {
			size = res.size();
			m = 1 << (i-1);
			for (int j = size-1; j >= 0; j--)
				res.add(m + res.get(j)); 
		}

		return res;
	}
}
