package xyz.funnyboy.algorithm.a02_sort;

/**
 * @author VectorX
 * @version V1.0
 * @description
 * @date 2025-01-23 13:35:39
 */
public class A05_QuickSort
{
	public static void sort(int[] arr) {
		sort(arr, 0, arr.length - 1);
	}

	private static void sort(int[] arr, int left, int right) {
		int l = left;
		int r = right;
		// 中轴值
		int pivot = arr[(left + right) / 2];
		while (l < r) {
			// 左边找到≥中轴值的值
			while (arr[l] < pivot) {
				l++;
			}
			// 右边找到≤中轴值的值
			while (arr[r] > pivot) {
				r--;
			}
			// 找完了
			if (l >= r) {
				break;
			}
			// 左右交换
			int temp = arr[l];
			arr[l] = arr[r];
			arr[r] = temp;            // 避免相等的值导致死循环
			if (arr[l] == pivot) {
				r--;
			}
			if (arr[r] == pivot) {
				l++;
			}
		}
		// 避免相等的值导致死循环
		if (l == r) {
			l++;
			r--;
		}
		// 左递归
		if (left < r) {
			sort(arr, left, r);
		}
		// 右递归
		if (right > l) {
			sort(arr, l, right);
		}
	}

}
