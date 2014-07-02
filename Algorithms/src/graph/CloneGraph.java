package graph;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;


public class CloneGraph {
    public UndirectedGraphNode cloneGraph(UndirectedGraphNode node) {
    	// BFS
    	return cloneGraphBFS(node);
    }
    
    public UndirectedGraphNode cloneGraphBFS(UndirectedGraphNode node) {
    	HashMap<UndirectedGraphNode, UndirectedGraphNode> orgToCopy = new HashMap<UndirectedGraphNode, UndirectedGraphNode>();
    	Queue<UndirectedGraphNode> queue = new LinkedList<UndirectedGraphNode>(); 
    	if (node == null) return null;
    	
    	// Initialization
    	UndirectedGraphNode curNode = node, curNodeCopy = null, neighborCopy = null;
    	curNodeCopy = new UndirectedGraphNode(node.label);
		orgToCopy.put(curNode, curNodeCopy);
    	queue.add(curNode);

    	while (!queue.isEmpty()) {		
    		curNode = queue.remove();
    		curNodeCopy = orgToCopy.get(curNode);    		
    		
    		for (UndirectedGraphNode neighbor : curNode.neighbors) {   			
    			if (orgToCopy.containsKey(neighbor)) { 
    				neighborCopy = orgToCopy.get(neighbor);
    			} else {
    				neighborCopy = new UndirectedGraphNode(neighbor.label); 
    				orgToCopy.put(neighbor, neighborCopy);
    				queue.add(neighbor);
    			}
    			curNodeCopy.neighbors.add(neighborCopy);
    		}
    	}
    	
    	return orgToCopy.get(node);
    }
    
    // DFS
    public UndirectedGraphNode cloneGraphDFS(UndirectedGraphNode node) {
        if (node == null) return null;
        HashMap<UndirectedGraphNode, UndirectedGraphNode> orgToCopy = new HashMap<UndirectedGraphNode, UndirectedGraphNode>();        
        cloneGraphDFSHelper(node, orgToCopy);
        return orgToCopy.get(node);        
     }    

	public void cloneGraphDFSHelper(UndirectedGraphNode node, HashMap<UndirectedGraphNode, UndirectedGraphNode> orgToCopy) {
		UndirectedGraphNode nodeCopy = new UndirectedGraphNode(node.label), neighborCopy = null;
		orgToCopy.put(node, nodeCopy);
		
		for (UndirectedGraphNode neighbor : node.neighbors) {
			if (!orgToCopy.containsKey(neighbor)) 
				cloneGraphDFSHelper(neighbor, orgToCopy);
			neighborCopy = orgToCopy.get(neighbor);
			nodeCopy.neighbors.add(neighborCopy);
		}
	}    
    
    public static void main(String[] args) {
    	CloneGraph x = new CloneGraph();
    	UndirectedGraphNode node = new UndirectedGraphNode(0);
    	node.neighbors.add(new UndirectedGraphNode(2));
    	node.neighbors.add(new UndirectedGraphNode(3));
    	
    	node = x.cloneGraph(node);
    	System.out.println(node.label);
		for (UndirectedGraphNode neighbor : node.neighbors) {
			System.out.println(neighbor.label);
		}
    }
    
}
