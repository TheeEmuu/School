package trees;

class Node<E> {
	// no access modifier -- access is "package" -- only methods of classes
	// in this package have access
	Node<E> parent;
	Node<E> left;
	Node<E> right;
	E data;
	int height;
	int depth;
	
	Node(E data) {
		this(data, null, null, null);
	}
	
	Node(E data, Node<E> parent) {
		this(data, parent, null, null);
	}
	
	Node(E data, Node<E> parent, Node<E> left, Node<E> right) {
		this.data = data;
		this.parent = parent;
		this.left = left;
		this.right = right;
		computeHeight();
		computeDepth();
	}

	// NB: assumes the heights of our children are correct. Only call when
	// that is known to be true.
	void computeHeight() {
		int lHeight = -1;
		int rHeight = -1;
		if (left != null)
			lHeight = left.height;
		if (right != null)
			rHeight = right.height;
		height = Math.max(lHeight, rHeight) + 1;
	}

	void computeDepth(){
		if(parent == null)
			depth = 0;
		else
			depth = parent.depth + 1;
	}

	boolean isLeaf() {
		return (left == null && right == null);
	}

	boolean isFull() {
		return (left != null && right != null);
	}

	// nothing else for now.  We will keep this structure private
}