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

        checkAVLCondition(cur);
    }

    private void checkAVLCondition(Node<E> cur) {
        //Is the tree out of balance
        if(Math.abs(height(cur.left) - height(cur.right)) > 1){
            //Is the left subtree taller than the right
            if(height(cur.left) > height(cur.right)){
                //Is LSubtree's left subtree taller than its right subtree
                if(height(cur.left.left) > height(cur.left.right))
                    leftLeftRotate(cur);
                else
                    leftRightRotation(cur);
            }
            else{
                //Is RSubtree's right subtree taller than its left subtree
                if(height(cur.right.right) > height(cur.right.left))
                    rightRightRotate(cur);
                else
                    rightLeftRotate(cur);
            }
        }
        else
            cur.computeHeight();
    }

    //region Rotations
    private void leftLeftRotate(Node<E> cur) {
        Node<E> L = cur.left;

        cur.left = cur.left.right;
        L.right = cur;

        promoteChild(cur, L);

        fixParent(cur, cur.left);
        fixParent(L, L.right);

        cur.computeHeight();
        L.computeHeight();
    }

    private void leftRightRotation(Node<E> cur) {
        Node<E> L = cur.left;

        cur.left = cur.left.left;
        L.right = cur;

        promoteChild(cur, L);

        fixParent(cur, cur.left);
        fixParent(L, L.right);

        cur.computeHeight();
        L.computeHeight();
    }

    private void rightRightRotate(Node<E> cur) {
        Node<E> R = cur.right;

        cur.right = cur.right.left;
        R.left = cur;

        promoteChild(cur, R);

        fixParent(cur, cur.right);
        fixParent(R, R.left);

        cur.computeHeight();
        R.computeHeight();
    }

    private void rightLeftRotate(Node<E> cur) {
        Node<E> R = cur.right;

        cur.right = cur.right.right;
        R.left = cur;

        promoteChild(cur, R);

        fixParent(cur, cur.right);
        fixParent(R, R.left);

        cur.computeHeight();
        R.computeHeight();
    }
    //endregion

    private void promoteChild(Node<E> cur, Node<E> child) {
        if (cur.parent == null)
            setRoot(child);
        else if (cur.parent.left == cur)
            cur.parent.left = child;
        else
            cur.parent.right = child;
        // fix child's parent pointer
        fixParent(cur.parent, child);
    }

    private void fixParent(Node<E> cur, Node<E> child) {
        if(child != null)
            child.parent = cur;
    }

    private int height(Node<E> n){
        if(n == null)
            return -1;
        return n.height;
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
        return new PreorderTreeIterator<>(leftmost());
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
