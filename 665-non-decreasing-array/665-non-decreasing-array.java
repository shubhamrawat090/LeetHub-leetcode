// TIME: O(N), SPACE: O(1)
class Solution {
    public boolean checkPossibility(int[] nums) {
        int pos = -1;
        for(int i=0; i<nums.length-1; i++) {
            //finding anomaly i.e. curr>next
            if(nums[i]>nums[i+1]) {
                //if pos!=-1, this means pos changed because there was an anomaly before and now we have 2 anomalies which will violate the condition of changing just 1 value to make non-decreasing array
                if(pos != -1) {
                    return false;
                }
                pos = i;
            }
        }
        
        //if pos is unchanged => array is already increasing order and no anomaly found
        //if pos = 0 or pos = len-2 => we need to change only 1 value
        //we can change the pos value to make entire array non-decreasing only if nums[pos-1]<=nums[pos+1] || nums[pos]<=nums[pos+2]
        return pos == -1 || pos == 0 || pos == nums.length-2 || nums[pos-1]<=nums[pos+1] || nums[pos]<=nums[pos+2];
    }
}