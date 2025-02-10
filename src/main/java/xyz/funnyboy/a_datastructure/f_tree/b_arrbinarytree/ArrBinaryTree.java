package xyz.funnyboy.a_datastructure.f_tree.b_arrbinarytree;

/**
 * @author VectorX
 * @version V1.0
 * @description 顺序存储二叉树
 * @date 2025-02-10 16:34:58
 */
public class ArrBinaryTree
{
	private final int[] arr;

	public ArrBinaryTree(int[] arr) {
		this.arr = arr;
	}

	/**
	 * 前序遍历
	 */
	public void preOrderTraversal() {
		this.preOrderTraversal(0);
		System.out.println();
	}

	private void preOrderTraversal(int index) {
		if (arr == null || arr.length == 0) {
			System.out.println("数组为空，无法遍历");
			return;
		}

		System.out.print(arr[index] + ",");
		if (index * 2 + 1 < arr.length) {
			preOrderTraversal(index * 2 + 1);
		}
		if (index * 2 + 2 < arr.length) {
			preOrderTraversal(index * 2 + 2);
		}
	}

	/**
	 * 中序遍历
	 */
	public void inOrderTraversal() {
		this.inOrderTraversal(0);
		System.out.println();
	}

	private void inOrderTraversal(int index) {
		if (arr == null || arr.length == 0) {
			System.out.println("数组为空，无法遍历");
			return;
		}

		if (index * 2 + 1 < arr.length) {
			inOrderTraversal(index * 2 + 1);
		}
		System.out.print(arr[index] + ",");
		if (index * 2 + 2 < arr.length) {
			inOrderTraversal(index * 2 + 2);
		}
	}

	/**
	 * 后序遍历
	 */
	public void postOrderTraversal() {
		this.postOrderTraversal(0);
		System.out.println();
	}

	private void postOrderTraversal(int index) {
		if (arr == null || arr.length == 0) {
			System.out.println("数组为空，无法遍历");
			return;
		}

		if (index * 2 + 1 < arr.length) {
			postOrderTraversal(index * 2 + 1);
		}
		if (index * 2 + 2 < arr.length) {
			postOrderTraversal(index * 2 + 2);
		}
		System.out.print(arr[index] + ",");
	}
}
