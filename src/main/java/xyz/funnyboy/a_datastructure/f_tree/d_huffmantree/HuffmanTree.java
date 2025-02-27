package xyz.funnyboy.a_datastructure.f_tree.d_huffmantree;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @author VectorX
 * @version V1.0
 * @description 赫夫曼树
 * @date 2025-02-17 15:21:46
 */
public class HuffmanTree
{
	public static Node createHuffmanTree(int[] arr) {
		final List<Node> nodes = new ArrayList<>();
		for (int value : arr) {
			nodes.add(new Node(value));
		}

		while (nodes.size() > 1) {
			// 从小到大排序，小顶堆
			Collections.sort(nodes);
			System.out.println("nodes=" + nodes);

			// 最小、次小
			final Node leftNode = nodes.get(0);
			final Node rightNode = nodes.get(1);

			// 创建父节点
			final Node parent = new Node(leftNode.getValue() + rightNode.getValue());
			parent.setLeft(leftNode);
			parent.setRight(rightNode);

			// 移除最小、次小
			nodes.remove(leftNode);
			nodes.remove(rightNode);
			// 将parent加入nodes
			nodes.add(parent);
		}
		return nodes.get(0);
	}
}
