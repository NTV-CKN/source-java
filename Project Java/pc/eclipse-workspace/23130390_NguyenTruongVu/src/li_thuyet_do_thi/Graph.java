package li_thuyet_do_thi;

public abstract class Graph {
	
	//add
	public abstract void addVertice(int vertice);
	public abstract void addEdge(int first, int last);
	
	//remove
	public abstract void removeVertice(int vertice);
	public abstract void removeEdge(int first, int last);
	
	//print
	public abstract String printListEdge();
	
	//check graph is a loop
	public abstract boolean isLoop();
	
	//check multigraph, singlegraph
	public abstract boolean isMultiGraph();
	public abstract boolean isSingleGraph();
	
	//calculate number of out/in degree
	public abstract String numOfOutDegree();
	public abstract String numOfInDegree();
	
	//calculate number of degree
	public abstract String numOfDegree();
	
	//calculate number of edge
	public abstract int numOfEdge();
	
	//check complete graph, bipartite graph
	public abstract boolean isCompleteGraph();
	public abstract boolean isBipartiteGraph();
}
