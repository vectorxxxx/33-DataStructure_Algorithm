package xyz.funnyboy.b_algorithm.a_recursion.a_labyrinth.v2;

/**
 * @author VectorX
 * @version V1.0
 * @description
 * @date 2025-01-21 16:16:28
 */
public enum LabyrinthEnum
{
	WAY(0, "路", " "),
	WALL(111, "墙", "🧱"),
	BARRIER(222, "障碍物", "🚧"),
	MARK(2, "标记", "🐾"),
	TRACE(3, "回溯", "👣"),
	START(-1, "起点", "🧿"),
	END(-2, "终点", "🚩");

	private final int code;
	private final String desc;

	private final String symbol;

	LabyrinthEnum(int code, String desc, String symbol) {
		this.code = code;
		this.desc = desc;
		this.symbol = symbol;
	}

	public int getCode() {
		return code;
	}

	public String getDesc() {
		return desc;
	}

	public String getSymbol() {
		return symbol;
	}

	public static String getSymbol(int code) {
		for (LabyrinthEnum value : values()) {
			if (value.code == code) {
				return value.symbol;
			}
		}
		return " ";
	}
}
