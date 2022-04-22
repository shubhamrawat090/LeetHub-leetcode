class MyHashMap {

    /** Initialize your data structure here. */
    LinkedList<Entry>[] map;
    public static int SIZE = 769;//large prime no. to make hashing efficient
    
    public MyHashMap() {
        map = new LinkedList[SIZE];
    }

    /** value will always be non-negative. */
    public void put(int key, int value) {
        int bucket = key % SIZE;//get the bucket where we want to put our key-val pair
        //if no such bucket exists then create a new one
        if(map[bucket] == null) {
            map[bucket] = new LinkedList<Entry>();
            map[bucket].add(new Entry(key, value));
        }
        else {
            //search all the entries in that bucket
            for(Entry entry : map[bucket]){
                //if a key matches given key(the key already exists, just update the value) then set it's value to given value
                if(entry.key == key){
                    entry.val = value;
                    return;
                }
            }
            //no such key exist so add a new entry in the bucket
            map[bucket].add(new Entry(key, value));
        }
    }

    /** Returns the value to which the specified key is mapped, or -1 if this map contains no mapping for the key */
    public int get(int key) {
        int bucket = key % SIZE;//get the bucket first
        LinkedList<Entry> entries = map[bucket];//get the entries from the bucket
        if(entries == null) return -1;//if no such entry exist return -1
        //search each entry
        for(Entry entry : entries) {
            //if any key matches, return it's value
            if(entry.key == key) return entry.val;
        }
        //no such key found
        return -1;
    }

    /** Removes the mapping of the specified value key if this map contains a mapping for the key */
    public void remove(int key) {
        int bucket = key % SIZE;//get the bucket first
        Entry toRemove = null;//the entry to be removed
        if(map[bucket] == null) return;//if bucket is empty then do nothing
        else {
            //search each entry in bucket
            for(Entry entry : map[bucket]){
                //if a key matches given key
                if(entry.key == key) {
                    //set toRemove to the entry that matches
                    toRemove = entry;
                }
            }
            //if no such matching entry found, do nothing
            if(toRemove == null) return;
            //remove the entry from bucket
            map[bucket].remove(toRemove);
        }
    }
}

//entry class with our key-value pair
class Entry {
    public int key;
    public int val;

    public Entry(int key, int val){
        this.key = key;
        this.val = val;
    }
}