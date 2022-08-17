class Solution {
    public void wiggleSort(int[] nums) {
        int size = nums.length;
        
        //less than 2 size arr cannot be sorted
        if(size < 2) {
            return;
        }
        
        //create freq array
        int max = -1, min = 5001;
        int[] freq = new int[5001];
        for(int i=0; i<size; i++) {
            max = Math.max(max, nums[i]);
            min = Math.min(min, nums[i]);
            freq[nums[i]]++;
        }
        
        int odIdx = 1;
        for(int i=max; i>=0; i--) {
            while(freq[i]>0) {
                freq[i]--;
                
                nums[odIdx] = i;
                odIdx += 2;
                
                if(odIdx >= size) {
                    //odIdx still at odd place means all max values(peaks) have been made
                    //it is time to set lower values now
                    if(odIdx % 2 != 0) {
                        odIdx = 0;
                    }
                    //oddIdx = even means all max(peaks) were filled and odIdx was resetted
                    //then all lower values are filled now
                    else {
                        break;
                    }
                }
            }
        }
    }
}