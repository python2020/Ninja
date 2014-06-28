package dp;

import java.util.List;

public class Triangle {
    public int minimumTotal(List<List<Integer>> triangle) {
        int size = triangle.size();
        int[] f = new int[size];
        
        List<Integer> curr = null;
        for (int i = 0; i < size; i++) {
            curr = triangle.get(i);
            
            // right to left 
            if (i > 0) f[i] = f[i-1] + curr.get(i);
            
            for (int j = i - 1; j > 0; j--) 
                f[j] = Math.min(f[j-1], f[j]) + curr.get(j);
            
            f[0] += curr.get(0);
            
        }    
        
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < f.length; i++) min = Math.min(min, f[i]);
        
        return min;
    }
}
