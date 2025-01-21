package xyz.funnyboy.algorithm.a01_recursion.labyrinth.v1;

/**
 * @author VectorX
 * @version V1.0
 * @description
 * @date 2025-01-21 15:17:41
 */
public class LabyrinthV1
{

	/**
	 * 初始化迷宫
	 *
	 * @return {@link int[][] }
	 */
	public static int[][] initMaze() {
		// 初始化地图
		int[][] maze = new int[8][7];

		// 墙
		for (int x = 0; x < 7; x++) {
			maze[0][x] = 1;
			maze[7][x] = 1;
		}
		for (int y = 0; y < 8; y++) {
			maze[y][0] = 1;
			maze[y][6] = 1;
		}

		// 障碍物
		maze[3][1] = 1;
		maze[3][2] = 1;

		return maze;
	}

	/**
	 * 显示迷宫
	 *
	 * @param maze 迷宫
	 */
	public static void showMaze(int[][] maze) {
		for (int[] row : maze) {
			for (int item : row) {
				System.out.printf("%s\t", item);
			}
			System.out.println();
		}
	}

	/**
	 * 寻道
	 * <p>
	 * 策略：下右上左
	 *
	 * @param maze 迷宫
	 * @param x    x
	 * @param y    y
	 * @return boolean
	 */
	public static boolean seekWay(int[][] maze, int x, int y) {
		// 寻到终点
		if (maze[6][5] == 2) {
			return true;
		}

		// 死路
		if (maze[y][x] != 0) {
			return false;
		}

		// 标记
		maze[y][x] = 2;

		// 下
		if (seekWay(maze, x, y + 1)) {
			return true;
		}
		// 右
		if (seekWay(maze, x + 1, y)) {
			return true;
		}
		// 上
		if (seekWay(maze, x, y - 1)) {
			return true;
		}
		// 左
		if (seekWay(maze, x - 1, y)) {
			return true;
		}

		// 来时路
		maze[y][x] = 3;

		return false;
	}

	/**
	 * 寻道2
	 * <p>
	 * 策略：上右下左
	 *
	 * @param maze 迷宫
	 * @param x    x
	 * @param y    y
	 * @return boolean
	 */
	public static boolean seekWay2(int[][] maze, int x, int y) {
		// 寻到终点
		if (maze[6][5] == 2) {
			return true;
		}

		// 死路
		if (maze[y][x] != 0) {
			return false;
		}

		// 标记
		maze[y][x] = 2;

		// 上
		if (seekWay2(maze, x, y - 1)) {
			return true;
		}
		// 右
		if (seekWay2(maze, x + 1, y)) {
			return true;
		}
		// 下
		if (seekWay2(maze, x, y + 1)) {
			return true;
		}
		// 左
		if (seekWay2(maze, x - 1, y)) {
			return true;
		}

		// 来时路
		maze[y][x] = 3;

		return false;
	}
}
