package xyz.funnyboy.a_datastructure.f_tree.g_avltree;

/**
 * @author VectorX
 * @version V1.0
 * @description
 * @date 2025-02-27 18:30:14
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
	 * 获取左子树高度
	 *
	 * @return int
	 */
	public int getLeftHeight() {
		if (left == null) {
			return 0;
		}
		return left.getHeight();
	}

	/**
	 * 获取右子树高度
	 *
	 * @return int
	 */
	public int getRightHeight() {
		if (right == null) {
			return 0;
		}
		return right.getHeight();
	}

	/**
	 * 获取高度
	 *
	 * @return int
	 */
	public int getHeight() {
		final int leftHeight = left == null ?
		                       0 :
		                       left.getHeight();
		final int rightHeight = right == null ?
		                        0 :
		                        right.getHeight();
		return Math.max(leftHeight, rightHeight) + 1;
	}

	/**
	 * 左旋转
	 */
	private void leftRotate() {
		// 左旋转前结构：
		//    [当前积木]
		//   /         \
		// A积木    [右子积木]
		//           /      \
		//       B积木      C积木
		//
		// 左旋转后结构：
		//       [右子积木的值]
		//      /            \
		//  [新积木]         C积木
		//   /     \
		// A积木  B积木
		final Node newNode = new Node(value);
		newNode.left = left;
		newNode.right = right.left;
		value = right.value;
		right = right.right;
		left = newNode;
	}

	/**
	 * 右旋转
	 */
	private void rightRotate() {
		// 右旋转前结构：
		//         [当前积木]
		//        /          \
		//   [左子积木]      C积木
		//    /     \
		// A积木   B积木
		//
		// 右旋转后结构：
		//         [左子积木的值]
		//        /            \
		//    A积木           [新积木]
		//                  /        \
		//              B积木         C积木
		final Node newNode = new Node(value);
		newNode.right = right;
		newNode.left = left.right;
		value = left.value;
		left = left.left;
		right = newNode;
	}

	/**
	 * 添加结点的方法
	 * <p>
	 * 递归的形式添加结点，注意需要满足二叉排序树的要求
	 *
	 * @param node 节点
	 */
	public void add(Node node) {
		if (node == null) {
			return;
		}

		// 判断传入的结点的值，和当前子树的根结点的值关系
		if (node.value < this.value) {
			// 如果当前结点左子结点为null
			if (this.left == null) {
				this.left = node;
			}
			else {
				// 递归的向左子树添加
				this.left.add(node);
			}
		}
		// 添加的结点的值大于当前结点的值
		else {
			if (this.right == null) {
				this.right = node;
			}
			else {
				// 递归的向右子树添加
				this.right.add(node);
			}
		}

		// 当添加完一个结点后，如果: (右子树的高度-左子树的高度) > 1 , 左旋转
		if (this.getRightHeight() - this.getLeftHeight() > 1) {
			if (right != null && right.getLeftHeight() > getRightHeight()) {
				right.rightRotate();
			}
			leftRotate();
			return;
		}
		// 当添加完一个结点后，如果: (左子树的高度-右子树的高度) > 1 , 右旋转
		if (this.getLeftHeight() - this.getRightHeight() > 1) {
			if (left != null && left.getRightHeight() > left.getLeftHeight()) {
				left.leftRotate();
			}
			rightRotate();
		}
	}

	/**
	 * 查找要删除的结点
	 *
	 * @param value 希望删除的结点的值
	 * @return 如果找到返回该结点，否则返回null
	 */
	public Node search(int value) {
		// 找到就是该结点
		if (value == this.value) {
			return this;
		}
		// 如果查找的值小于当前结点，向左子树递归查找
		else if (value < this.value) {
			// 如果左子结点为空
			if (this.left == null) {
				return null;
			}
			return this.left.search(value);
		}
		// 如果查找的值不小于当前结点，向右子树递归查找
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
	 * @param value 要找到的结点的值
	 * @return 返回的是要删除的结点的父结点，如果没有就返回null
	 */
	public Node searchParent(int value) {
		// 如果当前结点就是要删除的结点的父结点，就返回
		if ((this.left != null && this.left.value == value) || (this.right != null && this.right.value == value)) {
			return this;
		}
		else {
			// 如果查找的值小于当前结点的值, 并且当前结点的左子结点不为空
			if (value < this.value && this.left != null) {
				// 向左子树递归查找
				return this.left.searchParent(value);
			}
			else if (value >= this.value && this.right != null) {
				// 向右子树递归查找
				return this.right.searchParent(value);
			}
			else {
				return null; // 没有找到父结点
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
