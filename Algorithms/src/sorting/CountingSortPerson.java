package sorting;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Map;
import java.util.Random;
import java.util.TreeMap;

public class CountingSortPerson {
	public static class Person implements Comparable<Person> {
		int key;
		String name;

		public Person(int k, String n) {
			key = k;
			name = n;
		}
		@Override
		public int hashCode() {
			return key + 32 * name.hashCode();
		}

		@Override
		public int compareTo(Person p) {
			return key - p.key;
		}

		@Override
		public boolean equals(Object o) {
			if (o instanceof Person) {
				Person p = (Person) o;
				return key == p.key && name.equals(p.name);  
			}
			
			return false;
		}
	}


	public static void countingSort(ArrayList<Person> ps) {
		Map<Integer, Integer> keyToCount = new TreeMap<Integer, Integer>();
		Integer c;
		for (Person p : ps) {
			c = keyToCount.get(p.key);
			if (c == null) c = 0;
			keyToCount.put(p.key, c + 1);
		}

		Map<Integer, Integer> keyToOffset = new TreeMap<Integer, Integer>();
		int start = 0;
		for (Map.Entry<Integer, Integer> entry : keyToCount.entrySet()) {	    	
			keyToOffset.put(entry.getKey(), start);
			start += entry.getValue();
		}

		Person p, t;
		Integer offset;
		int i = 0;
		while (i < ps.size()) {	    	
			p = ps.get(i);

			c = keyToCount.get(p.key);
			if (c == null) { 
				i++;
				continue; // already in the correct place
			}

			offset = keyToOffset.get(p.key);
			t = ps.get(offset);
			ps.set(offset, p);
			ps.set(i, t);

			if (c == 1) keyToCount.remove(p.key);
			else {
				keyToCount.put(p.key, c - 1);
				keyToOffset.put(p.key, offset + 1);
			}
		}
	}

	private static String randomString(int len) {
		StringBuilder ret = new StringBuilder();
		Random rnd = new Random();

		while (len-- > 0) {
			ret.append((char) (rnd.nextInt(26) + 97));
		}
		return ret.toString();
	}

	public static void main(String[] args) {
		Random rnd = new Random();
		for (int times = 0; times < 100; ++times) {
			int size = rnd.nextInt(100000) + 1;

			int k = rnd.nextInt(size) + 1;

			ArrayList<Person> people = new ArrayList<Person>();
			for (int i = 0; i < size; ++i) 
				people.add(new Person(rnd.nextInt(k), randomString(rnd.nextInt(10) + 1)));
			
			ArrayList<Person> clone = (ArrayList<Person>) people.clone();
			
			countingSort(clone);
			Collections.sort(people);

			for (int i = 1; i < people.size(); ++i) {
				//System.out.println(people.get(i).key + " " + clone.get(i).key);
				assert(people.get(i).key == clone.get(i).key);
			}
		}
		
		System.out.println("Done");
	}
}
