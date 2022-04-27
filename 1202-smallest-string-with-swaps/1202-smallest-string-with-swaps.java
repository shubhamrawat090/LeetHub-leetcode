//////////////////// FIND UNION ////////////////////////////
class Solution {
    int[] parent;
    int[] rank;
    
    public String smallestStringWithSwaps(String s, List<List<Integer>> pairs) {
        int n =s.length();
        parent = new int[n];
        rank = new int[n];
        
        for(int i = 0; i<n; i++) parent[i] = i;
        
        for(List<Integer> v : pairs){
            union(v.get(0), v.get(1));  // union of all the pairs that can be swappped
        }
        for(int i = 0; i<n; i++){
            parent[i] = find(parent[i]); // making sure that the connected components have a same parent in parent[i]
        }
        
        HashMap<Integer, ArrayList<Character>> map = new HashMap<>();
        
        for(int i = 0; i<n; i++){
            ArrayList<Character> list = map.getOrDefault(parent[i], new ArrayList<>());
            list.add(s.charAt(i));
            map.put(parent[i], list); // adding all the character corresponding to thier parent Index
        }
        
        for(ArrayList<Character> a : map.values()){
            Collections.sort(a, (x,y) -> y-x);  // sorting all the connected components
        }
        
        char[] ch = new char[n];
        for(int i = 0; i<n; i++){
            ch[i] = map.get(parent[i]).remove(map.get(parent[i]).size() - 1); // making our ans
        }
        
        return new String(ch);
    }
    
    void union(int a, int b){
        int x = find(a), y = find(b);
        if(x == y) return;
        if(rank[x] > rank[y]){
            parent[y] = x;
        }else if(rank[y] > rank[x]){
            parent[x] = y;
        }else{
            parent[x] = y;
            rank[y]++;
        }
    }
    
    int find(int x){
        if(parent[x] != x){
            parent[x] = find(parent[x]);
        }
        return parent[x];
    }
}