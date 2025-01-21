package xyz.funnyboy.datastructure.a04_stack.a02_calculator;

import java.util.Arrays;

/**
 * @author VectorX
 * @version V1.0
 * @description
 * @date 2025-01-21 09:53:59
 */
public class Calculator
{
	public int calculate(String expression) {
		ArrayStack numStack = new ArrayStack(10);
		ArrayStack operStack = new ArrayStack(10);
		StringBuilder keepNum = new StringBuilder();
		for (int i = 0; i < expression.length(); i++) {
			char ch = expression
					.substring(i, i + 1)
					.charAt(0);
			// 判断是否为操作符
			if (isOper(ch)) {
				// 判断操作符栈是否为空，不为空，判断优先级
				if (!operStack.isEmpty() && priority(ch) <= priority(operStack.peek())) {
					int res = cal(numStack.pop(), numStack.pop(), operStack.pop());
					numStack.push(res);
				}
				operStack.push(ch);
			}
			// 判断是否为数字
			else {
				keepNum.append(ch);
				// 判断下一位是否为运算符
				if (i == expression.length() - 1 || isOper(expression
						.substring(i + 1, i + 2)
						.charAt(0))) {
					numStack.push(Integer.parseInt(keepNum.toString()));
					keepNum = new StringBuilder();
				}
			}
		}

		while (!operStack.isEmpty()) {
			int res = cal(numStack.pop(), numStack.pop(), operStack.pop());
			numStack.push(res);
		}
		return numStack.pop();
	}

	private int cal(int num1, int num2, int oper) {
		int res = 0;
		switch (oper) {
			case '+':
				res = num1 + num2;
				break;
			case '-':
				res = num2 - num1;
				break;
			case '*':
				res = num1 * num2;
				break;
			case '/':
				res = num2 / num1;
				break;
			default:
				break;
		}
		return res;
	}

	private boolean isOper(int oper) {
		return Arrays
				.asList('+', '-', '*', '/')
				.contains((char) oper);
	}

	private int priority(int oper) {
		switch (oper) {
			case '*':
			case '/':
				return 2;
			case '+':
			case '-':
				return 1;
			default:
				return 0;
		}
	}

}
