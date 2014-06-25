package priorityq;

import static org.junit.Assert.*;
import java.util.ArrayList;
import java.util.Iterator;
import org.junit.Test;

public class MyTopQueriesTest {    
	@Test(expected=IllegalArgumentException.class) 
	public void TestInvalidK() {
		ArrayList<String> queries = new ArrayList<String>();;
		Iterator<String> queryIter = queries.iterator();
		int k = -1;
		MyTopQueries myTopQueries = new MyTopQueries();
		myTopQueries.getTopKQueries(queryIter, k);
	}

	@Test
	public void TestResultNoTie() {
		ArrayList<String> queries = new ArrayList<String>();		
		ArrayList<String> expected = new ArrayList<String>();
		String[] qs = {"a", "b", "c", "d", "e", "f"};
		String q;
		for (int i = 0, max = qs.length; i < qs.length; i++, max--) {
			q = qs[i];
			for (int j = 0; j < max; j++)
				queries.add(q);
			expected.add(q);
		}
		
		Iterator<String> queryIter = queries.iterator();		
		MyTopQueries myTopQueries = new MyTopQueries();
		ArrayList<String> results;
		
		int k = 3;
		results = myTopQueries.getTopKQueries(queryIter, k);
		
		int size = results.size();
		assertTrue(k >= results.size());
		for (int i = 0; i < size; i++)
			assertTrue(expected.get(size-1-i).equals(results.get(i)));
	}

	@Test
	public void TestResultTie() {
		ArrayList<String> queries = new ArrayList<String>();		
		ArrayList<String> expected = new ArrayList<String>();
		String[] qs = {"a", "b", "c", "d", "e", "f"};
		String q;
		for (int i = 0, max = qs.length; i < qs.length; i++) {
			q = qs[i];
			for (int j = 0; j < max; j++)
				queries.add(q);
			expected.add(0, q); // f, d, e, ..
		}
				
		Iterator<String> queryIter = queries.iterator();		
		MyTopQueries myTopQueries = new MyTopQueries();
		ArrayList<String> results;
		int k = 3;
		results = myTopQueries.getTopKQueries(queryIter, k);
		int size = results.size();
		
		assertTrue(k >= results.size());
		for (int i = 0; i < size; i++) {
			assertTrue(expected.get(i).equals(results.get(size-1-i)));
		}
	}
	
}
