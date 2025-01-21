package xyz.funnyboy.algorithm.a01_recursion.labyrinth.v1;

/**
 * @author VectorX
 * @version V1.0
 * @description
 * @date 2025-01-21 15:47:12
 */
public class LabyrinthV1Demo
{
	public static void main(String[] args) {
		final int[][] maze = LabyrinthV1.initMaze();
		System.out.println("原始迷宫：=====================");
		LabyrinthV1.showMaze(maze);

		System.out.println("迷宫寻路：=====================");
		// if (LabyrinthV1.seekWay(maze, 1, 1)) {
		if (LabyrinthV1.seekWay2(maze, 1, 1)) {
			System.out.println("找到迷宫出口：");
			LabyrinthV1.showMaze(maze);
		}
		else {
			System.out.println("迷宫没有解");
		}
	}
}
