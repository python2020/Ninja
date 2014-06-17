package com.python2020.hashing;

import java.util.HashMap;
import java.util.Map;

public class LRUCache {
	int capacity;
	int size;
	Map<Integer, Node> map;
	Node head;

	public class Node {
		int key;
		int value;
		Node prev = null;
		Node next = null;

		public Node(int k, int v) {
			key = k;
			value = v;    
		}
	}

	public LRUCache(int capacity) {
		this.capacity = capacity;
		size = 0;
		head = new Node(0, 0);     
		head.prev = head;
		head.next = head;
		map = new HashMap<Integer, Node>();   
	}

	public void insertInFront(Node n) {
		n.next = head.next;
		n.prev = head;

		head.next.prev = n;
		head.next = n;
	}

	public void detach(Node n) {
		n.next.prev = n.prev;
		n.prev.next = n.next;

		n.next = null;
		n.prev = null;

	}

	public int get(int key) {
		Node n = map.get(key);
		if (n != null) {
			detach(n);
			insertInFront(n); 
			return n.value;
		} else {
			return - 1;
		} 
	}

	public void set(int key, int value) {
		Node n = map.get(key);
		if (n != null) { 
			n.value = value;
			detach(n); 
			insertInFront(n);
		} else {
			if (capacity == 0) return; // !

			if (size == capacity) {
				map.remove(head.prev.key);
				detach(head.prev);
			} else {
				size++;
			}
			n = new Node(key, value);
			map.put(key, n);
			insertInFront(n); 
		}    
	}

}
