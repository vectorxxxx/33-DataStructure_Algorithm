package xyz.funnyboy.a_datastructure.f_tree.c_threadedbinarytree;

/**
 * @author VectorX
 * @version V1.0
 * @description 二叉树
 * @date 2025-02-10 16:17:42
 */
public class ThreadedBinaryTree
{
	private HeroNode root;

	/**
	 * 辅助线索化的前驱节点指针
	 */
	private HeroNode pre;

	public void setRoot(HeroNode root) {
		this.root = root;
	}

	/**
	 * 线索化二叉树
	 */
	public void threadedNodes() {
		this.threadedNodes(root);
	}

	/**
	 * 中序线索化节点
	 *
	 * @param node 节点
	 */
	private void threadedNodes(HeroNode node) {
		if (node == null) {
			return;
		}

		// 线索化左子树
		threadedNodes(node.left());

		// 前驱结点
		if (node.left() == null) {
			node.left(pre);
			node.setLeftType(1);
		}
		// 后继结点
		if (pre != null && pre.right() == null) {
			pre.right(node);
			pre.setRightType(1);
		}
		pre = node;

		// 线索化右子树
		threadedNodes(node.right());
	}

	/**
	 * 遍历线索化二叉树
	 */
	public void threadedList() {
		HeroNode node = root;
		while (node != null) {
			while (node.getLeftType() == 0) {
				node = node.left();
			}
			System.out.println(node);
			while (node.getRightType() == 1) {
				node = node.right();
				System.out.println(node);
			}
			node = node.right();
		}
	}

	public void delNode(int no) {
		if (root == null) {
			System.out.println("空树，不能删除~");
			return;
		}

		if (root.getNo() == no) {
			root = null;
			return;
		}

		root.delNode(no);
	}

	/**
	 * 前序遍历（DLR）
	 */
	public void preOrderTraversal() {
		if (root == null) {
			System.out.println("空树，无法遍历");
			return;
		}
		root.preOrderTraversal();
	}

	/**
	 * 中序遍历（LDR）
	 */
	public void inOrderTraversal() {
		if (root == null) {
			System.out.println("空树，无法遍历");
			return;
		}
		root.inOrderTraversal();
	}

	/**
	 * 后序遍历（LRD）
	 */
	public void postOrderTraversal() {
		if (root == null) {
			System.out.println("空树，无法遍历");
			return;
		}
		root.postOrderTraversal();
	}

	/**
	 * 前序查找
	 *
	 * @param no no
	 * @return {@link HeroNode }
	 */
	public HeroNode preOrderSearch(int no) {
		if (root == null) {
			return null;
		}
		return root.preOrderSearch(no);
	}

	/**
	 * 中序查找
	 *
	 * @param no no
	 * @return {@link HeroNode }
	 */
	public HeroNode inOrderSearch(int no) {
		if (root == null) {
			return null;
		}
		return root.inOrderSearch(no);
	}

	/**
	 * 后序查找
	 *
	 * @param no no
	 * @return {@link HeroNode }
	 */
	public HeroNode postOrderSearch(int no) {
		if (root == null) {
			return null;
		}
		return root.postOrderSearch(no);
	}
}
