package xyz.funnyboy.a_datastructure.d_stack.c_polandnotation;

/**
 * @author VectorX
 * @version V1.0
 * @description
 * @date 2025-01-21 14:42:06
 */
public class Operation
{
	private static int getValue(String operation) {
		switch (operation) {
			case "*":
			case "/":
				return 2;
			case "+":
			case "-":
				return 1;
			default:
				// System.out.println("不存在该运算符" + operation);
				return 0;
		}
	}

	/**
	 * 比较
	 *
	 * @param operation1 操作 1
	 * @param operation2 操作 2
	 * @return int
	 */
	public static int compare(String operation1, String operation2) {
		int value1 = getValue(operation1);
		int value2 = getValue(operation2);
		return value1 - value2;
	}
}
