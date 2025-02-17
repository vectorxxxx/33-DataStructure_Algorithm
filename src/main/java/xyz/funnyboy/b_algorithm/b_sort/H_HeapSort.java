package xyz.funnyboy.b_algorithm.b_sort;

/**
 * @author VectorX
 * @version V1.0
 * @description 堆排序
 * @date 2025-02-10 16:48:45
 */
public class H_HeapSort
{
	public static void sort(int[] arr) {
		// 最后一个非叶子结点开始，不断往前调整，使其成为一个大顶堆或小顶堆
		for (int i = arr.length / 2 - 1; i >= 0; i--) {
			adjustHeap(arr, i, arr.length);
		}

		// 交换堆顶元素与末尾元素
		for (int i = arr.length - 1; i > 0; i--) {
			int temp = arr[i];
			arr[i] = arr[0];
			arr[0] = temp;
			adjustHeap(arr, 0, i);
		}
	}

	private static void adjustHeap(int[] arr, int i, int length) {
		// 当前节点的值
		int cur = arr[i];
		// 左子节点开始
		for (int k = i * 2 + 1; k < length; k = k * 2 + 1) {
			// 右子节点更大
			if (k + 1 < length && arr[k] < arr[k + 1]) {
				k++;
			}
			// 子节点更大
			if (arr[k] > cur) {
				arr[i] = arr[k];
				i = k;
			}
			else {
				break;
			}
		}
		arr[i] = cur;
	}
}
