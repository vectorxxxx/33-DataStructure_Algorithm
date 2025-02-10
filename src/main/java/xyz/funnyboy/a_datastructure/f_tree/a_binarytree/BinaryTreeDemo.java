package xyz.funnyboy.a_datastructure.f_tree.a_binarytree;

/**
 * @author VectorX
 * @version V1.0
 * @description
 * @date 2025-02-10 16:21:38
 */
public class BinaryTreeDemo
{
	public static void main(String[] args) {
		final BinaryTree binaryTree = new BinaryTree();

		//          宋江 (1)
		//        /        \
		//    吴用 (2)   卢俊义 (3)
		//                /      \
		//          关胜 (5)   林冲 (4)
		HeroNode root = new HeroNode(1, "宋江");
		HeroNode node2 = new HeroNode(2, "吴用");
		HeroNode node3 = new HeroNode(3, "卢俊义");
		HeroNode node4 = new HeroNode(4, "林冲");
		HeroNode node5 = new HeroNode(5, "关胜");
		root.left(node2);
		root.right(node3);
		node3.right(node4);
		node3.left(node5);
		binaryTree.setRoot(root);

		System.out.println("删除前");
		System.out.println("=======前序遍历=======");
		binaryTree.preOrderTraversal(); // 1,2,3,5,4
		System.out.println("=======中序遍历=======");
		binaryTree.inOrderTraversal();  // 2,1,5,3,4
		System.out.println("=======后序遍历=======");
		binaryTree.postOrderTraversal();// 2,5,4,3,1
		binaryTree.delNode(5);
		System.out.println("删除后");
		System.out.println("=======前序遍历=======");
		binaryTree.preOrderTraversal(); // 1,2,3,4
		System.out.println("=======中序遍历=======");
		binaryTree.inOrderTraversal();  // 2,1,3,4
		System.out.println("=======后序遍历=======");
		binaryTree.postOrderTraversal();// 2,4,3,1
	}
}
