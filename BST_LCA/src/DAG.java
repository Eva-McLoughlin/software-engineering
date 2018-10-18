
import java.util.Arrays;

public class DAG <Value> {
	private class Node {
		private Value val;	// This is the value stored in the node
		private Node[] successors;		
	
		public Node(Value val) {
			this.val = val;
		}
	}
	private Node[] nodeList = new DAG.Node[0];
	
	public boolean isEmpty() { //method to check if the DAG is empty
		if (size()==0) {
			return true;
		}
		else {
			return false;
		}
	}

	private int size() {
		// TODO Auto-generated method stub
		return nodeList.length;  //returns the number of nodes
	}
	
	// Method to check if node n is in the graph
		public boolean contains(Value v) {
			boolean valInList = false;
			for (int i=0; i<nodeList.length; i++) {
				if (nodeList[i].val == v) {
					valInList = true;
					break;
				}			
			}
			return valInList;
		}
		
		
		// Given a value will return the relevent node
		public Node retrieveNodefromVal (Value v){
			Node nodeToRet = new Node(null); 				
			for (int i=0; i<nodeList.length; i++){
				if (nodeList[i].val == v){
					nodeToRet = nodeList[i];
					break;			
				}	
			}
			return nodeToRet;
		}
		
		public void put(Value v, Value fromVal, Value toVal) {	
			Node n = new Node(v);
			Node from = retrieveNodefromVal(fromVal);
			Node to = retrieveNodefromVal(toVal);

			if (fromVal != null) {
				from.successors = extendArray(from.successors); //need a method to extend array
				from.successors[from.successors.length-1] = n;
				if (from.val == null) {
					addNodeToNodeList(from); 
				}
			}
			if (toVal != null) {
				n.successors = extendArray(n.successors);
				n.successors[n.successors.length-1] = to;
				if (to.val == null) {
					addNodeToNodeList(to);
				}
			}
			addNodeToNodeList(n);	
			
		}
		public void deleteNode(Node n) {
			int i;
			for(i=0; i<n.successors.length; i++) {
				n.successors[i] = null;
			}
			
			for(i=0; i<nodeList.length; i++) {
				if (Arrays.asList(nodeList[i].successors).contains(n) == true) {
					for (int j=0; j<nodeList[i].successors.length; j++) {
						if (nodeList[i].successors[j] == n) {
							nodeList[i].successors[j] = null;
						}
					}
				}
			}
			for (int k=0; k<nodeList.length; k++) {
				if (nodeList[k] == n) {
					nodeList[k] = null;
				}
			}		
		}
		
		public void addNodeToNodeList (Node n) {
			nodeList = extendArray(nodeList);
			nodeList[nodeList.length-1] = n;
		}
		// Extend the array by one element
			@SuppressWarnings("unchecked")
			public Node[] extendArray(Node[] originalArray) {
				Node[] copyArray = new DAG.Node[originalArray.length+1];
				System.arraycopy(originalArray, 0, copyArray, 0, originalArray.length);
				return copyArray;
			}


}