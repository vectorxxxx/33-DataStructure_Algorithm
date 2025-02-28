package xyz.funnyboy.a_datastructure.g_graph;

/**
 * @author VectorX
 * @version V1.0
 * @description
 * @date 2025-02-28 15:10:38
 */
public class GraphDemo
{
	public static void main(String[] args) {
		int n = 8;
		String[] vertexs = {"A", "B", "C", "D", "E", "F", "G", "H"};

		// 创建图对象
		Graph graph = new Graph(n);
		// 循环添加顶点
		for (String vertex : vertexs) {
			graph.insertVertex(vertex);
		}

		// 更新边的关系
		//         A
		//       /   \
		//      B     C
		//     / \   / \
		//    D   E F———G
		//     \ /
		//      H
		graph.insertEdge(0, 1, 1);
		graph.insertEdge(0, 2, 1);
		graph.insertEdge(1, 3, 1);
		graph.insertEdge(1, 4, 1);
		graph.insertEdge(3, 7, 1);
		graph.insertEdge(4, 7, 1);
		graph.insertEdge(2, 5, 1);
		graph.insertEdge(2, 6, 1);
		graph.insertEdge(5, 6, 1);

		// 显示邻结矩阵
		graph.showGraph();

		// DFS、BFS
		System.out.print("深度遍历：");
		graph.dfs(); // A->B->D->H->E->C->F->G
		System.out.println();
		System.out.print("广度优先：");
		graph.bfs(); // A->B->C->D->E->F->G->H
		System.out.println();
	}
}
