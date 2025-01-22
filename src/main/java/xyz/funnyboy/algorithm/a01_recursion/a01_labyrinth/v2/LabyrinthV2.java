package xyz.funnyboy.algorithm.a01_recursion.a01_labyrinth.v2;

import java.util.Arrays;
import java.util.Random;

/**
 * @author VectorX
 * @version V1.0
 * @description
 * @date 2025-01-21 15:17:41
 */
public class LabyrinthV2
{
	private final int row;
	private final int col;
	private final int[][] maze;
	// 起点
	private int startX;
	private int startY;

	/**
	 * 初始化迷宫
	 *
	 * @param row 行
	 * @param col 列
	 */
	public LabyrinthV2(int row, int col) {
		if (row < 4 || col < 4) {
			throw new RuntimeException("row or col must be greater than 4");
		}
		this.row = row;
		this.col = col;
		this.maze = new int[row][col];
		buildWall();
	}

	/**
	 * 构建墙
	 */
	private void buildWall() {
		for (int x = 0; x < col; x++) {
			maze[0][x] = LabyrinthEnum.WALL.getCode();
			maze[row - 1][x] = LabyrinthEnum.WALL.getCode();
		}
		for (int y = 0; y < row; y++) {
			maze[y][0] = LabyrinthEnum.WALL.getCode();
			maze[y][col - 1] = LabyrinthEnum.WALL.getCode();
		}
	}

	/**
	 * 设置起点
	 *
	 * @param x x
	 * @param y y
	 */
	public void setStartPoint(int x, int y) {
		if (maze[y][x] != 0) {
			throw new RuntimeException("起点不能是墙或障碍物");
		}
		startX = x;
		startY = y;
		maze[startY][startX] = LabyrinthEnum.START.getCode();
	}

	/**
	 * 设置终点
	 *
	 * @param x x
	 * @param y y
	 */
	public void setEndPoint(int x, int y) {
		if (maze[y][x] != 0) {
			throw new RuntimeException("终点不能是墙或障碍物");
		}
		maze[y][x] = LabyrinthEnum.END.getCode();
	}

	/**
	 * 随机起点
	 */
	public void randomStartPoint() {
		Random random = new Random();
		boolean flag = false;
		while (!flag) {
			try {
				final int y = random.nextInt(row - 2) + 1;
				final int x = random.nextInt(col - 2) + 1;
				setStartPoint(x, y);
				flag = true;
				System.out.printf("起点设置成功: [%s,%s]\n", x, y);
			}
			catch (Exception e) {
				System.out.println("起点设置失败，正在重新选取起点：" + e.getMessage());
			}
		}
	}

	/**
	 * 随机终点
	 */
	public void randomEndPoint() {
		Random random = new Random();
		boolean flag = false;
		while (!flag) {
			try {
				final int y = random.nextInt(row - 2) + 1;
				final int x = random.nextInt(col - 2) + 1;
				setEndPoint(x, y);
				flag = true;
				System.out.printf("终点设置成功: [%s,%s]\n", x, y);
			}
			catch (Exception e) {
				System.out.println("终点设置失败，正在重新选取终点：" + e.getMessage());
			}
		}
	}

	/**
	 * 随机障碍物
	 *
	 * @param barrierNum 障碍数
	 */
	public void randomObstacle(int barrierNum) {
		Random random = new Random();
		for (int i = 0; i < barrierNum; i++) {
			// 随机障碍物
			final int y = random.nextInt(row - 2) + 1;
			final int x = random.nextInt(col - 2) + 1;
			if (maze[y][x] != 0) {
				i--;
				continue;
			}
			maze[y][x] = LabyrinthEnum.BARRIER.getCode();
		}
	}

	/**
	 * 显示迷宫
	 */
	public void showMaze() {
		for (int i = 0; i < maze.length; i++) {
			for (int j = 0; j < maze[i].length; j++) {
				System.out.printf("%s\t", LabyrinthEnum.getSymbol(maze[i][j]));
			}
			System.out.println();
		}
	}

	/**
	 * 寻道
	 *
	 * @return boolean
	 */
	public boolean seekWay() {
		return seekWay(startX, startY);
	}

	/**
	 * 寻道
	 * <p>
	 * 策略：下右上左
	 *
	 * @param x x
	 * @param y y
	 * @return boolean
	 */
	private boolean seekWay(int x, int y) {
		// 寻到终点
		if (maze[y][x] == LabyrinthEnum.END.getCode()) {
			return true;
		}

		// 死路一条
		if (!Arrays
				.asList(LabyrinthEnum.START.getCode(), LabyrinthEnum.END.getCode(), LabyrinthEnum.WAY.getCode())
				.contains(maze[y][x])) {
			return false;
		}

		// 标记
		if (maze[y][x] != LabyrinthEnum.START.getCode()) {
			maze[y][x] = LabyrinthEnum.MARK.getCode();
		}

		// 下
		if (seekWay(x, y + 1)) {
			return true;
		}
		// 右
		if (seekWay(x + 1, y)) {
			return true;
		}
		// 上
		if (seekWay(x, y - 1)) {
			return true;
		}
		// 左
		if (seekWay(x - 1, y)) {
			return true;
		}

		// 来时路
		if (maze[y][x] != LabyrinthEnum.START.getCode()) {
			maze[y][x] = LabyrinthEnum.TRACE.getCode();
		}
		return false;
	}
}
