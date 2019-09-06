package trees;

class Node<E> {
	// no access modifier -- access is "package" -- only methods of classes
	// in this package have access
	Node<E> parent;
	Node<E> left;
	Node<E> right;
	E data;
	int height;
	
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

		int lHeight = -1;
		int rHeight = -1;
		if(left == null && right == null)
			height = 0;
		if (left!= null)
			lHeight = left.height;
		if(right != null)
			rHeight = right.height;
		height = Math.max(lHeight, rHeight) + 1;
	}
	
	// nothing else for now.  We will keep this structure private
}