package xyz.funnyboy.a03_linkedlist.a02_double2;

/**
 * @author VectorX
 * @version V1.0
 * @description
 * @date 2025-01-16 16:59:28
 */
public class HeroNode
{
	private final int no;
	private String name;
	private String nickname;
	private HeroNode next;
	private HeroNode prev;

	public HeroNode(int no, String name, String nickname) {
		this.no = no;
		this.name = name;
		this.nickname = nickname;
	}

	public HeroNode next() {
		return next;
	}

	public void next(HeroNode next) {
		this.next = next;
	}

	public HeroNode prev() {
		return prev;
	}

	public void prev(HeroNode prev) {
		this.prev = prev;
	}

	public int getNo() {
		return no;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public void setNickname(String nickname) {
		this.nickname = nickname;
	}

	public String getNickname() {
		return nickname;
	}

	@Override
	public String toString() {
		return "HeroNode{" + "no=" + no + ", name='" + name + '\'' + ", nickname='" + nickname + '\'' + '}';
	}
}
