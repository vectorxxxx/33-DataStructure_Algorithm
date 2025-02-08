package xyz.funnyboy.a_datastructure.a_sparsearr;

/**
 * @author VectorX
 * @version V1.0
 * @description
 * @date 2025-01-15 11:16:15
 */
public class SparseArrDemo
{
	public static void main(String[] args) {
		// 原始数组
		int[][] rawArr = new int[11][11];
		rawArr[1][2] = 1;
		rawArr[2][3] = 2;
		rawArr[4][5] = 2;
		for (int[] ints : rawArr) {
			for (int anInt : ints) {
				System.out.printf("%d\t", anInt);
			}
			System.out.println();
		}
		System.out.println("=====================================");

		// 统计非零元素个数
		int sum = 0;
		for (int[] ints : rawArr) {
			for (int anInt : ints) {
				if (anInt != 0) {
					sum++;
				}
			}
		}

		// 创建稀疏数组
		int[][] sparseArr = new int[sum + 1][3];
		// 首行存数组大小
		sparseArr[0][0] = rawArr.length; // row
		sparseArr[0][1] = rawArr[0].length; // col
		sparseArr[0][2] = sum;  // 非零元素个数
		int row = 0;
		for (int i = 0; i < rawArr.length; i++) {
			for (int j = 0; j < rawArr[i].length; j++) {
				if (rawArr[i][j] == 0) {
					continue;
				}
				row++;
				sparseArr[row][0] = i;
				sparseArr[row][1] = j;
				sparseArr[row][2] = rawArr[i][j];
			}
		}
		// 打印稀疏数组
		for (int[] ints : sparseArr) {
			for (int anInt : ints) {
				System.out.printf("%d\t", anInt);
			}
			System.out.println();
		}
	}
}
