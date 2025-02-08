package xyz.funnyboy.b_algorithm.a_recursion.a_labyrinth.v2;

/**
 * @author VectorX
 * @version V1.0
 * @description
 * @date 2025-01-21 15:47:12
 */
public class LabyrinthV2Demo
{
	public static void main(String[] args) {
		final LabyrinthV2 labyrinthV2 = new LabyrinthV2(10, 10);
		// labyrinthV2.setStartPoint(1, 1);
		// labyrinthV2.setEndPoint(5, 7);
		labyrinthV2.randomObstacle(20);
		labyrinthV2.randomStartPoint();
		labyrinthV2.randomEndPoint();
		System.out.println("原始迷宫：=============================");
		// 🧱	🧱	🧱	🧱	🧱	🧱	🧱	🧱	🧱	🧱
		// 🧱	 	 	 	 	 	 	 	🚧	🧱
		// 🧱	 	🚧	 	🚧	 	🚧	🚧	🚧	🧱
		// 🧱	 	🚧	 	 	 	 	🚧	 	🧱
		// 🧱	🚧	 	 	 	 	 	🚧	 	🧱
		// 🧱	🚧	 	 	 	 	 	 	🚧	🧱
		// 🧱	 	 	🚧	🚧	 	 	 	 	🧱
		// 🧱	🚧	🚩	🚧	🚧	 	🧿	🚧	 	🧱
		// 🧱	 	🚧	 	 	 	 	🚧	 	🧱
		// 🧱	🧱	🧱	🧱	🧱	🧱	🧱	🧱	🧱	🧱
		labyrinthV2.showMaze();

		System.out.println("迷宫寻路：=============================");
		if (labyrinthV2.seekWay()) {
			// 🧱	🧱	🧱	🧱	🧱	🧱	🧱	🧱	🧱	🧱
			// 🧱	👣	👣	👣	👣	👣	👣	👣	🚧	🧱
			// 🧱	👣	🚧	👣	🚧	👣	🚧	🚧	🚧	🧱
			// 🧱	👣	🚧	👣	👣	🐾	🐾	🚧	 	🧱
			// 🧱	🚧	🐾	🐾	🐾	🐾	🐾	🚧	 	🧱
			// 🧱	🚧	🐾	🐾	🐾	🐾	🐾	👣	🚧	🧱
			// 🧱	 	🐾	🚧	🚧	🐾	🐾	👣	👣	🧱
			// 🧱	🚧	🚩	🚧	🚧	🐾	🧿	🚧	👣	🧱
			// 🧱	 	🚧	👣	👣	👣	🐾	🚧	👣	🧱
			// 🧱	🧱	🧱	🧱	🧱	🧱	🧱	🧱	🧱	🧱
			System.out.println("找到迷宫出口：");
			labyrinthV2.showMaze();
		}
		else {
			System.out.println("迷宫没有解");
		}
	}
}
