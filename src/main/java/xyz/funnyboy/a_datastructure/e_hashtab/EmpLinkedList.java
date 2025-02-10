package xyz.funnyboy.a_datastructure.e_hashtab;

import java.text.MessageFormat;

/**
 * @author VectorX
 * @version V1.0
 * @description
 * @date 2025-02-10 14:50:03
 */
public class EmpLinkedList
{
	private Emp head;

	public void add(Emp emp) {
		if (head == null) {
			head = emp;
			return;
		}

		// 链表最后一个元素
		Emp curEmp = head;
		while (curEmp.next() != null) {
			curEmp = curEmp.next();
		}

		curEmp.next(emp);
	}

	public void list(int no) {
		if (head == null) {
			System.out.println(MessageFormat.format("第{0}条链表为空", no + 1));
			return;
		}

		System.out.print(MessageFormat.format("第{0}条链表信息为", no + 1));
		Emp curEmp = head;
		while (true) {
			System.out.printf(" => id=%d,name=%s\t", curEmp.getId(), curEmp.getName());
			if (curEmp.next() == null) {
				break;
			}
			curEmp = curEmp.next();
		}
		System.out.println();
	}

	public Emp findEmpById(int id) {
		if (head == null) {
			System.out.println("链表为空");
			return null;
		}

		Emp curEmp = head;
		while (true) {
			if (id == curEmp.getId()) {
				break;
			}
			if (curEmp.next() == null) {
				curEmp = null;
				break;
			}
			curEmp = curEmp.next();
		}
		return curEmp;
	}
}
