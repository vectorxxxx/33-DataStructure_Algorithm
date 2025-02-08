package xyz.funnyboy.b_algorithm.a_recursion.c_queuen;

/**
 * @author VectorX
 * @version V1.0
 * @description
 * @date 2025-01-21 17:11:57
 */
public class QueueN
{
	private final int max;
	private final int[] array;
	private int ways = 0;
	private int tryCount = 0;

	public QueueN(int max) {
		this.max = max;
		this.array = new int[max];
	}

	public void play() {
		haveTry(0);
		System.out.printf("共找到%s种解法\n", ways);
		System.out.printf("共尝试%s次\n", tryCount);
	}

	private void haveTry(int n) {
		if (n == max) {
			ways++;
			print();
			return;
		}

		for (int i = 0; i < max; i++) {
			array[n] = i;
			if (!isConflict(n)) {
				haveTry(n + 1);
			}
		}
	}

	private boolean isConflict(int n) {
		tryCount++;
		// 逐行判断
		for (int i = 0; i < n; i++) {
			// 同一列 || 对角线：等腰直角三角形
			if (array[i] == array[n] || Math.abs(array[n] - array[i]) == Math.abs(n - i)) {
				return true;
			}
		}
		return false;
	}

	private void print() {
		for (int col : array) {
			System.out.printf("%d\t", col);
		}
		System.out.println();
	}
}
