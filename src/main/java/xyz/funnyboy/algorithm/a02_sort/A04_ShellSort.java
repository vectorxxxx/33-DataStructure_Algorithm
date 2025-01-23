package xyz.funnyboy.algorithm.a02_sort;

import java.text.MessageFormat;
import java.util.Arrays;

/**
 * @author VectorX
 * @version V1.0
 * @description
 * @date 2025-01-23 09:40:51
 */
public class A04_ShellSort
{
	public static void sort(int[] arr) {
		int count = 0;
		// 缩小增量
		for (int gap = arr.length / 2; gap > 0; gap /= 2) {
			// 移位法
			for (int i = gap; i < arr.length; i++) {
				if (arr[i - gap] > arr[i]) {
					int j = i;
					int temp = arr[j];
					while (j - gap >= 0 && arr[j - gap] > temp) {
						arr[j] = arr[j - gap];
						j -= gap;
					}
					arr[j] = temp;
				}
			}
			// System.out.println(MessageFormat.format("第{0}趟排序结果：{1}", ++count, Arrays.toString(arr)));
		}
	}

	public static void sortOld(int[] arr) {
		int count = 0;
		// 缩小增量
		for (int gap = arr.length / 2; gap > 0; gap /= 2) {
			// 交换法
			for (int i = gap; i < arr.length; i++) {
				for (int j = i - gap; j >= 0; j -= gap) {
					if (arr[j] > arr[j + gap]) {
						int temp = arr[j];
						arr[j] = arr[j + gap];
						arr[j + gap] = temp;
					}
				}
			}
			System.out.println(MessageFormat.format("第{0}趟排序结果：{1}", ++count, Arrays.toString(arr)));
		}
	}
}
