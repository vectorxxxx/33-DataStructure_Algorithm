package xyz.funnyboy.a_datastructure.c_linkedlist.b_double2;

/**
 * @author VectorX
 * @version V1.0
 * @description
 * @date 2025-01-16 17:00:33
 */
public class DoubleLinkedList
{
	private final int capacity;
	private int size;
	private final HeroNode head;
	private HeroNode tail;

	public DoubleLinkedList() {
		this(Integer.MAX_VALUE);
	}

	public DoubleLinkedList(int capacity) {
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
		if (isFull()) {
			throw new RuntimeException("链表已满");
		}

		heroNode.prev(head);
		heroNode.next(head.next());
		head
				.next()
				.prev(heroNode);
		head.next(heroNode);
		this.size++;
	}

	/**
	 * 尾部添加节点
	 *
	 * @param heroNode hero 节点
	 */
	public void addTail(HeroNode heroNode) {
		if (isFull()) {
			throw new RuntimeException("链表已满");
		}

		heroNode.prev(tail);
		tail.next(heroNode);
		tail = heroNode;
		this.size++;
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

		HeroNode cur;
		if (index <= size / 2) {
			cur = head;
			for (int i = 0; i < index; i++) {
				cur = cur.next();
			}
		}
		else {
			cur = tail;
			for (int i = size - 1; i > index; i--) {
				cur = cur.prev();
			}
		}
		HeroNode next = cur.next();
		heroNode.prev(cur);
		heroNode.next(next);
		if (cur.next() != null) {
			next.prev(heroNode);
		}
		cur.next(heroNode);
		this.tail = heroNode;
		this.size++;
	}

	/**
	 * 移除头部节点
	 */
	public void removeFirst() {
		if (isEmpty()) {
			throw new RuntimeException("链表已空");
		}

		HeroNode cur = head.next();
		HeroNode next = cur.next();
		head.next(next);
		cur.prev(null);
		cur.next(null);
		if (next != null) {
			next.prev(head);
		}
		else {
			this.tail = head;
		}
		this.size--;
	}

	/**
	 * 移除尾部节点
	 */
	public void removeLast() {
		if (isEmpty()) {
			throw new RuntimeException("链表已空");
		}

		tail = tail.prev();
		tail
				.next()
				.prev(null);
		tail.next(null);
		this.size--;
	}

	/**
	 * 移除节点
	 *
	 * @param no no
	 */
	public int remove(int no) {
		if (isEmpty()) {
			throw new RuntimeException("链表已空");
		}

		HeroNode cur;
		cur = head;
		int index = -1;
		for (int i = 0; i < size; i++) {
			cur = cur.next();
			if (cur.getNo() == no) {
				index = i;
				break;
			}
		}
		if (index == -1) {
			throw new RuntimeException("节点不存在");
		}

		HeroNode prev = cur.prev();
		HeroNode next = cur.next();
		prev.next(next);
		cur.prev(null);
		cur.next(null);
		if (next != null) {
			next.prev(prev);
		}
		else {
			this.tail = prev;
		}
		this.size--;
		return index;
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
