package priorityq;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Comparator;

public class MyTopQueries {	   
	// O(nlgk)
	public ArrayList<String> getTopKQueries(Iterator<String> queryIter, int k) {
	    // error check
	    if (k <= 0) 
	    	throw new IllegalArgumentException("k=" + k + ",  k must be positive.");
	    
	    Map<String, Integer> queryToCounts = new HashMap<String, Integer>();
	    String query;
	    Integer cnt;
	    while (queryIter.hasNext()) {
	        query = queryIter.next();
	        cnt = queryToCounts.get(query);
	        if (cnt == null) 
	        	queryToCounts.put(query, 1);
	        else 
	        	queryToCounts.put(query, cnt + 1);
	    }
	    
	    Comparator<Map.Entry<String, Integer>> comparator = new Comparator<Map.Entry<String, Integer>>() {
	    	@Override
	    	public int compare(Map.Entry<String, Integer> e1, Map.Entry<String, Integer> e2) {
	    		int vdiff = e1.getValue() - e2.getValue();
	    		return vdiff != 0? vdiff : e1.getKey().compareTo(e2.getKey());
	    	}
	    };
	    
	    Iterator<Map.Entry<String, Integer>> entries = queryToCounts.entrySet().iterator();
	    PriorityQueue<Map.Entry<String, Integer>> minHeap = new PriorityQueue<Map.Entry<String, Integer>>(k+1, comparator);
	    int i = 0;
	    while (entries.hasNext()) {
	        minHeap.add(entries.next());
	        if (i == k) 
	        	minHeap.remove();
	        else 
	        	i++;
	    }

	    ArrayList<String> top = new ArrayList<String>();
	    while (!minHeap.isEmpty())
	    	top.add(minHeap.remove().getKey());
	    
	    
	    return top;
	}
	
}
