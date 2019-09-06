import java.util.Vector;

public class Map<K,V> {
    static final String RESERVED = "RESERVED";
    Vector<HashAssociation<K, V>> table;
    int count 0;

    public Map(){
        table = new Vector<>(50);
    }

    public void put(K k, V v){
        HashAssociation<K, V> pair = new HashAssociation<>(k, v);

        int location = locate(pair.getKey());

        table.insertElementAt(pair, location);

        count++;
    }

    private int locate(K key){
        // compute an initial hash code
        int hash = Math.abs(key.hashCode() % table.size());
        // keep track of first unused slot, in case we need it
        int reservedSlot = -1;
        boolean foundReserved = false;
        while (table.get(hash) != null)
        {
            if (table.get(hash).reserved()) {
                // remember reserved slot if we fail to locate value
                if (!foundReserved) {
                    reservedSlot = hash;
                    foundReserved = true;
                }
            } else {
                // value located? return the index in table
                if (key.equals(table.get(hash).getKey())) return hash;
            }
            // linear probing; other methods would change this line:
            hash = (1+hash)%table.size();
            }
        // return first empty slot we encountered
        if (!foundReserved) return hash;
        else return reservedSlot;
    }


    public V remove(K k){
        int location = locate(k);

        if( table.get(location) == null || table.get(location).reserved()){
            return null;
        }

        count--;

        V oldValue = table.get(location).getValue();
        table.get(location).reserve();
        return oldValue;
    }

    public boolean containsKey(K k){

    }

    public V get(K k){
        int hash = locate(k);
        if(table.get(hash) == null || table.get(hash).reserved())
            return null;
        return table.get(hash).getValue();
    }
}

class HashAssociation<K,V>{
    static final String RESERVED = "RESERVED";
    K key = null;
    V value = null;

    public HashAssociation(K k, V v){
        key = k;
        value = v;
    }

    public K getKey() {
        return key;
    }

    public V getValue() {
        return value;
    }

    public boolean reserved(){
        if(key.equals(RESERVED))
            return true;
        else
            return false;
    }

    public void reserve(){
        key = RESERVED;
        value = null;
    }
}