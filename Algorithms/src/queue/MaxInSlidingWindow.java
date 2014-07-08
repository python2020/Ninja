package queue;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Deque;
import java.util.List;


public class MaxInSlidingWindow {
	
	public List<Integer> getMax(Iterator<Record> records, int w) {
		List<Integer> res = new ArrayList<Integer>();
		
		Deque<Record> q = new LinkedList<Record>();
		
		Record curr = null, first = null, last = null;
		int start = 0;
		while (records.hasNext()) {
			curr = records.next();
			start = curr.time - w; 
			
			// remove records outside current window
			while (!q.isEmpty()) {
				first = q.getFirst();
				if (first.time >= start) break;
				q.removeFirst();
			}
			
			// remove records whose values are smaller (affected by curr)
			// from the end
			while (!q.isEmpty()) {
				last = q.getLast();
				if (last.value >= curr.value) break;
				q.removeLast();
			}
			
			q.addLast(curr);
			
			res.add(q.getFirst().value);
		}
		
		return res;
	}
	
	
	
	public static void main(String[] args) {
		List<Record> input = new ArrayList<Record>();
		
		input.add(new Record(1, 8)); // 8 
		input.add(new Record(2, 6)); // 8
		input.add(new Record(2, 7)); // 8
		input.add(new Record(3, 1)); // 8
		input.add(new Record(5, 7)); // 7
		
		input.add(new Record(6, 7)); // 7
		input.add(new Record(7, 9)); // 9
		input.add(new Record(11, 3)); // 3
		input.add(new Record(12, 1)); // 3
		input.add(new Record(14, 5)); // 5
		
		input.add(new Record(17, 8)); // 8

		for (Integer i : (new MaxInSlidingWindow()).getMax(input.iterator(), 3)) 
			System.out.println(i);
		
	}
}
