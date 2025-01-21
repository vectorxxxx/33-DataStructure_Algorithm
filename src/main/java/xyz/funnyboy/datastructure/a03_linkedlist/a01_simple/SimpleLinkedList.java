package xyz.funnyboy.datastructure.a03_linkedlist.a01_simple;

/**
 * @author VectorX
 * @version V1.0
 * @description
 * @date 2025-01-16 17:00:33
 */
public class SimpleLinkedList
{
	private final int capacity;
	private int size;
	private final HeroNode head;
	private HeroNode tail;

	public SimpleLinkedList() {
		this(Integer.MAX_VALUE);
	}

	public SimpleLinkedList(int capacity) {
		this.capacity = capacity;
		this.size = 0;
		this.head = new HeroNode(-1, "", "");
		this.tail = head;
	}

	public HeroNode getHead() {
		return head;
	}

	public HeroNode getTail() {
		return tail;
	}

	public int size() {
		return size;
	}

	public boolean isEmpty() {
		return size == 0;
	}

	public boolean isFull() {
		return size == capacity;
	}

	/**
	 * 头部添加节点
	 *
	 * @param heroNode hero 节点
	 */
	public void addHead(HeroNode heroNode) {
		add(0, heroNode);
	}

	/**
	 * 尾部添加节点
	 *
	 * @param heroNode hero 节点
	 */
	public void addTail(HeroNode heroNode) {
		add(size, heroNode);
		this.tail = heroNode;
	}

	/**
	 * 插入节点
	 *
	 * @param index    指数
	 * @param heroNode hero 节点
	 */
	public void add(int index, HeroNode heroNode) {
		if (isFull()) {
			throw new RuntimeException("链表已满");
		}
		if (index < 0 || index > size) {
			throw new RuntimeException("index不合法");
		}

		HeroNode cur = head;
		for (int i = 0; i < index; i++) {
			cur = cur.next();
		}
		HeroNode next = cur.next();
		cur.next(heroNode);
		heroNode.next(next);
		this.size++;
	}

	/**
	 * 移除头部节点
	 */
	public int removeFirst() {
		return remove(0);
	}

	/**
	 * 移除尾部节点
	 */
	public int removeLast() {
		return remove(size - 1);
	}

	/**
	 * 移除节点
	 *
	 * @param index 指数
	 */
	public int remove(int index) {
		if (isEmpty()) {
			throw new RuntimeException("链表已空");
		}
		if (index < 0 || index >= size) {
			throw new RuntimeException("index不合法");
		}

		HeroNode cur = head;
		for (int i = 0; i < index; i++) {
			cur = cur.next();
		}
		HeroNode next = cur
				.next()
				.next();
		if (next != null) {
			cur
					.next()
					.next(null);
		}
		else if (index == size - 1) {
			this.tail = cur;
		}
		cur.next(next);
		this.size--;
		return cur.getNo();
	}

	/**
	 * 更新节点
	 *
	 * @param heroNode hero 节点
	 */
	public void update(HeroNode heroNode) {
		if (isEmpty()) {
			throw new RuntimeException("链表为空");
		}

		HeroNode cur = head.next();
		for (int i = 0; i < size; i++) {
			if (cur.getNo() == heroNode.getNo()) {
				cur.setName(heroNode.getName());
				cur.setNickname(heroNode.getNickname());
				return;
			}
			cur = cur.next();
		}
	}

	/**
	 * 显示节点
	 */
	public void view() {
		if (isEmpty()) {
			System.out.println("链表为空");
			return;
		}

		HeroNode cur = head.next();
		for (int i = 0; i < size; i++) {
			System.out.printf("linkedlist[%d]=%s\n", i, cur);
			cur = cur.next();
		}
	}

	public HeroNode view(int no) {
		if (isEmpty()) {
			return null;
		}

		HeroNode cur = head.next();
		for (int i = 0; i < size; i++) {
			if (cur.getNo() == no) {
				return cur;
			}
			cur = cur.next();
		}
		return null;
	}
}
