package xyz.funnyboy.algorithm.a02_sort;

/**
 * @author VectorX
 * @version V1.0
 * @description 选择排序
 * @date 2025-01-22 17:05:14
 */
public class A02_SelectSort
{

	public static void sort(int[] arr) {
		// 第1个~倒数第2个
		for (int i = 0; i < arr.length - 1; i++) {
			int minIndex = i;
			int minValue = arr[i];
			// i后面1个~倒数第1个
			for (int j = i + 1; j < arr.length; j++) {
				if (arr[minIndex] > arr[j]) {
					minIndex = j;
					minValue = arr[j];
				}
			}
			// 找到最小值，则替换
			if (minIndex != i) {
				arr[minIndex] = arr[i];
				arr[i] = minValue;
			}
			// System.out.println(MessageFormat.format("第{0}轮排序：{1}", i + 1, Arrays.toString(arr)));
		}
	}
}
