package xyz.funnyboy.datastructure.a02_queue.a01_queue;

/**
 * @author VectorX
 * @version 1.0.0
 * @description 数组模拟队列
 *
 * front+1 ==> 队首
 *
 * rear ==> 队尾
 *
 * @date 2025/01/16
 */
class ArrayQueue
{
	private final int maxSize;
	private final int[] arr;
	private int front;
	private int rear;

	public ArrayQueue(int maxSize) {
		this.maxSize = maxSize;
		arr = new int[maxSize];
		front = -1;
		rear = -1;
	}

	/**
	 * 判断队列是否已满
	 *
	 * @return boolean
	 */
	public boolean isFull() {
		return rear == maxSize - 1;
	}

	/**
	 * 判断队列是否为空
	 *
	 * @return boolean
	 */
	public boolean isEmpty() {
		return rear == front;
	}

	/**
	 * 入队
	 *
	 * @param n n
	 */
	public void enqueue(int n) {
		if (isFull()) {
			System.out.println("队列已满");
			return;
		}
		rear++;
		arr[rear] = n;
	}

	/**
	 * 出列
	 *
	 * @return int
	 */
	public int dequeue() {
		if (isEmpty()) {
			throw new RuntimeException("队列已空");
		}
		front++;
		return arr[front];
	}

	/**
	 * 队首
	 *
	 * @return int
	 */
	public int headQueue() {
		if (isEmpty()) {
			throw new RuntimeException("队列为空");
		}
		return arr[front + 1];
	}

	/**
	 * 显示队列
	 */
	public void revealQueue() {
		if (isEmpty()) {
			System.out.println("队列为空");
			return;
		}
		int index = 0;
		for (int i = front + 1; i <= rear; i++) {
			System.out.printf("arr[%d]=%d\n", index++, arr[i]);
		}
	}
}
