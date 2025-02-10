package xyz.funnyboy.a_datastructure.f_tree.b_arrbinarytree;

/**
 * @author VectorX
 * @version V1.0
 * @description
 * @date 2025-02-10 16:40:52
 */
public class ArrBinaryTreeDemo
{
	public static void main(String[] args) {
		//            1
		//        /        \
		//       2          3
		//     /   \      /   \
		//    4     5    6      7
		int[] arr = {1, 2, 3, 4, 5, 6, 7};
		ArrBinaryTree arrBinaryTree = new ArrBinaryTree(arr);
		arrBinaryTree.preOrderTraversal(); // 1,2,4,5,3,6,7
		arrBinaryTree.inOrderTraversal();  // 4,2,5,1,6,3,7
		arrBinaryTree.postOrderTraversal();// 4,5,2,6,7,3,1
	}
}
