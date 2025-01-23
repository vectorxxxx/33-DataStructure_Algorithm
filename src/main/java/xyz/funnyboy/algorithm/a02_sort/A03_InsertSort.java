package xyz.funnyboy.algorithm.a02_sort;

/**
 * @author VectorX
 * @version V1.0
 * @description 插入排序
 * @date 2025-01-22 17:31:18
 */
public class A03_InsertSort
{
	public static void sort(int[] arr) {
		for (int i = 1; i < arr.length; i++) {
			int insertIndex = i - 1;
			int insertValue = arr[i];
			while (insertIndex >= 0 && insertValue < arr[insertIndex]) {
				arr[insertIndex + 1] = arr[insertIndex];
				insertIndex--;
			}
			if (insertIndex + 1 != i) {
				arr[insertIndex + 1] = insertValue;
			}
			// System.out.println(MessageFormat.format("第{0}轮排序：{1}", i, Arrays.toString(arr)));
		}
	}
}
