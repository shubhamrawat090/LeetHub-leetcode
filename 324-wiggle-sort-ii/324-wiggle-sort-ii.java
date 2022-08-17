class Solution {
    public void wiggleSort(int[] nums) {
        int size = nums.length;
        
        //create freq array
        int max = -1, min = 5001;
        int[] freq = new int[5001];
        for(int i=0; i<size; i++) {
            max = Math.max(max, nums[i]);
            min = Math.min(min, nums[i]);
            freq[nums[i]]++;
        }
        
        //go left to right, skipping 2 steps each iteration
        //keep adding highest value till its freq goes to 0
        //when freq goes to 0, add second highest
        //keep this process going
        int idx = max;
        for(int odIdx=1; odIdx<size; odIdx+=2) {
            while(freq[idx]==0) {
                idx--;
            }
            
            nums[odIdx] = idx;
            freq[idx]--;
        } 
        
        //go right to left, skipping 2 steps each iteration
        //keep adding lowest value till its freq goes to 0
        //when freq goes to 0, add second lowest
        //keep this process going
        idx = min;
        int evIdx = (size%2 == 0) ? size-2: size-1; //start pt diff for odd and even idx
        while(evIdx>=0) {
            while(freq[idx]==0) {
                idx++;
            }
            
            nums[evIdx] = idx;
            freq[idx]--;
            
            evIdx-=2;
        }
    }
}