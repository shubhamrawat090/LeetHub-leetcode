class MyHashSet {
    private int numBuckets = 15000; // max loading factor = 10000(in constraints)/15000 = 0.667 < 0.75(required in JAVA)
    List<Integer>[] buckets; //define the bucket of bucket size
    
    private int hash_function(int key){
        //our hashfunction which gives use a hashvalue from 1 to numBuckets
        return key % numBuckets;
    }

    /** Initialize your data structure here. */
    public MyHashSet() {
        //initializing the bucket
        buckets = new LinkedList[numBuckets];
    }
    
    public void add(int key) {
        int i = hash_function(key);//get hashvalue in the form of an idx
        //if buckets[i] is empty i.e. we are inserting value for the first time
        if(buckets[i] == null) buckets[i] = new LinkedList<>();
        //if the key is not found in buckets[i] list then add it there
        if(buckets[i].indexOf(key) == -1)
            buckets[i].add(key);
    }
    
    public void remove(int key) {
        int i = hash_function(key);//get the corresponsing hashvalue via hashfunction
        if(buckets[i] == null) return;//no value present so do nothing
        //if a value is found corresponding to the key at ith index list then remove it
        int idx = buckets[i].indexOf(key);
        if(idx != -1) buckets[i].remove(idx);
    }
    
    /** Returns true if this set contains the specified element */
    public boolean contains(int key) {
        int i = hash_function(key);//get the corresponsing hashvalue via hashfunction
        //if no list exists at ith position OR the key doesn't exist in ith position list
        //this means our key is not present
        if(buckets[i] == null || buckets[i].indexOf(key) == -1) return false;
        //otherwise our key is present
        return true;
    }
}

/**
 * Your MyHashSet object will be instantiated and called as such:
 * MyHashSet obj = new MyHashSet();
 * obj.add(key);
 * obj.remove(key);
 * boolean param_3 = obj.contains(key);
 */