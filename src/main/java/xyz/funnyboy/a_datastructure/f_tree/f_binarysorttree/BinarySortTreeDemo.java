package xyz.funnyboy.a_datastructure.f_tree.f_binarysorttree;

/**
 * @author VectorX
 * @version V1.0
 * @description
 * @date 2025-02-27 16:50:07
 */
public class BinarySortTreeDemo
{
	public static void main(String[] args) {
		int[] arr = {7, 3, 10, 12, 5, 1, 9};
		BinarySortTree binarySortTree = new BinarySortTree();
		// 添加节点至二叉排序树
		for (int i : arr) {
			binarySortTree.add(new Node(i));
		}
		//       7
		//     /   \
		//    3     10
		//   / \   / \
		//  1   5 9   12
		System.out.println("二叉排序树的中序遍历：");
		binarySortTree.infixOrder();

		//       7
		//     /   \
		//    3     10
		//   / \   /
		//  1   5 9
		binarySortTree.delNode(12);
		//       7
		//     /   \
		//    3     10
		//   /     /
		//  1     9
		binarySortTree.delNode(5);
		//       7
		//     /   \
		//    3     9
		//   /
		//  1
		binarySortTree.delNode(10);
		//       7
		//     /   \
		//    3     9
		//   /
		//  1
		binarySortTree.delNode(2);
		//       7
		//     /   \
		//    1     9
		binarySortTree.delNode(3);
		//       7
		//     /
		//    1
		binarySortTree.delNode(9);
		//       7
		binarySortTree.delNode(1);
		//
		binarySortTree.delNode(7);

		System.out.println("root=" + binarySortTree.getRoot());
		System.out.println("删除结点后");
		binarySortTree.infixOrder();
	}
}
