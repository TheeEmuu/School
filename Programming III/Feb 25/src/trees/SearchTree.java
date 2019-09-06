package trees;

public class SearchTree<E extends Comparable<E>> extends BinaryTree<E> {
    @Override
    public void insert(E value) {
        if (getRoot() == null)
            setRoot(new Node<E>(value));
        else {
            insert(value, getRoot());
        }
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

        cur.computeHeight();
    }

    @Override
    public boolean contains(E value) {
        return contains(value, getRoot());
    }

    private boolean contains(E value, Node<E> cur) {
        if(cur == null)
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
        return find(value, getRoot());
    }

    private TreeIterator<E> find(E value, Node<E> root) {
        return null;
    }

    @Override
    public E remove(E value) {
        return remove(value, getRoot());
    }

    private E remove(E value, Node<E> root) {
        return null;
    }

    @Override
    public void remove(TreeIterator<E> iter) {
        // we know exactly where the node to remove is. How do we go faster than
        // the other remove?
    }

    @Override
    public TreeIterator<E> iterator() {
        // What kind of iterator do we need?
        return new InOrderIterator<E>(leftmost());
    }

    private Node<E> leftmost() {
        Node<E> cur = getRoot();
        if (cur == null)
            return null;
        while (cur.left != null)
            cur = cur.left;
        return cur;
    }

}
