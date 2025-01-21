package xyz.funnyboy.a04_stack.a02_calculator;

/**
 * @author VectorX
 * @version V1.0
 * @description
 * @date 2025-01-21 10:29:57
 */
public class CalculatorDemo
{
	public static void main(String[] args) {
		// final String expression = "7*2*2-5+1-5+3-4"; // 18
		final String expression = "70*2*2-15+13-25+63-74"; // 242
		final int res = new Calculator().calculate(expression);
		System.out.printf("%s=%s\n", expression, res);
	}
}
