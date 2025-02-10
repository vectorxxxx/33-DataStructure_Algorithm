package xyz.funnyboy.a_datastructure.e_hashtab;

import java.util.Scanner;

/**
 * @author VectorX
 * @version V1.0
 * @description
 * @date 2025-02-10 15:15:44
 */
public class HashTabDemo
{
	public static void main(String[] args) {
		HashTab hashTab = new HashTab(7);

		Scanner scanner = new Scanner(System.in);
		while (true) {
			System.out.println("=============");
			System.out.println("a: 添加雇员");
			System.out.println("l: 显示雇员");
			System.out.println("f: 查找雇员");
			System.out.println("e: 退出系统");

			String key = scanner.next();
			switch (key) {
				case "a":
					System.out.print("输入id：");
					int id = scanner.nextInt();
					System.out.print("输入名字：");
					String name = scanner.next();
					hashTab.add(new Emp(id, name));
					break;
				case "l":
					hashTab.list();
					break;
				case "f":
					System.out.print("请输入要查找的id：");
					id = scanner.nextInt();
					hashTab.findEmpById(id);
					break;
				case "e":
					scanner.close();
					System.exit(0);
				default:
					break;
			}
		}
	}
}
