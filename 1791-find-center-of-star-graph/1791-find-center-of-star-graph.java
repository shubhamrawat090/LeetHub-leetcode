class Solution {
    public int findCenter(int[][] edges) {
        int n = edges.length;
        int[] inDegree = new int[n+2];
        int[] outDegree = new int[n+2];
        
        for(int[] e: edges) {
            inDegree[e[0]]++;
            outDegree[e[0]]++;
            
            inDegree[e[1]]++;
            outDegree[e[1]]++;
        }
        
        for(int i=1; i<=n+1; i++) {
            if(inDegree[i] == n) {
                return i;
            }
        }
        
        return -1;
    }
}