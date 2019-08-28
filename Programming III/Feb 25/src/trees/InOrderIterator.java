package trees;

public class InOrderIterator<E> extends TreeIterator<E>{
    private Node<E> cur;
    private Node<E> root;

    public InOrderIterator(Node<E> root){
        super(root);
    }

    protected void reset(){
        cur = root;
        while(cur.left != null)
            cur = cur.left;
    }

    protected void advance(){
        if(cur == null){
            return;
        }

        if(cur.right != null){
            cur = cur.right;
            while(cur.left != null)
                cur = cur.left;
        }
        else{
            while(cur.parent != null && cur.parent.right == cur)
                cur = cur.parent;

            cur = cur.parent;
        }
    }
}
