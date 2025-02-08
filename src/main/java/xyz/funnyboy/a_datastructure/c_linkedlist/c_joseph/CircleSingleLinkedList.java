package xyz.funnyboy.a_datastructure.c_linkedlist.c_joseph;

/**
 * @author VectorX
 * @version V1.0
 * @description
 * @date 2025-01-20 17:33:18
 */
public class CircleSingleLinkedList
{
	private Child first;

	public void addChild(int nums) {
		if (nums < 1) {
			System.out.println("num值不正确");
			return;
		}

		Child curChild = null;
		for (int i = 0; i < nums; i++) {
			Child child = new Child(i + 1);
			if (i == 0) {
				first = child;
			}
			else {
				curChild.next(child);
			}
			curChild = child;
			curChild.next(first);
		}
	}

	public void showChild() {
		if (first == null) {
			System.out.println("没有小孩");
			return;
		}
		Child curChild = first;
		while (true) {
			System.out.printf("小孩的编号：%d\n", curChild.getNo());
			if (curChild.next() == first) {
				break;
			}
			curChild = curChild.next();
		}
	}

	public void countChild(int startNo, int countNum, int nums) {
		if (first == null || startNo < 1 || startNo > nums) {
			System.out.println("参数有误");
			return;
		}

		// 跟屁虫：创建一个辅助指针，指向最后一个节点
		Child helper = first;
		while (helper.next() != first) {
			helper = helper.next();
		}

		// 初始化first和helper到startNo位置
		for (int i = 0; i < startNo - 1; i++) {
			first = first.next();
			helper = helper.next();
		}
		System.out.printf("小孩%s开始报数\n", first.getNo());

		// 开始报数
		while (helper != first) {
			for (int i = 0; i < countNum - 1; i++) {
				helper = first;
				first = first.next();
			}
			System.out.printf("小孩%d出圈\n", first.getNo());
			first = first.next();
			helper
					.next()
					.next(null);
			helper.next(first);
		}
		System.out.printf("最后留在圈中的小孩编号：%s", first.getNo());
	}
}
