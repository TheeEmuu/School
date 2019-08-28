import java.util.ArrayList;

public class BubbaHashMap<K, V> implements Map<K, V> {
    private ArrayList<Pair<K,V>> table;
    private int[] bucketData;
    private int size;
    private static final int BUCKET_SIZE = 4;

    public BubbaHashMap(int sz) {
        table = new ArrayList<Pair<K,V>>(sz);
        size = 0;
        for (int i=0; i<sz; ++i)
            table.add(null);

        bucketData = new int[sz];
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public V put(K key, V value) {
        // step one: check if key is already present
        // search the bucket for this key

        int hash = hash(key);

        // loop that hunts for the key in this bucket
        int pos = find(key, hash);

        if (pos != -1) {
            // key is already in the map
            V val = table.get(pos).value;
            table.get(pos).value = value;
            return val;
        }

        // key not found. linear probe forward, looking for an empty spot
        int index = hash;
        while (table.get(index) != null)
            index = (index + 1) % table.size();

        // index is the nearest available spot to place the key.
        // might not be in the bucket

        while (dist(hash, index) >= BUCKET_SIZE) {
            // find a spot behind us that allows us to move index to the left
            // if this loop fails to find a spot, we must rehash
            boolean spotFound = false;
            int candidateStart = index - BUCKET_SIZE + 1;
            for (int i = 0; i < BUCKET_SIZE; ++i) {
                // the location of our candidate for shifting
                int candidate = (candidateStart + i) % table.size();
                // can we move the value in location candidate? Hash to find the candidate's bucket
                int candidateBucket = hash(table.get(candidate).key);
                // is index (the spot we're moving to) in candidateBucket?
                if (dist(candidateBucket, index) < BUCKET_SIZE) {
                    // move the candidate to spot index
                    table.set(index, table.get(candidate));
                    // update books
                    int newSlot = dist(candidateBucket, index);
                    int oldSlot = dist(candidateBucket, candidate);
                    markSlot(candidateBucket, newSlot);
                    clearSlot(candidateBucket, oldSlot);
                    // reset index and keep shifting, until we succeed.
                    index = candidate;
                    spotFound = true;
                    break;
                }
            }

            if (!spotFound) {
                // we could not push index back into the bucket. rehash and try again
                rehash();
                return put(key, value);
            }
        }
        // insert our new value, updating the books
        table.set(index, new Pair<K, V>(key, value));
        markSlot(hash, dist(index, hash));
        size++;
        return value;
    }

    @Override
    public boolean containsKey(K key) {
        int hash = hash(key);

        return find(key, hash) != -1;
    }

    @Override
    public V get(K key) {
        int hash = hash(key);

        int pos = find(key, hash);

        if(pos != -1)
            return table.get(pos).value;
        else
            return null;
    }

    @Override
    public V remove(K key) {
        int hash = hash(key);

        int pos = find(key, hash);

        if(pos != -1){
            V value = table.get(pos).value;

            int bucketLocation = dist(hash, pos);

            clearSlot(hash, bucketLocation);

            return value;
        }
        else
            return null;
    }

    private int hash(K key) {
        return Math.abs(key.hashCode() % table.size());
    }

    // A loop that looks through the bucket to find the key. Return the index (in the table,
    // not in the bucket) where key is found, or -1 if it isn't present.
    private int find(K key, int bucket) {
        for(int i = 0; i < BUCKET_SIZE; i++){
            if(isOccupied(bucket, i) && table.get(bucket + i).key.equals(key))
                return bucket + i;
        }
        return -1;
    }

    // resize the table and re-insert all entries
    private void rehash() {
        size *= 2;
        ArrayList<Pair<K, V>> oldTable = table;

        table = new ArrayList<>(size);
        size = 0;

        for(Pair<K, V> x : oldTable){
            if(!x.reserved && x.key != null)
                put(x.key, x.value);
        }
    }

    // return the distance between b and s in the table. That is,
    // how far do you have to move to get FROM b TO s.
    private int dist(int b, int s) {
        return s - b;
    }

    // update bookkeeping to reflect that this slot in that bucket is occupied
    private void markSlot(int bucket, int slot) {
        bucketData[bucket] |= (1 << slot);
    }

    // update bookkeeping to reflect that this slot in that bucket is unoccupied
    private void clearSlot(int bucket, int slot) {
        bucketData[bucket] &= ~(1 << slot);
    }

    // ask bookkeeping if this slot in that bucket is occupied
    private boolean isOccupied(int bucket, int slot) {
        return (bucketData[bucket] & (1 << slot)) != 0;
    }

    public boolean checkBooks(){
        int totalOnes = 0;

        for(int i = 0; i < table.size(); i++){
            for(int j = 0; j < BUCKET_SIZE; j++){
                Pair x = table.get((i+j) % table.size());

                if(isOccupied(i, j)){
                    totalOnes++;

                    if(find((K)x.key, i) != i+j){
                        return false;
                    }
                }
                else{
                    if(x == null)
                        continue;
                    if(find((K)x.key, i) == i+j)
                        return false;
                }
            }
        }

        if(totalOnes != size)
            return false;

        return true;
    }
}
