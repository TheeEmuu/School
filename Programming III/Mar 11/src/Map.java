import lvc.cds.trees.SearchTree;
import lvc.cds.trees.TreeIterator;
import sun.reflect.generics.tree.Tree;

public class Map<K extends Comparable<K>, V> {
    SearchTree<Association<K, V>> map = new SearchTree<Association<K, V>>();

    public int size(){
        return map.size();
    }

    public boolean isEmpty(){
        return size() == 0;
    }

    public boolean containsKey(K k){
        TreeIterator<Association<K, V>> itt = map.iterator();

        while(itt.hasNext()){
            if(itt.next().getKey().equals(k))
                return true;
        }

        return false;
    }

    public boolean containsValue(V v){
        return map.contains()
    }

    public V get(K k){

    }

    public void add(K key, V value){
        map.insert(new Association<>(key, value));
    }


}

