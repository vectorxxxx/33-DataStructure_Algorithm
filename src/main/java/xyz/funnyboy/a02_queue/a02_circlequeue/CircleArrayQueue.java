package xyz.funnyboy.a02_queue.a02_circlequeue;

/**
 * @author VectorX
 * @version 1.0.0
 * @description 数组模拟环形队列
 *
 * front ==> 队首
 *
 * rear-1 ==> 队尾
 *
 * @date 2025/01/16
 */
class CircleArrayQueue
{
	private final int maxSize;
	private final int[] arr;
	private int front;
	private int rear;

	public CircleArrayQueue(int maxSize) {
		this.maxSize = maxSize + 1;
		arr = new int[this.maxSize];
		front = 0;
		rear = 0;
	}

	/**
	 * 判断队列是否已满
	 *
	 * @return boolean
	 */
	public boolean isFull() {
		return (rear + 1) % maxSize == front;
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
		arr[rear] = n;
		rear = (rear + 1) % maxSize;
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
		final int value = arr[front];
		front = (front + 1) % maxSize;
		return value;
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
		return arr[front];
	}

	/**
	 * 显示队列
	 */
	public void revealQueue() {
		if (isEmpty()) {
			System.out.println("队列为空");
			return;
		}

		// 写复杂了
		// int index = front;
		// do {
		// 	System.out.printf("arr[%d]=%d\n", (index + maxSize - front) % maxSize, arr[(index + 1) % maxSize]);
		// 	index = (index + 1) % maxSize;
		// }
		// while (index != rear);

		// 改写
		for (int i = front; i < front + size(); i++) {
			System.out.printf("arr[%d]=%d\n", (i - front) % (maxSize - 1), arr[i % maxSize]);
		}
	}

	/**
	 * 真实队列
	 */
	public void realQueue() {
		if (isEmpty()) {
			System.out.println("队列为空");
			return;
		}
		for (int i = 0; i < arr.length; i++) {
			if (i == rear - 1) {
				System.out.printf("arr[%d]=%d <== 队尾\n", i, arr[i]);
			}
			else if (i == front) {
				System.out.printf("arr[%d]=%d <== 队首\n ", i, arr[i]);
			}
			else {
				System.out.printf("arr[%d]=%d\n", i, arr[i]);
			}
		}
	}

	/**
	 * 大小
	 *
	 * @return int
	 */
	public int size() {
		return (rear + maxSize - front) % maxSize;
	}
}
