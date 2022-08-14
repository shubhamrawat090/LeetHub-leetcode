class Solution {
    public int edgeScore(int[] edges) {
        int n = edges.length;
        long[] temp = new long[n];
        
        for(int i=0; i<n; i++) {
            int node = edges[i];
            
            temp[node] += i;
        }
        
        long max = Long.MIN_VALUE;
        int maxIdx = -1;
        
        for(int i=0; i<n; i++) {
            if(temp[i] > max) {
                max = temp[i];
                maxIdx = i;
            }
        }
        
        return maxIdx;
    }
}