package xyz.funnyboy.b_algorithm.b_sort;

import java.text.MessageFormat;
import java.util.Arrays;

/**
 * @author VectorX
 * @version V1.0
 * @description
 * @date 2025-01-22 17:05:14
 */
public class SortDemo
{
	public static void main(String[] args) {
		// test1();
		test2();
	}

	private static void test1() {
		int[] arr = {8, 9, 1, 7, 2, 3, 5, 4, 6, 0};
		System.out.println(MessageFormat.format("排序前：{0}", Arrays.toString(arr)));
		// A01_BubbleSort.sort(arr);
		// A02_SelectSort.sort(arr);
		// A03_InsertSort.sort(arr);
		// A04_ShellSort.sort(arr);
		// A05_QuickSort.sort(arr);
		// F_MergerSort.sort(arr);
		// G_RadixSort.sort(arr);
		H_HeapSort.sort(arr);
		System.out.println(MessageFormat.format("排序后：{0}", Arrays.toString(arr)));
	}

	private static void test2() {
		// final int size = 80000;
		final int size = 8000000;
		int[] arr = new int[size];
		for (int i = 0; i < size; i++) {
			arr[i] = (int) (Math.random() * 8000000);
		}

		// System.out.println(MessageFormat.format("排序前：{0}", Arrays.toString(arr)));
		final long start = System.currentTimeMillis();
		// A01_BubbleSort.sort(arr);
		// A02_SelectSort.sort(arr);
		// A03_InsertSort.sort(arr);
		// A04_ShellSort.sort(arr);
		// A05_QuickSort.sort(arr);
		// F_MergerSort.sort(arr);
		// G_RadixSort.sort(arr);
		H_HeapSort.sort(arr);
		final long end = System.currentTimeMillis();
		// System.out.println(MessageFormat.format("排序后：{0}", Arrays.toString(arr)));

		//                     80000   | 8000000
		// 冒泡排序耗时：        6,823ms
		// 选择排序耗时：        1,936ms
		// 插入排序耗时：        520ms
		// 希尔排序（交换）耗时：  5,390ms
		// 希尔排序（移位）耗时：  18ms     |  1,747ms
		// 快速排序耗时：        13ms     |  809ms
		// 归并排序耗时：        16ms     |  1,038ms
		// 基数排序耗时：        8ms      |  278ms
		// 堆排序耗时：          10ms     |  1,649ms
		System.out.println(MessageFormat.format("排序耗时：{0}ms", end - start));
	}

}
