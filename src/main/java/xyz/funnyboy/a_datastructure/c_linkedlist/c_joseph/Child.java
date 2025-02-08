package xyz.funnyboy.a_datastructure.c_linkedlist.c_joseph;

/**
 * @author VectorX
 * @version V1.0
 * @description
 * @date 2025-01-20 17:31:45
 */
public class Child
{
	private int no;
	private Child next;

	public Child(int no) {
		this.no = no;
	}

	public int getNo() {
		return no;
	}

	public void setNo(int no) {
		this.no = no;
	}

	public Child next() {
		return next;
	}

	public void next(Child next) {
		this.next = next;
	}
}
