package xyz.funnyboy.algorithm.a01_recursion.labyrinth.v2;

/**
 * @author VectorX
 * @version V1.0
 * @description
 * @date 2025-01-21 16:16:28
 */
public enum LabyrinthEnum
{
	WAY(0, "路"),
	WALL(111, "墙"),
	BARRIER(111, "障碍物"),
	MARK(2, "标记"),
	TRACE(3, "回溯"),
	START(-1, "起点"),
	END(-2, "终点");

	private final int code;
	private final String desc;

	LabyrinthEnum(int code, String desc) {
		this.code = code;
		this.desc = desc;
	}

	public int getCode() {
		return code;
	}

	public String getDesc() {
		return desc;
	}

}
