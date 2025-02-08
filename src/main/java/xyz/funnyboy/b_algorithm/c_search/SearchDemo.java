package xyz.funnyboy.b_algorithm.c_search;

import java.text.MessageFormat;
import java.util.Arrays;
import java.util.Random;

/**
 * @author VectorX
 * @version V1.0
 * @description
 * @date 2025-02-08 17:31:29
 */
public class SearchDemo
{
	public static void main(String[] args) {
		// test1();
		test2();
	}

	private static void test1() {
		int[] arr = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20};
		for (int num : arr) {
			// final int index = A_BinarySearch.search(arr, num);
			final int index = B_InsertValSearch.search(arr, num);
			System.out.print(index + "\t");
		}
		System.out.println();
	}

	private static void test2() {
		// final int size = 8;
		// final int size = 80000;
		final int size = 8000000;
		int[] arr = new int[size];
		for (int i = 0; i < size; i++) {
			arr[i] = (int) (Math.random() * 8000000);
		}
		// System.out.println(MessageFormat.format("原数组：{0}", Arrays.toString(arr)));
		Arrays.sort(arr);
		// System.out.println(MessageFormat.format("排序后：{0}", Arrays.toString(arr)));

		final long start = System.currentTimeMillis();
		final int randomIndex = new Random().nextInt(size);
		final int searchedIndex = A_BinarySearch.search(arr, arr[randomIndex]);
		System.out.println(MessageFormat.format("随机索引：{0}，查询到的索引：{1}", randomIndex, searchedIndex));
		final long end = System.currentTimeMillis();

		//            80000   | 8000000
		// 二分法查询耗时：  25ms   |  28ms
		// 插值查询耗时：    24ms   |  27ms
		System.out.println(MessageFormat.format("查询耗时：{0}ms", end - start));
	}

}
