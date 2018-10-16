
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
}