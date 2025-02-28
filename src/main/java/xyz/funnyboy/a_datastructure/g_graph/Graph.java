package xyz.funnyboy.a_datastructure.g_graph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.stream.Collectors;

/**
 * @author VectorX
 * @version V1.0
 * @description 图的深度优先遍历、广度优先遍历
 * @date 2025-02-28 10:54:26
 */
public class Graph
{
	/**
	 * 顶点列表
	 */
	private ArrayList<String> vertexList;
	/**
	 * 边数目
	 */
	private int numsOfEdges;
	/**
	 * 邻接矩阵
	 */
	private int[][] edges;
	/**
	 * 访问记录
	 */
	private boolean[] isVisited;

	public Graph(int n) {
		vertexList = new ArrayList<>(n);
		numsOfEdges = 0;
		edges = new int[n][n];
	}

	/**
	 * 得到第一个邻接结点的下标
	 *
	 * @param index 指数
	 * @return int
	 */
	private int getFirstNeighbor(int index) {
		for (int i = 0; i < vertexList.size(); i++) {
			if (edges[index][i] > 0) {
				return i;
			}
		}
		return -1;
	}

	/**
	 * 根据前一个邻接结点的下标来获取下一个邻接结点
	 *
	 * @param v1 v1
	 * @param v2 v2
	 * @return int
	 */
	private int getNextNeighbor(int v1, int v2) {
		for (int i = v2 + 1; i < vertexList.size(); i++) {
			if (edges[v1][i] > 0) {
				return i;
			}
		}
		return -1;
	}

	/**
	 * 深度优先遍历
	 *
	 * @param isVisited 访问状态
	 * @param i         索引
	 */
	private void dfs(boolean[] isVisited, int i) {
		System.out.print(getValueByIndex(i) + "->");
		isVisited[i] = true;
		int w = getFirstNeighbor(i);
		while (w != -1) {
			if (!isVisited[w]) {
				dfs(isVisited, w);
			}
			w = getNextNeighbor(i, w);
		}
	}

	/**
	 * 深度优先遍历 Depth-first traversal
	 */
	public void dfs() {
		final int size = getNumOfVertex();
		isVisited = new boolean[size];
		for (int i = 0; i < size; i++) {
			if (!isVisited[i]) {
				dfs(isVisited, i);
			}
		}
	}

	/**
	 * 广度优先遍历 Breadth-first traversal
	 *
	 * @param isVisited 访问状态
	 * @param i         索引
	 */
	private void bfs(boolean[] isVisited, int i) {
		final LinkedList<Integer> queue = new LinkedList<>();

		// 访问结点并标记
		System.out.print(getValueByIndex(i) + "->");
		isVisited[i] = true;
		queue.addLast(i);

		while (!queue.isEmpty()) {
			int u = queue.removeFirst();
			int w = getFirstNeighbor(u);
			while (w != -1) {
				// 没有访问过时，进行结点访问并标记
				if (!isVisited[w]) {
					System.out.print(getValueByIndex(w) + "->");
					isVisited[w] = true;
					queue.addLast(w);
				}
				// 获取下一个邻接结点
				w = getNextNeighbor(u, w);
			}
		}
	}

	/**
	 * 广度优先遍历 Breadth-first traversal
	 */
	public void bfs() {
		isVisited = new boolean[vertexList.size()];
		for (int i = 0; i < getNumOfVertex(); i++) {
			if (!isVisited[i]) {
				bfs(isVisited, i);
			}
		}
	}

	/**
	 * 返回结点的个数
	 *
	 * @return int
	 */
	public int getNumOfVertex() {
		return vertexList.size();
	}

	/**
	 * 得到边个数
	 *
	 * @return int
	 */
	public int getNumsOfEdges() {
		return numsOfEdges;
	}

	/**
	 * 显示图对应的矩阵
	 */
	public void showGraph() {
		System.out.println(vertexList
				.stream()
				.collect(Collectors.joining("  ", "   ", " ")));
		for (int i = 0; i < edges.length; i++) {
			System.out.print(getValueByIndex(i) + " ");
			System.out.println(Arrays.toString(edges[i]));
		}
	}

	/**
	 * 按索引获取结点
	 * <p>
	 * 0->"A" 1->"B" 2->"C"
	 *
	 * @param i 索引
	 * @return {@link String }
	 */
	public String getValueByIndex(int i) {
		return vertexList.get(i);
	}

	/**
	 * 返回邻接矩阵中v1结点和v2结点的权值
	 *
	 * @param v1 v1
	 * @param v2 v2
	 * @return int
	 */
	public int getWeight(int v1, int v2) {
		return edges[v1][v2];
	}

	/**
	 * 插入结点
	 *
	 * @param vertex 结点
	 */
	public void insertVertex(String vertex) {
		vertexList.add(vertex);
	}

	/**
	 * 添加边
	 *
	 * @param v1     v1
	 * @param v2     v2
	 * @param weight 权值
	 */
	public void insertEdge(int v1, int v2, int weight) {
		edges[v1][v2] = weight;
		edges[v2][v1] = weight;
		numsOfEdges++;
	}
}
