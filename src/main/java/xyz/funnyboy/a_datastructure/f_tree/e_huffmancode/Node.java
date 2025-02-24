package xyz.funnyboy.a_datastructure.f_tree.e_huffmancode;

/**
 * @author VectorX
 * @version V1.0
 * @description
 * @date 2025-02-20 19:11:25
 */
public class Node implements Comparable<Node>
{
	/**
	 * 数据：字符本身
	 */
	private Byte data;
	/**
	 * 权值：字符出现的频率/次数
	 */
	private int weight;
	private Node left;
	private Node right;

	public Node(Byte data, int weight) {
		this.data = data;
		this.weight = weight;
	}

	public Byte getData() {
		return data;
	}

	public void setData(Byte data) {
		this.data = data;
	}

	public int getWeight() {
		return weight;
	}

	public void setWeight(int weight) {
		this.weight = weight;
	}

	public Node getLeft() {
		return left;
	}

	public void setLeft(Node left) {
		this.left = left;
	}

	public Node getRight() {
		return right;
	}

	public void setRight(Node right) {
		this.right = right;
	}

	/**
	 * 前序遍历
	 */
	public void preOrder() {
		System.out.println(this);
		if (this.left != null) {
			this.left.preOrder();
		}
		if (this.right != null) {
			this.right.preOrder();
		}
	}

	@Override
	public int compareTo(Node o) {
		return this.weight - o.weight;
	}

	@Override
	public String toString() {
		return "Node{" + "data=" + data + ", weight=" + weight + '}';
	}
}
