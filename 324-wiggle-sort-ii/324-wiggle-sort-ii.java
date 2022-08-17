class Solution {
    public void wiggleSort(int[] nums) {
        int[] freq = new int[5001];
        int size = nums.length;
        int[] ans = new int[size];
        
        int max = -1, min = 5001;
        for(int i=0; i<size; i++) {
            max = Math.max(max, nums[i]);
            min = Math.min(min, nums[i]);
            freq[nums[i]]++;
        }
        
        int idx = max;
        for(int odIdx=1; odIdx<size; odIdx+=2) {
            while(freq[idx]==0) {
                idx--;
            }
            
            ans[odIdx] = idx;
            freq[idx]--;
        } 
        
        idx = min;
        int evIdx = (size%2 == 0) ? size-2: size-1;
        while(evIdx>=0) {
            while(freq[idx]==0) {
                idx++;
            }
            
            ans[evIdx] = idx;
            freq[idx]--;
            
            evIdx-=2;
        }
        
        for(int i=0; i<size; i++) {
            nums[i] = ans[i];
        }
    }
}