package lvc.cds.trees;

public class InOrderIterator<E> extends TreeIterator<E>{
    private Node<E> cur;

    public InOrderIterator(Node<E> cur){
        super(cur);
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
