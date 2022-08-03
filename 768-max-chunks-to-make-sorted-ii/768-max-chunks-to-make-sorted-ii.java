class Solution {
    public int maxChunksToSorted(int[] arr) {
        int lmax = 0;
        int chunks = 0;
        
        int[] rightMin = new int[arr.length+1];
        rightMin[rightMin.length-1] = Integer.MAX_VALUE; // last elem is +infinity
        
        //creating rightmin arr
        for(int i=rightMin.length-2; i>=0; i--) {
            rightMin[i] = Math.min(rightMin[i+1], arr[i]);
        }
        
        
        for(int i=0; i<arr.length; i++) {
            lmax = Math.max(lmax, arr[i]);
            
            if(lmax <= rightMin[i+1]) {
                chunks++;
            }
        }
        
        return chunks;
    }
}