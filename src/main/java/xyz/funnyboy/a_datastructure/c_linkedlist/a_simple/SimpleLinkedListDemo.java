package xyz.funnyboy.a_datastructure.c_linkedlist.a_simple;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * @author VectorX
 * @version V1.0
 * @description
 * @date 2025-01-16 16:59:07
 */
public class SimpleLinkedListDemo
{
	private static SimpleLinkedList simpleLinkedList = new SimpleLinkedList();

	private static List<Integer> noList = new ArrayList<>();

	static {
		simpleLinkedList.addTail(new HeroNode(1, "鲁班", "小短腿"));
		simpleLinkedList.addTail(new HeroNode(2, "孙悟空", "齐天大圣"));
		simpleLinkedList.addTail(new HeroNode(3, "周瑜", "公瑾"));
		simpleLinkedList.addTail(new HeroNode(4, "马超", "赤子"));
		simpleLinkedList.addTail(new HeroNode(5, "赵云", "常山赵子龙"));
		for (int i = 0; i < 5; i++) {
			noList.add(i + 1);
		}
	}

	public static void main(String[] args) {
		final Scanner scanner = new Scanner(System.in);
		while (true) {
			System.out.println("==================1、增  2、删  3、改  4、查  0、退出==================");
			switch (scanner.nextInt()) {
				case 1:
					addHero(simpleLinkedList, scanner);
					break;
				case 2:
					removeHero(simpleLinkedList, scanner);
					break;
				case 3:
					updateHero(simpleLinkedList, scanner);
					break;
				case 4:
					viewHero(simpleLinkedList, scanner);
					break;
				case 0:
					scanner.close();
					System.exit(0);
					break;
				default:
					System.out.println("输入错误");
					break;
			}
		}
	}

	private static void addHero(SimpleLinkedList simpleLinkedList, Scanner scanner) {
		System.out.println("===================1、头插  2、尾插  3、指定位置插  0、回到上一级===================");
		final int option = scanner.nextInt();
		if (option == 0) {
			return;
		}

		int no;
		while (true) {
			System.out.print("请输入英雄编号：");
			try {
				no = scanner.nextInt();
			}
			catch (Exception e) {
				System.out.println(e.getMessage());
				continue;
			}
			if (noList.contains(no)) {
				System.out.println("编号重复");
				continue;
			}
			break;
		}

		final HeroNode heroNode;
		try {
			System.out.print("请输入英雄名称：");
			final String name = scanner.next();
			System.out.print("请输入英雄昵称：");
			final String nickname = scanner.next();
			heroNode = new HeroNode(no, name, nickname);
		}
		catch (Exception e) {
			System.out.println(e.getMessage());
			return;
		}

		switch (option) {
			case 1:
				simpleLinkedList.addHead(heroNode);
				noList.add(no);
				break;
			case 2:
				simpleLinkedList.addTail(heroNode);
				noList.add(no);
				break;
			case 3:
				System.out.print("请输入要插入的位置：");
				final int index;
				try {
					index = scanner.nextInt();
				}
				catch (Exception e) {
					System.out.println(e.getMessage());
					break;
				}
				simpleLinkedList.add(index, heroNode);
				noList.add(no);
				break;
			default:
				System.out.println("输入错误");
				break;
		}
	}

	private static void removeHero(SimpleLinkedList simpleLinkedList, Scanner scanner) {
		System.out.println("===================1、头删  2、尾删  3、指定位置删  0、回到上一级===================");
		final int option;
		try {
			option = scanner.nextInt();
		}
		catch (Exception e) {
			System.out.println(e.getMessage());
			return;
		}
		switch (option) {
			case 1:
				simpleLinkedList.removeFirst();
				noList.remove(0);
				break;
			case 2:
				simpleLinkedList.removeLast();
				noList.remove(simpleLinkedList.size() - 1);
				break;
			case 3:
				System.out.print("请输入要删除的位置：");
				final int index;
				try {
					index = scanner.nextInt();
				}
				catch (Exception e) {
					System.out.println(e.getMessage());
					break;
				}
				simpleLinkedList.remove(index);
				noList.remove(index);
				break;
			case 0:
				return;
			default:
				System.out.println("输入错误");
				break;
		}
	}

	private static void updateHero(SimpleLinkedList simpleLinkedList, Scanner scanner) {
		System.out.print("请输入要修改的英雄编号：");
		final int no;
		try {
			no = scanner.nextInt();
		}
		catch (Exception e) {
			System.out.println(e.getMessage());
			return;
		}

		final HeroNode heroNode = simpleLinkedList.view(no);
		if (heroNode == null) {
			System.out.println("没有该英雄");
			return;
		}
		else {
			System.out.println("修改前的英雄信息：" + heroNode);
		}

		System.out.print("请输入修改后的英雄名称：");
		final String name = scanner.next();
		System.out.print("请输入修改后的英雄昵称：");
		final String nickname = scanner.next();
		simpleLinkedList.update(new HeroNode(no, name, nickname));
		System.out.println("修改后的英雄信息：" + simpleLinkedList.view(no));
	}

	private static void viewHero(SimpleLinkedList simpleLinkedList, Scanner scanner) {
		System.out.println("===================1、查看所有  2、查看指定编号  0、回到上一级===================");
		final int option;
		try {
			option = scanner.nextInt();
		}
		catch (Exception e) {
			System.out.println(e.getMessage());
			return;
		}
		switch (option) {
			case 1:
				simpleLinkedList.view();
				break;
			case 2:
				System.out.print("请输入要查看的英雄编号：");
				final int no;
				try {
					no = scanner.nextInt();
				}
				catch (Exception e) {
					System.out.println(e.getMessage());
					break;
				}
				final HeroNode heroNode4 = simpleLinkedList.view(no);
				if (heroNode4 == null) {
					System.out.println("没有该英雄");
					break;
				}
				System.out.println(heroNode4);
				break;
			case 0:
				return;
			default:
				System.out.println("输入错误");
				break;
		}
	}

}
