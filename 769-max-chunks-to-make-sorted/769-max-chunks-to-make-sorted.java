class Solution {
    public int maxChunksToSorted(int[] arr) {
        int chunks = 0;
        int maxReach = 0;
        
        for(int i=0; i<arr.length; i++) {
            maxReach = Math.max(maxReach, arr[i]);
            
            //a chunk formed
            if(maxReach == i) {
                chunks++;
            }
        }
        
        return chunks;
    }
}