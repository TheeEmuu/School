package lvc.cds.trees;

import java.util.Random;

public class RandomTree<E extends Comparable<E>> extends BinaryTree<E> {

	@Override
	public void insert(E value) {
		// randomly walk down the tree until we find a leaf position, and put the value there.
		Random r = new Random();
		
		Node<E> root = getRoot();
		
		if (root == null) {
			setRoot(new Node<E>(value));
			return;
		}
		
		while (true) {
			boolean goLeft = r.nextBoolean();
		
			if (goLeft) {
				if (root.left == null) {
					root.left = new Node<E>(value);
					root.left.parent = root;
					break;
				}
				else 
					root = root.left;
			}
			else {
				if (root.right == null) {
					root.right = new Node<E>(value);
					root.right.parent = root;
					break;
				}
				else 
					root = root.right;				
			}
		}
	}

	@Override
	public boolean contains(E value) {
		return contains(value, getRoot());
	}

	// is value in the subtree rooted at cur?
	private boolean contains(E value, Node<E> cur) {
		if (cur == null)
			return false;
		if (cur.data.compareTo(value) == 0)
			return true;
		if (contains(value, cur.left))
			return true;
		return contains(value, cur.right);
	}

	@Override
	public TreeIterator<E> find(E value) {
		TreeIterator<E> iter = find(value, getRoot());

		return (iter == null) ?
			new PreorderTreeIterator<>(null) : iter;
	}

	private TreeIterator<E> find(E value, Node<E> cur) {
		if (cur == null)
			return null;

		if (cur.data.compareTo(value) == 0)
			return new PreorderTreeIterator<>(cur);

		TreeIterator<E> leftIter = find(value, cur.left);
		if (leftIter != null)
			return leftIter;

		return find(value, cur.right);
	}

	@Override
	public TreeIterator<E> iterator() {
		// create an iterator pointing at the first element in the tree.
		return new PreorderTreeIterator<E>(getRoot());
	}

	@Override
	public E remove(E value) {
		// TODO Auto-generated method stub
		return null;
		
	}

	@Override
	public void remove(TreeIterator<E> iter) {
		// TODO Auto-generated method stub
		
	}
}
