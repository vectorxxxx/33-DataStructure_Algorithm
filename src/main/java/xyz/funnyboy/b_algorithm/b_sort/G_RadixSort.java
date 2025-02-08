package xyz.funnyboy.b_algorithm.b_sort;

/**
 * @author VectorX
 * @version V1.0
 * @description 基数排序（桶排序）
 * @date 2025-02-08 16:05:42
 */
public class G_RadixSort
{

	private static final int BUCKET_NUM = 10;

	public static void sort(int[] arr) {
		int count = 0;

		// 获取最大值位数
		int max = arr[0];
		for (int num : arr) {
			if (num > max) {
				max = num;
			}
		}
		int maxLength = (max + "").length();

		// 初始化桶、桶中元素个数
		int[][] bucket = new int[BUCKET_NUM][arr.length];
		int[] bucketElementCounts = new int[BUCKET_NUM];

		// 最大值有几位就循环几趟
		for (int i = 0, n = 1; i < maxLength; i++, n *= 10) {
			// 遍历数组，第几趟就看第几位数字，数字是几就存入第几个桶
			for (int num : arr) {
				final int digitElement = num / n % 10;
				bucket[digitElement][bucketElementCounts[digitElement]++] = num;
			}
			// 遍历桶，把桶中的元素依次放回原数组
			int index = 0;
			for (int j = 0; j < BUCKET_NUM; j++) {
				if (bucketElementCounts[j] != 0) {
					for (int k = 0; k < bucketElementCounts[j]; k++) {
						arr[index++] = bucket[j][k];
					}
					bucketElementCounts[j] = 0;
				}
			}
			// System.out.println(MessageFormat.format("第{0}趟排序结果：{1}", ++count, Arrays.toString(arr)));
		}
	}
}
