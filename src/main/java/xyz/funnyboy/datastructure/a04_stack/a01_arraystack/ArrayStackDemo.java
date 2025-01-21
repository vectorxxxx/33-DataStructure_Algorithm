package xyz.funnyboy.datastructure.a04_stack.a01_arraystack;

import java.util.Scanner;

/**
 * @author VectorX
 * @version V1.0
 * @description
 * @date 2025-01-21 09:43:32
 */
public class ArrayStackDemo
{
	public static void main(String[] args) {
		final ArrayStack arrayStack = new ArrayStack(4);
		final Scanner scanner = new Scanner(System.in);
		while (true) {
			System.out.println("==================1、入栈  2、出栈  3、遍历  4、查看栈顶元素  0、退出==================");
			final int i;
			try {
				i = scanner.nextInt();
			}
			catch (Exception e) {
				System.out.println("输入有误：" + e.getMessage());
				continue;
			}
			switch (i) {
				case 1:
					System.out.print("请输入入栈的值：");
					final int value;
					try {
						value = scanner.nextInt();
					}
					catch (Exception e) {
						System.out.println("输入有误：" + e.getMessage());
						continue;
					}
					arrayStack.push(value);
					break;
				case 2:
					try {
						System.out.println("出栈的值为：" + arrayStack.pop());
					}
					catch (Exception e) {
						System.out.println(e.getMessage());
					}
					break;
				case 3:
					arrayStack.list();
					break;
				case 4:
					System.out.println("栈顶元素为：" + arrayStack.peek());
					break;
				default:
					scanner.close();
					System.exit(0);
					break;
			}
		}
	}
}
