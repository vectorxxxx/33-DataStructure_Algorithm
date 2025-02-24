package xyz.funnyboy.a_datastructure.f_tree.e_huffmancode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author VectorX
 * @version V1.0
 * @description
 * @date 2025-02-21 11:25:32
 */
public class HuffmanCode
{
	/**
	 * 解码
	 *
	 * @param huffmanCodes 霍夫曼编码表
	 * @param huffmanBytes 霍夫曼字节数组
	 * @return {@link byte[] }
	 */
	public static byte[] decode(Map<Byte, String> huffmanCodes, byte[] huffmanBytes) {
		// 将huffmanBytes转换为二进制字符串
		final StringBuilder stringBuilder = new StringBuilder();
		for (int i = 0; i < huffmanBytes.length; i++) {
			final byte b = huffmanBytes[i];
			final boolean flag = i != huffmanBytes.length - 1;
			stringBuilder.append(byte2BitString(flag, b));
		}

		// 赫夫曼编码表反转
		final HashMap<String, Byte> map = new HashMap<>();
		for (Map.Entry<Byte, String> entry : huffmanCodes.entrySet()) {
			map.put(entry.getValue(), entry.getKey());
		}

		// 遍历二进制字符串，根据赫夫曼编码表获取对应的字符并添加到list中
		final List<Byte> list = new ArrayList<>();
		for (int i = 0; i < stringBuilder.length(); ) {
			int count = 1;
			while (true) {
				final String s = stringBuilder.substring(i, i + count);
				if (map.containsKey(s)) {
					list.add(map.get(s));
					i += count;
					break;
				}
				count++;
			}
		}

		// 将list转换为byte数组并返回
		byte[] b = new byte[list.size()];
		for (int i = 0; i < b.length; i++) {
			b[i] = list.get(i);
		}

		return b;
	}

	/**
	 * 将字节转换为二进制字符串表示
	 *
	 * @param flag 一个布尔值，指示是否需要扩展符号位这用于处理负数的情况，以确保输出始终为8位
	 * @param b    需要转换的字节
	 * @return 字节的二进制字符串表示如果flag为true，结果将扩展符号位
	 */
	private static String byte2BitString(boolean flag, byte b) {
		// 将字节转换为整数以便进行位操作
		int temp = b;
		// 如果标志位为真，对temp进行按位或操作，以扩展符号位
		if (flag) {
			temp |= 256;
		}

		// 将操作后的整数转换为二进制字符串
		final String str = Integer.toBinaryString(temp);
		if (flag) {
			return str.substring(str.length() - 8);
		}
		else {
			return str;
		}
	}

	public static Map<Byte, String> getHuffmanCodes(byte[] bytes) {
		// 根据字节数组获取节点集合
		final List<Node> nodes = getNodes(bytes);
		// 创建赫夫曼树
		final Node huffmanTreeRoot = createHuffmanTree(nodes);
		// 获取赫夫曼编码表
		return getCodes(huffmanTreeRoot);
	}

	/**
	 * 压缩字节数组
	 *
	 * @param bytes        字节
	 * @param huffmanCodes 霍夫曼代码
	 * @return {@link byte[] }
	 */
	public static byte[] encode(byte[] bytes, Map<Byte, String> huffmanCodes) {
		// 遍历bytes，得到每个byte对应的赫夫曼编码
		StringBuilder stringBuilder = new StringBuilder();
		for (byte b : bytes) {
			stringBuilder.append(huffmanCodes.get(b));
		}

		// 计算赫夫曼编码字节数组所需长度
		int len;
		if (stringBuilder.length() % 8 == 0) {
			len = stringBuilder.length() / 8;
		}
		else {
			len = stringBuilder.length() / 8 + 1;
		}

		// 赫夫曼编码后的字节数组
		byte[] huffmanCodeBytes = new byte[len];
		for (int i = 0; i < stringBuilder.length(); i += 8) {
			StringBuilder s = new StringBuilder();
			if (i + 8 > stringBuilder.length()) {
				s.append(stringBuilder.substring(i));
			}
			else {
				s.append(stringBuilder.substring(i, i + 8));
			}
			huffmanCodeBytes[i / 8] = (byte) Integer.parseInt(s.toString(), 2);
		}
		return huffmanCodeBytes;
	}

	/**
	 * 获取赫夫曼编码
	 *
	 * @param root 根
	 * @return {@link Map }<{@link Byte }, {@link String }>
	 */
	private static Map<Byte, String> getCodes(Node root) {
		if (root == null) {
			return null;
		}

		final StringBuilder stringBuilder = new StringBuilder();
		final Map<Byte, String> huffmanCodes = new HashMap<>();
		// 递归左子树
		getCodes(root.getLeft(), "0", stringBuilder, huffmanCodes);
		// 递归右子树
		getCodes(root.getRight(), "1", stringBuilder, huffmanCodes);

		return huffmanCodes;
	}

	/**
	 * 递归获取赫夫曼编码
	 *
	 * @param node          节点
	 * @param code          编码
	 * @param stringBuilder stringBuilder
	 * @param huffmanCodes  赫夫曼编码
	 */
	private static void getCodes(Node node, String code, StringBuilder stringBuilder, Map<Byte, String> huffmanCodes) {
		final StringBuilder stringBuilder2 = new StringBuilder(stringBuilder);
		stringBuilder2.append(code);
		if (node != null) {
			// 非叶子结点
			if (node.getData() == null) {
				// 递归左子树
				getCodes(node.getLeft(), "0", stringBuilder2, huffmanCodes);
				// 递归右子树
				getCodes(node.getRight(), "1", stringBuilder2, huffmanCodes);
			}
			// 叶子结点
			else {
				huffmanCodes.put(node.getData(), stringBuilder2.toString());
			}
		}
	}

	/**
	 * 根据字节数组创建Node集合
	 *
	 * @param bytes 字节
	 * @return {@link List }<{@link Node }>
	 */
	private static List<Node> getNodes(byte[] bytes) {
		// 统计每个byte出现的次数
		Map<Byte, Integer> countMap = new HashMap<>();
		for (byte c : bytes) {
			if (countMap.containsKey(c)) {
				countMap.put(c, countMap.get(c) + 1);
			}
			else {
				countMap.put(c, 1);
			}
		}

		// 将每个byte出现的次数封装成Node
		List<Node> nodes = new ArrayList<>();
		for (Map.Entry<Byte, Integer> entry : countMap.entrySet()) {
			nodes.add(new Node(entry.getKey(), entry.getValue()));
		}

		return nodes;
	}

	/**
	 * 创建一颗赫夫曼树
	 *
	 * @param nodes 节点
	 * @return {@link Node }
	 */
	private static Node createHuffmanTree(List<Node> nodes) {
		while (nodes.size() > 1) {
			// 从小到大排序
			Collections.sort(nodes);

			// 创建一颗新的二叉树，只有权值，没有数据
			final Node leftNode = nodes.get(0);
			final Node rightNode = nodes.get(1);
			final Node parent = new Node(null, leftNode.getWeight() + rightNode.getWeight());
			parent.setLeft(leftNode);
			parent.setRight(rightNode);

			// 移除最小、次小并将parent加入nodes
			nodes.remove(leftNode);
			nodes.remove(rightNode);
			nodes.add(parent);
		}

		// 返回赫夫曼树的根节点
		return nodes.get(0);
	}

	/**
	 * 前序遍历
	 *
	 * @param root 根
	 */
	public static void preOrder(Node root) {
		if (root == null) {
			System.out.println("赫夫曼树为空");
			return;
		}
		root.preOrder();
	}

}
