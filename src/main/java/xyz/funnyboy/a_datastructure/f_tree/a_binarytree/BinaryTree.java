package xyz.funnyboy.a_datastructure.f_tree.a_binarytree;

/**
 * @author VectorX
 * @version V1.0
 * @description
 * @date 2025-02-10 16:17:42
 */
public class BinaryTree
{
	private HeroNode root;

	public void setRoot(HeroNode root) {
		this.root = root;
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
