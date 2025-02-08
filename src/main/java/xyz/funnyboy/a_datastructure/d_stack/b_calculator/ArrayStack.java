package xyz.funnyboy.a_datastructure.d_stack.b_calculator;

/**
 * @author VectorX
 * @version V1.0
 * @description
 * @date 2025-01-21 09:37:16
 */
public class ArrayStack
{
	private int maxSize;
	private int[] stack;
	private int top = -1;

	public ArrayStack(int maxSize) {
		this.maxSize = maxSize;
		stack = new int[this.maxSize];
	}

	public boolean isFull() {
		return top == maxSize - 1;
	}

	public boolean isEmpty() {
		return top == -1;
	}

	public void push(int value) {
		if (isFull()) {
			System.out.println("栈满");
			return;
		}
		stack[++top] = value;
	}

	public int pop() {
		if (isEmpty()) {
			throw new RuntimeException("栈空，没有数据");
		}
		return stack[top--];
	}

	public int peek() {
		if (isEmpty()) {
			throw new RuntimeException("栈空，没有数据");
		}
		return stack[top];
	}

	public void list() {
		if (isEmpty()) {
			System.out.println("栈空，没有数据");
			return;
		}
		for (int i = top; i >= 0; i--) {
			System.out.printf("stack[%d]=%d\n", i, stack[i]);
		}
	}
}
