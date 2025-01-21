package xyz.funnyboy.a02_queue.a01_queue;

import java.util.Scanner;

/**
 * @author VectorX
 * @version V1.0
 * @description
 * @date 2025-01-16 14:07:42
 */
public class ArrayQueueDemo
{
	public static void main(String[] args) {
		ArrayQueue arrayQueue = new ArrayQueue(5);
		final Scanner scanner = new Scanner(System.in);
		while (true) {
			System.out.println("=====================================");
			System.out.println("1. 显示队列\t2. 查看队首");
			System.out.println("3. 入队   \t4. 出列");
			System.out.println("5. 退出");
			switch (scanner.nextInt()) {
				case 1:
					arrayQueue.revealQueue();
					break;
				case 2:
					try {
						System.out.println(arrayQueue.headQueue());
					}
					catch (Exception e) {
						System.out.println(e.getMessage());
					}
					break;
				case 3:
					System.out.print("请输入一个数：");
					arrayQueue.enqueue(scanner.nextInt());
					break;
				case 4:
					try {
						System.out.println(arrayQueue.dequeue());
					}
					catch (Exception e) {
						System.out.println(e.getMessage());
					}
					break;
				case 5:
					scanner.close();
					System.exit(0);
					break;
				default:
					break;
			}
		}
	}

}
