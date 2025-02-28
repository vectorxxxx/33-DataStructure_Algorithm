package xyz.funnyboy.b_algorithm.c_search;

/**
 * @author VectorX
 * @version V1.0
 * @description
 * @date 2025-02-28 15:38:38
 */
public class A_BinarySearch_NoRecur
{
	public static int search(int[] arr, int target) {
		int left = 0;
		int right = arr.length - 1;
		while (left <= right) {
			int mid = (left + right) / 2;
			if (arr[mid] == target) {
				return mid;
			}
			else if (arr[mid] > target) {
				right = mid - 1;
			}
			else {
				left = mid + 1;
			}
		}
		return -1;
	}
}
