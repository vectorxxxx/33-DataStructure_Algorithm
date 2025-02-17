package xyz.funnyboy.a_datastructure.f_tree.d_huffmantree;

/**
 * @author VectorX
 * @version V1.0
 * @description
 * @date 2025-02-17 15:22:33
 */
public class Node implements Comparable<Node>
{
	/**
	 * 结点权值
	 */
	private final int value;
	/**
	 * 字符
	 */
	private char c;
	/**
	 * 左子结点
	 */
	private Node left;
	/**
	 * 右子结点
	 */
	private Node right;

	public Node(int value) {
		this.value = value;
	}

	public void preOrder() {
		System.out.println(this);
		if (this.left != null) {
			this.left.preOrder();
		}
		if (this.right != null) {
			this.right.preOrder();
		}
	}

	public int getValue() {
		return value;
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

	@Override
	public String toString() {
		return "Node{" + "value=" + value + '}';
	}

	@Override
	public int compareTo(Node o) {
		return this.value - o.value;
	}
}
