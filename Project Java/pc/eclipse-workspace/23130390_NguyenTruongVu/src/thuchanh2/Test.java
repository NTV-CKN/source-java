package thuchanh2;

public class Test {
	public static void main(String arg[]) {
		Queen q=new Queen(4);
		System.out.println("bfs n=4=======================");
		q.bfs();
		System.out.println("dfs n=4=======================");
		q.dfs();
		
		q.setN(8);
		
		System.out.println("bfs n=8=======================");
		q.bfs();
		System.out.println("dfs n=8=======================");
		q.dfs();
	}
}
