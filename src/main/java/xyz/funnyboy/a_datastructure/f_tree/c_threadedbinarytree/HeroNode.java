package xyz.funnyboy.a_datastructure.f_tree.c_threadedbinarytree;

/**
 * @author VectorX
 * @version V1.0
 * @description
 * @date 2025-02-10 15:50:50
 */
public class HeroNode
{
	private int no;
	private String name;
	private HeroNode left;
	private HeroNode right;

	//1. 如果leftType == 0 表示指向的是左子树, 如果 1 则表示指向前驱结点
	private int leftType;
	//2. 如果rightType == 0 表示指向是右子树, 如果 1 则表示指向后继结点
	private int rightType;

	public HeroNode(int no, String name) {
		this.no = no;
		this.name = name;
	}

	public int getNo() {
		return no;
	}

	public void setNo(int no) {
		this.no = no;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public HeroNode left() {
		return left;
	}

	public void left(HeroNode left) {
		this.left = left;
	}

	public HeroNode right() {
		return right;
	}

	public void right(HeroNode right) {
		this.right = right;
	}

	public int getLeftType() {
		return leftType;
	}

	public void setLeftType(int leftType) {
		this.leftType = leftType;
	}

	public int getRightType() {
		return rightType;
	}

	public void setRightType(int rightType) {
		this.rightType = rightType;
	}

	@Override
	public String toString() {
		return "HeroNode{" + "no=" + no + ", name='" + name + '\'' + '}';
	}

	public void delNode(int no) {
		if (this.left != null && this.left.no == no) {
			this.left = null;
			return;
		}
		if (this.right != null && this.right.no == no) {
			this.right = null;
			return;
		}
		if (this.left != null) {
			this.left.delNode(no);
		}
		if (this.right != null) {
			this.right.delNode(no);
		}
	}

	/**
	 * 前序遍历（DLR）
	 */
	public void preOrderTraversal() {
		System.out.println(this);
		if (this.left != null) {
			this.left.preOrderTraversal();
		}
		if (this.right != null) {
			this.right.preOrderTraversal();
		}
	}

	/**
	 * 中序遍历（LDR）
	 */
	public void inOrderTraversal() {
		if (this.left != null) {
			this.left.inOrderTraversal();
		}
		System.out.println(this);
		if (this.right != null) {
			this.right.inOrderTraversal();
		}
	}

	/**
	 * 后序遍历（LRD）
	 */
	public void postOrderTraversal() {
		if (this.left != null) {
			this.left.postOrderTraversal();
		}
		if (this.right != null) {
			this.right.postOrderTraversal();
		}
		System.out.println(this);
	}

	/**
	 * 前序查找
	 *
	 * @param no no
	 * @return {@link HeroNode }
	 */
	public HeroNode preOrderSearch(int no) {
		System.out.println("进入前序查找");
		if (this.no == no) {
			return this;
		}

		HeroNode resNode = null;
		if (this.left != null) {
			resNode = this.left.preOrderSearch(no);
		}
		if (resNode != null) {
			return resNode;
		}

		if (this.right != null) {
			resNode = this.right.preOrderSearch(no);
		}
		return resNode;
	}

	/**
	 * 中序查找
	 *
	 * @param no no
	 * @return {@link HeroNode }
	 */
	public HeroNode inOrderSearch(int no) {
		HeroNode resNode = null;
		if (this.left != null) {
			resNode = this.left.inOrderSearch(no);
		}
		if (resNode != null) {
			return resNode;
		}

		System.out.println("进入中序查找");
		if (this.no == no) {
			return this;
		}

		if (this.right != null) {
			resNode = this.right.inOrderSearch(no);
		}
		return resNode;
	}

	/**
	 * 后序查找
	 *
	 * @param no no
	 * @return {@link HeroNode }
	 */
	public HeroNode postOrderSearch(int no) {
		HeroNode resNode = null;
		if (this.left != null) {
			resNode = this.left.postOrderSearch(no);
		}
		if (resNode != null) {
			return resNode;
		}

		if (this.right != null) {
			resNode = this.right.postOrderSearch(no);
		}
		if (resNode != null) {
			return resNode;
		}

		System.out.println("进入后序查找");
		if (this.no == no) {
			return this;
		}
		return resNode;
	}
}
