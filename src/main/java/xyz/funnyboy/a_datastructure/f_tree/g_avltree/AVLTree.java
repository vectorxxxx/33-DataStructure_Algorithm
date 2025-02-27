package xyz.funnyboy.a_datastructure.f_tree.g_avltree;

/**
 * @author VectorX
 * @version V1.0
 * @description 平衡二叉树
 * @date 2025-02-27 18:29:32
 */
public class AVLTree
{
	private Node root;

	public Node getRoot() {
		return root;
	}

	/**
	 * 查找要删除的结点
	 *
	 * @param value 值
	 * @return {@link Node }
	 */
	public Node search(int value) {
		if (root == null) {
			return null;
		}
		return root.search(value);
	}

	/**
	 * 查找父结点
	 *
	 * @param value 值
	 * @return {@link Node }
	 */
	public Node searchParent(int value) {
		if (root == null) {
			return null;
		}
		return root.searchParent(value);
	}

	/**
	 * 删除二叉排序树中最小结点的值
	 *
	 * @param root 根节点
	 * @return
	 */
	private int delRightTreeMin(Node root) {
		Node target = root;
		while (root.getLeft() != null) {
			target = root.getLeft();
		}
		delNode(target.getValue());
		return target.getValue();
	}

	/**
	 * 删除结点
	 *
	 * @param value 值
	 */
	public void delNode(int value) {
		// 如果根结点为空
		if (root == null) {
			return;
		}
		Node targetNode = search(value);
		// 如果没有找到要删除的结点
		if (targetNode == null) {
			return;
		}
		// 如果只有一个根结点
		if (root.getLeft() == null && root.getRight() == null) {
			root = null;
			return;
		}
		final Node parent = searchParent(value);
		// 如果要删除的结点是叶子结点
		if (targetNode.getLeft() == null && targetNode.getRight() == null) {
			// 如果要删除的结点是左叶子结点
			if (parent.getLeft() != null && parent
					.getLeft()
					.getValue() == value) {
				parent.setLeft(null);
			}
			// 如果要删除的结点是右叶子结点
			else {
				parent.setRight(null);
			}
		}
		// 如果要删除的结点有左右子树
		else if (targetNode.getLeft() != null && targetNode.getRight() != null) {
			final int minVal = delRightTreeMin(targetNode.getRight());
			targetNode.setValue(minVal);
		}
		// 如果要删除的结点只有左子树
		else if (targetNode.getLeft() != null) {
			// 如果要删除的结点是根结点
			if (parent == null) {
				root = targetNode.getLeft();
			}
			// 如果要删除的结点是其父结点的左子树
			else if (parent
					.getLeft()
					.getValue() == value) {
				parent.setLeft(targetNode.getLeft());
			}
			// 如果要删除的结点是其父结点的右子树
			else {
				parent.setRight(targetNode.getLeft());
			}
		}
		// 如果要删除的结点只有右子树
		else {
			// 如果要删除的结点是根结点
			if (parent == null) {
				root = targetNode.getRight();
			}
			// 如果要删除的结点是其父结点的左子树
			else if (parent
					.getLeft()
					.getValue() == value) {
				parent.setLeft(targetNode.getRight());
			}
			// 如果要删除的结点是其父结点的右子树
			else {
				parent.setRight(targetNode.getRight());
			}
		}
	}

	/**
	 * 添加结点
	 *
	 * @param node 结点
	 */
	public void add(Node node) {
		if (root == null) {
			root = node;
			return;
		}
		root.add(node);
	}

	/**
	 * 中序遍历
	 */
	public void infixOrder() {
		if (root == null) {
			System.out.println("二叉排序树为空，不能遍历");
			return;
		}
		root.infixOrder();
	}
}
