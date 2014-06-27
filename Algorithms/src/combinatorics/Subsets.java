package combinatorics;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Subsets {
	private int count = 0;
	
    public List<List<Integer>> subsets(int[] S) {
        ArrayList<List<Integer>> subs = new ArrayList<List<Integer>>();
        ArrayList<Integer> sub = new ArrayList<Integer>();
        
        Arrays.sort(S); // case-dependent
        
        //subsets0(S, sub, subs);
        //subsets1(0, S, sub, subs);
        subsets2(0, S, sub, subs);

        System.out.println(count);
        return subs;    
    }
    
    // 2^(n+1) nodes
	public void subsets1(int k, int[] S, ArrayList<Integer> sub, ArrayList<List<Integer>> subs) {
		count++;
        if (k == S.length) {
            subs.add((ArrayList<Integer>) sub.clone());
        } else {
            subsets1(k+1, S, sub, subs); // S[k] no selected
            
            sub.add(S[k]);              // S[k] selected
            subsets1(k+1, S, sub, subs);
            sub.remove(sub.size() - 1);
        }
    }
	
	// 2^n nodes
	public void subsets2(int kth, int[] S, ArrayList<Integer> sub, ArrayList<List<Integer>> subs) {
		count++;
		subs.add((ArrayList<Integer>) sub.clone());

		if (kth == S.length) return;
        
        for (int i = kth; i < S.length; i++) {
           	sub.add(S[i]);              
           	subsets2(i+1, S, sub, subs);
           	sub.remove(sub.size() - 1);	
        }
    }
	
	// use bits for element selection  
	public void subsets0(int[] S, ArrayList<Integer> sub, ArrayList<List<Integer>> subs) {
		int n = 1 << S.length;
		for (int i = 0; i < n; i++) {
			sub = new ArrayList<Integer>();
			int k = 0, m = i;
			while (m != 0) {
				if ((m & 1) == 1) sub.add(S[k]);
				m >>= 1;
				k++;
			}
			subs.add(sub);
		}
    }	
	
	public static void main(String[] args) {
		int N = 10;
		int[] S = new int[N];
		for (int i = 0; i < S.length; i++) 
			S[i] = i;
		
		Subsets x = new Subsets();
		x.subsets(S);
	}   
}
