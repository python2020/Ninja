package com.python2020.combinatorics;

import java.util.ArrayList;
import java.util.List;

public class Combinations {
    public List<List<Integer>> combine(int n, int k) {
        ArrayList<List<Integer>> results = new ArrayList<List<Integer>>();
        ArrayList<Integer> result = new ArrayList<Integer>();
        
        combineHelper(n, k, 1, result, results);
       
        return results;
    }
    
    public void combineHelper(int n, int k, int p, ArrayList<Integer> result, List<List<Integer>> results) {
        if (k == 0) {
            results.add((ArrayList<Integer>) result.clone());
        } else {
            for (int i = p; i <= n; i++) {
                result.add(i);
                combineHelper(n, k-1, i+1, result, results);
                result.remove(result.size() - 1);        
            }
        }
    }
}
