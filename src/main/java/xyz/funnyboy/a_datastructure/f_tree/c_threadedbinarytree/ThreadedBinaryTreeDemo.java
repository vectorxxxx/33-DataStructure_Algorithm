package xyz.funnyboy.a_datastructure.f_tree.c_threadedbinarytree;

/**
 * @author VectorX
 * @version V1.0
 * @description
 * @date 2025-02-10 17:40:20
 */
public class ThreadedBinaryTreeDemo
{
	public static void main(String[] args) {
		//         tom (1)
		//        /       \
		//      jack (3)   smith (6)
		//     /    \      /
		// mary (8) king (10) dim (14)
		HeroNode root = new HeroNode(1, "tom");
		HeroNode node2 = new HeroNode(3, "jack");
		HeroNode node3 = new HeroNode(6, "smith");
		HeroNode node4 = new HeroNode(8, "mary");
		HeroNode node5 = new HeroNode(10, "king");
		HeroNode node6 = new HeroNode(14, "dim");
		root.left(node2);
		root.right(node3);
		node2.left(node4);
		node2.right(node5);
		node3.left(node6);

		// 中序线索化
		ThreadedBinaryTree threadedBinaryTree = new ThreadedBinaryTree();
		threadedBinaryTree.setRoot(root);
		threadedBinaryTree.threadedNodes();

		System.out.println("10号结点的前驱结点是=" + node5.left()); //3
		System.out.println("10号结点的后继结点是=" + node5.right());//1

		System.out.println("使用线索化的方式遍历 线索化二叉树");
		threadedBinaryTree.threadedList(); // 8, 3, 10, 1, 14, 6
	}
}
