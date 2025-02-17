package xyz.funnyboy.a_datastructure.f_tree.d_huffmantree;

/**
 * @author VectorX
 * @version V1.0
 * @description
 * @date 2025-02-17 15:39:46
 */
public class HuffmanTreeDemo
{
	public static void main(String[] args) {
		//     [67]
		//    /    \
		//   29    [38]
		//        /    \
		//      [15]   [23]
		//      /  \   /  \
		//     7   8  [10] 13
		//            /   \
		//          [4]    6
		//         /   \
		//        1     3
		int[] arr = {13, 7, 8, 3, 29, 6, 1};  // {1, 3, 6, 7, 8, 13, 29}
		Node root = HuffmanTree.createHuffmanTree(arr);
		System.out.println("============================");
		root.preOrder();
	}
}
