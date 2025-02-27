package xyz.funnyboy.a_datastructure.f_tree.f_binarysorttree;

/**
 * @author VectorX
 * @version V1.0
 * @description
 * @date 2025-02-24 16:10:38
 */
public class Node
{
	private int value;
	private Node left;
	private Node right;

	public Node(int value) {
		this.value = value;
	}

	/**
	 * 查找
	 *
	 * @param value 值
	 * @return {@link Node }
	 */
	public Node search(int value) {
		if (this.value == value) {
			return this;
		}
		else if (value < this.value) {
			if (this.left == null) {
				return null;
			}
			return this.left.search(value);
		}
		else {
			if (this.right == null) {
				return null;
			}
			return this.right.search(value);
		}
	}

	/**
	 * 查找要删除结点的父结点
	 *
	 * @param value 价值
	 * @return {@link Node }
	 */
	public Node searchParent(int value) {
		if ((this.left != null && this.left.value == value) || (this.right != null && this.right.value == value)) {
			return this;
		}
		else if (value < this.value && this.left != null) {
			return this.left.searchParent(value);
		}
		else if (value >= this.value && this.right != null) {
			return this.right.searchParent(value);
		}
		else {
			return null;
		}
	}

	public void add(Node node) {
		if (node == null) {
			return;
		}

		if (node.value < this.value) {
			if (this.left == null) {
				this.left = node;
			}
			else {
				this.left.add(node);
			}
		}
		else {
			if (this.right == null) {
				this.right = node;
			}
			else {
				this.right.add(node);
			}
		}
	}

	/**
	 * 中序遍历
	 */
	public void infixOrder() {
		if (this.left != null) {
			this.left.infixOrder();
		}
		System.out.println(this);
		if (this.right != null) {
			this.right.infixOrder();
		}
	}

	public int getValue() {
		return value;
	}

	public void setValue(int value) {
		this.value = value;
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
}
