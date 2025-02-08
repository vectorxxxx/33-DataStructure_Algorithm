package xyz.funnyboy.b_algorithm.c_search;

/**
 * @author VectorX
 * @version V1.0
 * @description 二分查找（折半查找）
 * @date 2025-02-08 17:31:43
 */
public class A_BinarySearch
{
	public static int search(int[] arr, int finalVal) {
		return binarySearch(arr, 0, arr.length - 1, finalVal);
	}

	private static int binarySearch(int[] arr, int left, int right, int finalVal) {
		if (left > right || finalVal < arr[left] || finalVal > arr[right]) {
			return -1;
		}

		int mid = (left + right) / 2;
		int midVal = arr[mid];

		if (midVal > finalVal) {
			return binarySearch(arr, left, mid - 1, finalVal);
		}
		else if (midVal < finalVal) {
			return binarySearch(arr, mid + 1, right, finalVal);
		}
		else {
			return mid;
		}
	}
}
