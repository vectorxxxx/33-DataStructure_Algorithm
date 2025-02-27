package xyz.funnyboy.a_datastructure.f_tree.g_avltree;

/**
 * @author VectorX
 * @version V1.0
 * @description
 * @date 2025-02-27 19:46:42
 */
public class AVLTreeDemo
{
	public static void main(String[] args) {
		//         4
		//        / \
		//       3   6
		//          / \
		//         5   7
		//              \
		//               8
		// 左旋后
		//         6 
		//        / \
		//       4   7 
		//      / \   \
		//     3  5    8 
		// int[] arr = {4, 3, 6, 5, 7, 8};

		//         10
		//        /  \
		//       8    12
		//      / \
		//     7   9
		//    /
		//   6
		// 右旋后
		//         8 
		//        / \
		//       7   10 
		//      /   / \
		//     6   9   12 
		// int[] arr = {10, 12, 8, 9, 7, 6};

		//         10
		//        /  \
		//       7    11
		//      / \
		//     6   8
		//          \
		//           9
		// 左子树左旋
		//         10
		//        /  \
		//       8    11
		//      / \
		//     7   9
		//    /
		//   6
		// 整体右旋
		//         8
		//        / \
		//       7   10
		//      /   / \
		//     6   9   11
		int[] arr = {10, 11, 7, 6, 8, 9};

		// 创建一个 AVLTree对象
		AVLTree avlTree = new AVLTree();
		// 添加结点
		for (int j : arr) {
			avlTree.add(new Node(j));
		}

		//遍历
		System.out.println("中序遍历");
		avlTree.infixOrder();

		System.out.println("在平衡处理~~");
		System.out.println("树的高度=" + avlTree
				.getRoot()
				.getHeight()); //3
		System.out.println("树的左子树高度=" + avlTree
				.getRoot()
				.getLeftHeight()); // 2
		System.out.println("树的右子树高度=" + avlTree
				.getRoot()
				.getRightHeight()); // 2
		System.out.println("当前的根结点=" + avlTree.getRoot());//8

	}
}
