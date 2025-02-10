package xyz.funnyboy.a_datastructure.e_hashtab;

/**
 * @author VectorX
 * @version V1.0
 * @description
 * @date 2025-02-10 14:47:00
 */
public class Emp
{
	private int id;
	private String name;
	private Emp next;

	public Emp(int id, String name) {
		this.id = id;
		this.name = name;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Emp next() {
		return next;
	}

	public void next(Emp next) {
		this.next = next;
	}
}
