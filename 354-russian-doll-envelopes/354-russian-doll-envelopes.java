//Using Binary Search (In-Built Java Function)
// O(NlogN) time, O(N) space
class Solution {
    public int maxEnvelopes(int[][] envelopes) {
        Arrays.sort(envelopes,(a,b) -> a[0]==b[0]?b[1]-a[1]:a[0]-b[0]);
        
        int[] dp = new int[envelopes.length];
        int maxlen=0;
        
        for(int i=0;i<dp.length;i++){
            
            //find the index of height of envelope[i]
            int index = binarySearch (dp, 0, maxlen, envelopes[i][1]);
            
            dp[index] = envelopes[i][1];
            
            if(index == maxlen){
                maxlen++;
            }
            
        }
        return maxlen;
    }
    
    int binarySearch(int[] arr , int start, int end, int target){
        //returns -ve if element is not present
        int index = Arrays.binarySearch(arr,start,end,target);
        //we convert -ve to +ve to get the nearest greater element
        if(index<0){
            index = -(index+1);
        }
        return index;
    }
}