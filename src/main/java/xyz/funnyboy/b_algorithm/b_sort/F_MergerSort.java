package xyz.funnyboy.b_algorithm.b_sort;

/**
 * @author VectorX
 * @version V1.0
 * @description 归并排序
 * @date 2025-02-08 15:23:07
 */
public class F_MergerSort
{
	public static void sort(int[] arr) {
		decompose(arr, 0, arr.length - 1, new int[arr.length]);
	}

	/**
	 * 分解
	 *
	 * @param arr   原始数组
	 * @param left  左
	 * @param right 右
	 * @param temp  临时数组
	 */
	private static void decompose(int[] arr, int left, int right, int[] temp) {
		if (left < right) {
			int mid = (left + right) / 2;
			// 向左分解
			decompose(arr, left, mid, temp);
			// 向右分解
			decompose(arr, mid + 1, right, temp);
			// 合并
			merge(arr, left, mid, right, temp);
		}
	}

	/**
	 * 合并
	 *
	 * @param arr   原始数组
	 * @param left  左
	 * @param mid   中
	 * @param right 右
	 * @param temp  临时数组
	 */
	private static void merge(int[] arr, int left, int mid, int right, int[] temp) {
		int i = left;
		int j = mid + 1;
		int t = 0;
		// 循环比较，将较小的值放入temp中
		while (i <= mid && j <= right) {
			if (arr[i] <= arr[j]) {
				temp[t++] = arr[i++];
			}
			else {
				temp[t++] = arr[j++];
			}
		}
		// 剩余数据填充到temp中
		while (i <= mid) {
			temp[t++] = arr[i++];
		}
		while (j <= right) {
			temp[t++] = arr[j++];
		}
		// 将temp中的数据拷贝回arr中
		i = left;
		t = 0;
		while (i <= right) {
			arr[i++] = temp[t++];
		}
	}
}
