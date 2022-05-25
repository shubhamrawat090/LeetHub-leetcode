class Solution {
    public int maxEnvelopes(int[][] envelopes) {
        Arrays.sort(envelopes,(a,b) -> a[0]==b[0]?b[1]-a[1]:a[0]-b[0]);
        
        int[] dp = new int[envelopes.length];
        int maxlen=0;
        
        for(int i=0;i<dp.length;i++){
            
            //find the index of heioght of envelope[i]
            int index = binarySearch ( dp, 0, maxlen, envelopes[i][1]);
            
            dp[index] = envelopes[i][1];
            
            if(index == maxlen){
                maxlen++;
            }
            
        }
        return maxlen;
    }
    
    int binarySearch(int[] arr , int start, int end, int target){
        while(start<end){
            int mid= start + (end - start)/2;
            
            if(arr[mid]==target){
                return mid;
            }
            
            else if(arr[mid]>target){
                end = mid;
            }
            else{
                start = mid +1 ;
            }
        }
        return start;
    }
}