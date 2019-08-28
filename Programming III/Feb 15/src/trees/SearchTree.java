package trees;

import java.util.Random;

public class SearchTree<E extends Comparable<E>> extends BinaryTree<E> {

	@Override
	public void insert(E value) {
		insert(value, getRoot());
	}

	private void insert(E value, Node<E> cur){
		// presume cur != null
		int cmp = value.compareTo(cur.data);
		if(cmp < 0){
			//go left
			if(cur.left == null) {
				cur.left = new Node<E>(value, cur);
				return;
			}
			else
				insert(value, cur.left);
		}

		else{
			//go right
			if(cur.right == null){
				cur.right = new Node<>(value, cur);
				return;
			}
			else
				insert(value, cur.right);
		}
	}

	@Override
	public boolean contains(E value) {
		return contains(value, getRoot());
	}

	// is value in the subtree rooted at cur?
	private boolean contains(E value, Node<E> cur) {
		if(cur.data == null)
			return false;

		if(cur.data.equals(value))
			return true;

		int cmp = value.compareTo(cur.data);
		if(cmp < 0){
			return contains(value, cur.left);
		}
		else{
			return contains(value, cur.right);
		}
	}

	@Override
	public TreeIterator<E> find(E value) {
		// TODO Auto-generated method stub

		return null;
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

