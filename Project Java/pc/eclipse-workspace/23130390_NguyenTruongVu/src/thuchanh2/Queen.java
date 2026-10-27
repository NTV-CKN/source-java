package thuchanh2;

public class Queen {
	private int n;
	@SuppressWarnings("unused")
	private Node goal;
	public Queen (int n) {
		this.n=n;
	}
	public void dfs(){
		DFS dfs = new DFS();
		dfs.dfsRec(new Node(n), n);
	}
	public void bfs(){
		BFS bfs=new BFS();
		bfs.bfsUsingQueue(new Node(n), n);
	}
	
	public void setN(int n) {
		if(n >= 4 && n<= 8) {
			this.n = n;
		}else {
			System.err.println("ERROR");
		}
	}
}
