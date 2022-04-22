class MyHashMap {
    int[] map;

    public MyHashMap() {
        map = new int[1000001];//1000000 is limit of map values in constraints
        // filling with -1 takes O(N) time, we don't do it to make it O(1)
        // Arrays.fill(map, -1);//initial values
    }
    
    public void put(int key, int value) {
        // map[key] = value; //this is done when Arrays.fill(map, -1) is used
        map[key] = value+1; //add 1 to our value and store it 
    }
    
    public int get(int key) {
        return map[key]-1; //subtract 1 as we added it in put() operation
    }
    
    public void remove(int key) {
        // map[key] = -1;//this is done when Arrays.fill(map, -1) is used
        map[key] = 0;//just reset to 0
    }
}

/**
 * Your MyHashMap object will be instantiated and called as such:
 * MyHashMap obj = new MyHashMap();
 * obj.put(key,value);
 * int param_2 = obj.get(key);
 * obj.remove(key);
 */