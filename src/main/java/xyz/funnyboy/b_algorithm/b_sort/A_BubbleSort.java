package xyz.funnyboy.b_algorithm.b_sort;

/**
 * @author VectorX
 * @description 冒泡排序
 * @date 2025-01-22 09:33:44@version V1.0
 */
public class A_BubbleSort
{
	public static void sort(int[] arr) {
		for (int i = 0; i < arr.length - 1; i++) {
			boolean flag = false;
			for (int j = 0; j < arr.length - 1 - i; j++) {
				if (arr[j] > arr[j + 1]) {
					flag = true;
					int temp = arr[j];
					arr[j] = arr[j + 1];
					arr[j + 1] = temp;
				}
			}
			if (!flag) {
				break;
			}
			// System.out.println(MessageFormat.format("第{0}趟排序结果：{1}", i + 1, Arrays.toString(arr)));
		}
	}

	public static void sortOld(int[] arr) {
		for (int i = 0; i < arr.length - 1; i++) {
			for (int j = 0; j < arr.length - 1 - i; j++) {
				if (arr[j] > arr[j + 1]) {
					int temp = arr[j];
					arr[j] = arr[j + 1];
					arr[j + 1] = temp;
				}
			}
			// System.out.println(MessageFormat.format("第{0}趟排序结果：{1}", i + 1, Arrays.toString(arr)));
		}
	}

}
