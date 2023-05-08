public class MyHashSet<T> {
    private int CAPACITY = 10;
    private MyBucket[] buckets;
    private int size = 0;
    public MyHashSet(){
        this.buckets = new MyBucket[CAPACITY];
    }
    private int getHash(T item){
        return (item.hashCode() & 0xfffffff) % CAPACITY;
    }
    private MyItemEntry getEntry(T item){
        int hash = getHash(item);
        for (int i = 0; i < buckets[hash].getEntries().size(); i++) {
            MyItemEntry myKeyValueEntry = buckets[hash].getEntries().get(i);
            if (myKeyValueEntry.getItem().equals(item)){
                return myKeyValueEntry;
            }
        }
        return null;
    }
    public boolean containsKey(T item){
        int hash = getHash(item);
        if (buckets[hash] == null){
            return false;
        }
        else if (getEntry(item) == null) {
            return false;
        }
        else {
            return true;
        }
    }
    public void put(T item){
        if (containsKey(item)){
            MyItemEntry entry = getEntry(item);
            entry.setItem(item);
        }
        else {
            int hash = getHash(item);
            if (buckets[hash] == null) {
                buckets[hash] = new MyBucket();
            }
            buckets[hash].addEntry(new MyItemEntry(item));
            size++;
        }
    }
    public T get(T item){
        if (containsKey(item)){
            return (T)getEntry(item);
        }
        else {
            return null;
        }
    }
    public void delete(T item){
        if (containsKey(item)){
            int hash = getHash(item);
            buckets[hash].removeEntry(getEntry(item));
            size--;
        }
    }
    public void printHashMap(){
        for (int i = 0; i < CAPACITY; i++) {
            if (buckets[i] != null){
                System.out.println("Bucket # " + i);
                for (int j = 0; j < buckets[i].getEntries().size(); j++) {
                    System.out.println(buckets[i].getEntries().get(j).getItem());
                }
            }
        }
    }
}
