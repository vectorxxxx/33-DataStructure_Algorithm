package xyz.funnyboy.datastructure.a04_stack.a03_polandnotation;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * @author VectorX
 * @version V1.0
 * @description
 * @date 2025-01-21 14:25:12
 */
public class ExpressionUtils
{
	/**
	 * 转为中缀表达式列表
	 *
	 * @param s 表达式
	 * @return {@link List }<{@link String }>
	 */
	public static List<String> toInfixExpressionList(String s) {
		List<String> list = new ArrayList<>();
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < s.length(); i++) {
			char c = s.charAt(i);
			// 如果是符号，则直接加入到list中
			if (c < '0' || c > '9') {
				list.add(String.valueOf(c));
			}
			// 如果是数字，则判断是否是多位数
			else {
				sb.append(c);
				if (i == s.length() - 1 || (s.charAt(i + 1) < '0' || s.charAt(i + 1) > '9')) {
					list.add(sb.toString());
					sb = new StringBuilder();
				}
			}
		}
		return list;
	}

	/**
	 * 转为后缀表达式列表
	 *
	 * @param infixExpressionList 中缀表达式列表
	 * @return {@link List }<{@link String }>
	 */
	public static List<String> toSuffixExpressionList(List<String> infixExpressionList) {
		// 定义栈和集合
		Stack<String> s1 = new Stack<>();
		List<String> s2 = new ArrayList<>();
		for (String item : infixExpressionList) {
			// 如果是一个数，加入s2
			if (item.matches("\\d+")) {
				s2.add(item);
			}
			// 如果是左括号，则放入栈中
			else if ("(".equals(item)) {
				s1.push(item);
			}
			// 如果是右括号，则依次弹出s1栈顶的运算符，并压入s2，直到遇到左括号为止，此时将这一对括号丢弃
			else if (")".equals(item)) {
				while (!"(".equals(s1.peek())) {
					s2.add(s1.pop());
				}
				s1.pop();
			}
			// 如果是运算符，则比较其与s1栈顶运算符的优先级
			else {
				// 当item的优先级小于等于s1栈顶运算符, 将s1栈顶的运算符弹出并加入到s2中，再次转到(4.1)与s1中新的栈顶运算符相比较
				while (!s1.isEmpty() && Operation.compare(item, s1.peek()) <= 0) {
					s2.add(s1.pop());
				}
				s1.push(item);
			}
		}

		// 将s1中剩余的运算符依次弹出并加入s2
		while (!s1.isEmpty()) {
			s2.add(s1.pop());
		}
		return s2;
	}

}
