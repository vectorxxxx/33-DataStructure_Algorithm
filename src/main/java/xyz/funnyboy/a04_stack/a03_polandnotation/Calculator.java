package xyz.funnyboy.a04_stack.a03_polandnotation;

import java.util.List;
import java.util.Stack;

/**
 * @author VectorX
 * @version V1.0
 * @description
 * @date 2025-01-21 15:03:07
 */
public class Calculator
{
	/**
	 * 根据后缀表达式计算结果
	 *
	 * @param suffixExpressionList 后缀表达式列表
	 * @return int
	 */
	public static int calculate(List<String> suffixExpressionList) {
		Stack<String> stack = new Stack<>();
		for (String item : suffixExpressionList) {
			if (item.matches("\\d+")) {
				stack.push(item);
			}
			else {
				int num2 = Integer.parseInt(stack.pop());
				int num1 = Integer.parseInt(stack.pop());
				final int res = calc(item, num2, num1);
				stack.push(String.valueOf(res));
			}
		}
		return Integer.parseInt(stack.pop());
	}

	private static int calc(String oper, int num2, int num1) {
		int res = 0;
		switch (oper) {
			case "+":
				res = num1 + num2;
				break;
			case "-":
				res = num1 - num2;
				break;
			case "*":
				res = num1 * num2;
				break;
			case "/":
				res = num1 / num2;
				break;
			default:
				break;
		}
		return res;
	}
}
