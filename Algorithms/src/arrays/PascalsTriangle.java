package arrays;

import java.util.ArrayList;
import java.util.List;

public class PascalsTriangle {
    public List<List<Integer>> generate(int numRows) {
        ArrayList<List<Integer>> res = new ArrayList<List<Integer>>();
        if (numRows <= 0) return res;
        
        List<Integer> curr = new ArrayList<Integer>(), next = null;
        curr.add(1);
        res.add(curr);
        numRows--;
        
        int i = 1;
        while (i <= numRows) {
            next = new ArrayList<Integer>();
            
            next.add(1);
            for (int j = 1; j < i; j++) 
                next.add(curr.get(j-1) + curr.get(j));
            next.add(1);
            
            res.add(next);
            curr = next;
            i++;
        }
        
        return res;         
    }
}
