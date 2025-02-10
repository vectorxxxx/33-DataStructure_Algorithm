package xyz.funnyboy.a_datastructure.e_hashtab;

import java.util.stream.IntStream;

/**
 * @author VectorX
 * @version V1.0
 * @description
 * @date 2025-02-10 15:03:37
 */
public class HashTab
{
	private final EmpLinkedList[] empLinkedListArr;
	private final int size;

	public HashTab(int size) {
		this.size = size;
		empLinkedListArr = new EmpLinkedList[size];
		for (int i = 0; i < empLinkedListArr.length; i++) {
			empLinkedListArr[i] = new EmpLinkedList();
		}
	}

	public void add(Emp emp) {
		final int hashId = hashId(emp.getId());
		empLinkedListArr[hashId].add(emp);
	}

	public void list() {
		IntStream
				.range(0, empLinkedListArr.length)
				.forEach(i -> empLinkedListArr[i].list(i));
	}

	public void findEmpById(int id) {
		final int hashId = hashId(id);
		final Emp emp = empLinkedListArr[hashId].findEmpById(id);
		if (emp == null) {
			System.out.println("未查找到该员工信息");
			return;
		}
		System.out.printf("在第%d条链表中查找到该员工信息：id=%d,name=%s", hashId + 1, emp.getId(), emp.getName());
	}

	private int hashId(int id) {
		return id % size;
	}
}
