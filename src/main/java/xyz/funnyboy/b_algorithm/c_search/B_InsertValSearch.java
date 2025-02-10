package xyz.funnyboy.b_algorithm.c_search;

/**
 * @author VectorX
 * @version V1.0
 * @description 插值查找
 * @date 2025-02-08 17:31:43
 */
public class B_InsertValSearch
{
	public static int search(int[] arr, int finalVal) {
		return insertValSearch(arr, 0, arr.length - 1, finalVal);
	}

	private static int insertValSearch(int[] arr, int left, int right, int finalVal) {
		if (left > right || finalVal < arr[0] || finalVal > arr[arr.length - 1]) {
			return -1;
		}

		int mid = left + (right - left) * (finalVal - arr[left]) / (arr[right] - arr[left]);
		int midVal = arr[mid];

		if (finalVal > midVal) {
			return insertValSearch(arr, mid + 1, right, finalVal);
		}
		else if (finalVal < midVal) {
			return insertValSearch(arr, left, mid - 1, finalVal);
		}
		else {
			return mid;
		}
	}
}
