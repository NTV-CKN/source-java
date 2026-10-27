package li_thuyet_do_thi.ma_tran;

import li_thuyet_do_thi.Graph;

public class DirectGraph extends Graph {
	private int vertices;
	private int[][] matrixAdj;

	public DirectGraph(int vertices) {
		this.vertices = vertices;
		matrixAdj = new int[vertices][vertices];
	}

	public int getVertices() {
		return vertices;
	}

	public int[][] getMatrixAdj() {
		return matrixAdj;
	}

	@Override
	public void addVertice(int vertice) {
		if (this.matrixAdj.length < vertice) {
			int[][] matrix = new int[vertice][vertice];

			for (int i = 0; i < matrixAdj.length; i++) {
				for (int j = 0; j < matrixAdj[i].length; j++) {
					matrix[i][j] = matrixAdj[i][j];
				}
			}
			this.matrixAdj = matrix;
			this.vertices = vertice;
		}
	}

	@Override
	public void addEdge(int first, int last) {
		if (vertices > first && vertices > last && last >= 0 && first >= 0) {
			matrixAdj[first][last] += 1;
		}
	}

	@Override
	public void removeVertice(int vertice) {
		if (this.vertices > vertice && vertice >= 0) {
			for (int i = 0; i < matrixAdj.length; i++) {
				matrixAdj[i][vertice] = 0;
				matrixAdj[vertice][i] = 0;
			}
		}
	}

	@Override
	public void removeEdge(int first, int last) {
		if (vertices > first && vertices > last && last >= 0 && first >= 0) {
			matrixAdj[first][last] = 0;
		}
	}

	@Override
	public String printListEdge() {
		StringBuilder strB = new StringBuilder();

		for (int i = 0; i < matrixAdj.length; i++) {
			strB.append("Vertex: " + i + "\n");
			for (int j = 0; j < matrixAdj[i].length; j++) {
				if (matrixAdj[i][j] >= 1) {
					strB.append(i + " -------------> " + j + "\n");
				}
			}
		}
		return strB.toString();
	}

	@Override
	public boolean isLoop() {
		for (int i = 0; i < matrixAdj.length; i++) {
			if (matrixAdj[i][i] >= 1) {
				return true;
			}
		}
		return false;
	}

	@Override
	public boolean isMultiGraph() {
		for (int i = 0; i < matrixAdj.length; i++) {
			for (int j = 0; j < matrixAdj[i].length; j++) {
				if (matrixAdj[i][j] > 1) {
					return true;
				}
			}
		}
		return false;
	}

	@Override
	public boolean isSingleGraph() {
		return !isMultiGraph();
	}

	@Override
	public String numOfOutDegree() {
		StringBuilder strB = new StringBuilder();
		int counter = 0;

		for (int i = 0; i < matrixAdj.length; i++) {
			strB.append("Vertext " + i + ": ");
			for (int j = 0; j < matrixAdj[i].length; j++) {
				if (matrixAdj[i][j] >= 1) {
					counter += matrixAdj[i][j];
				}
			}
			strB.append(counter + " out degree\n");
			counter = 0;
		}
		return strB.toString();
	}

	@Override
	public String numOfInDegree() {
		StringBuilder strB = new StringBuilder();
		int counter = 0;

		for (int i = 0; i < matrixAdj.length; i++) {
			strB.append("Vertext " + i + ": ");
			for (int j = 0; j < matrixAdj[i].length; j++) {
				if (matrixAdj[j][i] >= 1) {
					counter += matrixAdj[j][i];
				}
			}
			strB.append(counter + " in degree\n");
			counter = 0;
		}
		return strB.toString();
	}

	@Override
	public String numOfDegree() {
		StringBuilder strB = new StringBuilder();
		int counter = 0;

		for (int i = 0; i < matrixAdj.length; i++) {
			strB.append("Vertext " + i + ": ");
			for (int j = 0; j < matrixAdj[i].length; j++) {
				if (i == j) {
					if (matrixAdj[i][j] >= 1) {
						counter += (matrixAdj[i][j]);
					}
				} else if (matrixAdj[i][j] >= 1 || matrixAdj[j][i] >= 1) {
					counter += (matrixAdj[i][j] + matrixAdj[j][i]);
					System.out.println("vertex: " + i + " " + (matrixAdj[i][j] + matrixAdj[j][i]) + " j " + j);
				}
			}
			strB.append(counter + " degree\n");
			counter = 0;
		}
		return strB.toString();
	}

	@Override
	public int numOfEdge() {
		int counter = 0;

		for (int i = 0; i < matrixAdj.length; i++) {
			for (int j = 0; j < matrixAdj[i].length; j++) {
				if (matrixAdj[i][j] >= 1) {
					counter += (matrixAdj[i][j]);
				}
			}
		}
		return counter;
	}

	@Override
	public boolean isCompleteGraph() {
		if (!isSingleGraph())
			return false;
		for (int i = 0; i < matrixAdj.length; i++) {
			for (int j = 0; j < matrixAdj[i].length; j++) {
				if (i != j && matrixAdj[i][j] == 0) {
					return false;
				}
			}
		}
		return true;
	}

	@Override
	public boolean isBipartiteGraph() {

		return false;
	}
}
