package xyz.funnyboy.a_datastructure.d_stack.c_polandnotation;

import java.util.List;

/**
 * @author VectorX
 * @version V1.0
 * @description
 * @date 2025-01-21 14:28:52
 */
public class PolandNotationDemo
{
	public static void main(String[] args) {
		// final String expression = "1+((2+3)*4)-5";
		final String expression = "11+((22+33)*44)-55";

		// [1, +, (, (, 2, +, 3, ), *, 4, ), -, 5]
		final List<String> infixExpressionList = ExpressionUtils.toInfixExpressionList(expression);
		System.out.println("中缀表达式：" + infixExpressionList);

		// [1, 2, 3, +, 4, *, +, 5, -]
		final List<String> suffixExpressionList = ExpressionUtils.toSuffixExpressionList(infixExpressionList);
		System.out.println("后缀表达式：" + suffixExpressionList);

		// 16
		final int res = Calculator.calculate(suffixExpressionList);
		System.out.println("计算结果：" + res);
	}
}
