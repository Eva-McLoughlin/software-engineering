import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;

public class DAG {
	private int V;           
	private int E;              
	private ArrayList<Integer>[] adj;    
	private int[] indegree;        
	private boolean marked[];		//tracks visited vertices
	private boolean hasCycle;		//Will be true if there is a cycle in graph
    private boolean stack[];		//The order in which vertices were visited
    private int[] edgeTo;      // last edge on shortest s->v path
    private int[] distTo;      // length of shortest s->v path

    
	public DAG(int V)
	{
		if (V < 0) throw new IllegalArgumentException("Number of vertices in a Digraph must be nonnegative");
	    this.V = V;
	    this.E = 0;
	    indegree = new int[V];
	    marked = new boolean[V];
	    stack = new boolean[V];
	    adj = (ArrayList<Integer>[]) new ArrayList[V];
	    for (int v = 0; v < V; v++) {
	        adj[v] = new ArrayList<Integer>();
	    }              
	}

	//Returns current vertex
	public int V() {
		return V;	
	}
	
	public int E() {
        return E;
    }

	
	
	//Adds a directed edge from v->w
	public void addEdge(int v, int w)
	{
	    if((validateVertex(v)>0)&&(validateVertex(w)>0))
	    {
	    	adj[v].add(w);
	    	indegree[w]++;
	    	E++;
	    }
	    else{
	    	System.out.println("Please enter vertices between 0 & n-1");
	    }
	    	
	}
	
	private int validateVertex(int v) {
        if (v < 0 || v >= V)
        	return -1;
        else
        	return 1;}

	
	//Returns amount of directed edges incident to vertex v
	public int indegree(int v) {
		if(validateVertex(v)<0){
			return -1;
		}
		else{
			return indegree[v];
		}
	}
	
	//Returns amount of directed edges from vertex v
	public int outdegree(int v) {
		if(validateVertex(v)<0){
			return -1;
		}
		else{
			return adj[v].size();
		}
    }
		
	
	//Returns the adjacent vertices to v
	public Iterable<Integer> adj(int v)
	{ return adj[v]; }
	
	
	
	public boolean hasCycle() {

        return hasCycle;
    }
	
	 public void findCycle(int v) {

	        marked[v] = true;
	        stack[v] = true;

	        for (int w : adj(v)) {
	            if(!marked[w]) {
	                findCycle(w);
	            } else if (stack[w]) {
	                hasCycle = true;
	                return;
	            }
	        }

	        stack[v] = false;
	    }
}