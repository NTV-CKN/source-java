package li_thuyet_do_thi.ma_tran;

import li_thuyet_do_thi.Graph;

public class Test {
	public static void main(String[] args) {
		Graph g1 = new DirectGraph(5);
		Graph g2 = new UndirectGraph(5);
		
		g1.addEdge(0, 1);//a to b
		g1.addEdge(2, 1);//c to b
		g1.addEdge(2, 2);//c to c
		g1.addEdge(2, 3);//c to d
		g1.addEdge(3, 2);//d to c
		g1.addEdge(4, 3);//e to d
		g1.addEdge(4, 4);//e to e
		g1.addEdge(4, 0);//e to a
		g1.addEdge(1, 4);//b to e
		
		g2.addEdge(0, 1);//a vs b
		g2.addEdge(1, 1);//b vs b
		g2.addEdge(1, 2);//b vs c
		g2.addEdge(1, 3);//b vs d
		g2.addEdge(3, 0);//a vs d
		g2.addEdge(1, 4);//b vs e
		g2.addEdge(3, 4);//d vs e	
		g2.addEdge(3, 4);//d vs e
		g2.addEdge(3, 4);//d vs e
		g2.addEdge(0, 4);//a vs e
		g2.addEdge(0, 4);//a vs e
		
		System.out.println("List=========================");
		System.out.println(g1.printListEdge());
		System.out.println("num of in degree=========================");
		System.out.println(g1.numOfInDegree());
		System.out.println("num of out degree=========================");
		System.out.println(g1.numOfOutDegree());
		System.out.println("num degree=========================");
		System.out.println(g1.numOfDegree());
		System.out.println("loop=========================");
		System.out.println(g1.isLoop());
		System.out.println("single=========================");
		System.out.println(g1.isSingleGraph());
		System.out.println("complete=========================");
		System.out.println(g1.isCompleteGraph());
		
		System.out.println("+=++++++++++++++++++++++++++++++++++=+");
		
		System.out.println("List=========================");
		System.out.println(g2.printListEdge());
		System.out.println("num of in degree=========================");
		System.out.println(g2.numOfInDegree());
		System.out.println("num of out degree=========================");
		System.out.println(g2.numOfOutDegree());
		System.out.println("num degree=========================");
		System.out.println(g2.numOfDegree());
		System.out.println("loop=========================");
		System.out.println(g2.isLoop());
		System.out.println("single=========================");
		System.out.println(g2.isSingleGraph());
		System.out.println("complete=========================");
		System.out.println(g2.isCompleteGraph());
	}
}
