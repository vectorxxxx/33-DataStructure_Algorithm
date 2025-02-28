package xyz.funnyboy.b_algorithm.d_dac;

/**
 * @author VectorX
 * @version V1.0
 * @description
 * @date 2025-02-28 15:53:18
 */
public class HanoiTower
{
	public static void main(String[] args) {
		long start = System.currentTimeMillis();
		// hanoiTower(3, 'A', 'B', 'C');
		// hanoiTower(10, 'A', 'B', 'C');
		// hanoiTower(20, 'A', 'B', 'C'); // 2ms
		hanoiTower(30, 'A', 'B', 'C'); // 1029ms
		// hanoiTower(40, 'A', 'B', 'C'); // ...ms
		long end = System.currentTimeMillis();
		System.out.println("耗时：" + (end - start) + "ms");
	}

	/**
	 * 汉诺塔
	 * <p>
	 * 总是可以把n个盘子，分成两步，先把n-1个盘子从a借助于c移动到b，再把最后一个盘子从a移动到c
	 *
	 * @param n 盘子个数
	 * @param a a塔
	 * @param b b塔
	 * @param c c塔
	 */
	public static void hanoiTower(int n, char a, char b, char c) {
		if (n == 1) {
			// 把最后一个盘子从a移动到c，即 a—→c
			// System.out.println("Move " + n + " from " + a + " to " + c);
		}
		else {
			// 把【n-1个盘子】从a借助于c移动到b，即 a—→c—→b
			hanoiTower(n - 1, a, c, b);
			// System.out.println("Move " + n + " from " + a + " to " + c);
			// 把【n-1个盘子】从b借助于a移动到c，即 b—→a—→c
			hanoiTower(n - 1, b, a, c);
		}
	}
}
