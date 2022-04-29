//Union Find 

class Solution {
    int[] parent; 
    public boolean isBipartite(int[][] graph) {
        parent = new int[graph.length];
        for(int i = 0; i < parent.length; i++) parent[i]  = i;
        for (int i=0; i<graph.length; i++) {
            int[] adjs = graph[i];
            for (int j=0; j<adjs.length; j++) {
                if (find(i) ==find(adjs[j])) return false;
                union(adjs[0], adjs[j]);
            }
        }
        return true;
    }
    
     int find(int i) {
            if (parent[i] == i) {
                return parent[i];
            }
            parent[i] = find(parent[i]);
            return parent[i];
        }
        
        void union(int i, int j) {
            int parentI = find(i);
            int parentJ = find(j);
            if (parentI != parentJ) {
                parent[parentI] = parentJ;
            }
        }
}