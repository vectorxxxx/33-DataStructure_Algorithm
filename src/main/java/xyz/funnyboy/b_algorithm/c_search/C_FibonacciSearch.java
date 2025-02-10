package xyz.funnyboy.b_algorithm.c_search;

import java.util.Arrays;

/**
 * @author VectorX
 * @version V1.0
 * @description 斐波那契查找
 * @date 2025-02-10 09:12:19
 */
public class C_FibonacciSearch
{

	protected static final int MAX_SIZE = 40;

	public static void main(String[] args) {
		final int[] fib = fib(MAX_SIZE);
		System.out.println(Arrays.toString(fib));
	}

	public static int[] fib(int maxSize) {
		int[] arr = new int[maxSize];
		for (int i = 0; i < maxSize; i++) {
			if (i < 2) {
				arr[i] = 1;
			}
			else {
				arr[i] = arr[i - 1] + arr[i - 2];
			}
		}
		return arr;
	}

	public static int search(int[] a, int key) {
		// 初始化low、mid、high
		int low = 0;
		int mid = 0;
		int high = a.length - 1;

		// 初始化斐波那契数列
		int[] f = fib(MAX_SIZE);

		// 查找数组大小在斐波纳契数列中对应值索引
		int k = 0;
		while (high > f[k] - 1) {
			k++;
		}

		// 数组填充
		int[] temp = Arrays.copyOf(a, f[k]);
		for (int i = high + 1; i < f[k]; i++) {
			temp[i] = a[high];
		}

		// f[k] = f[k-1] + f[k-2]
		while (low <= high) {
			mid = low + f[k - 1] - 1;
			// 数组左边
			if (key < temp[mid]) {
				high = mid - 1;
				k--;
			}
			// 数组右边
			else if (key > temp[mid]) {
				low = mid + 1;
				k -= 2;
			}
			// 找到了
			else {
				return Math.min(mid, high);
			}
		}
		return -1;
	}
}
