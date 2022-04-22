class Solution {
    public boolean checkSubarraySum(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>(); // (remainder -> index) map
        // for k=0 and also if the first element is multiple of k then diff 0-(-1) is 1 and we don't take 1 element
        map.put(0, -1); 
        int remainder = 0;
        for(int i=0; i<nums.length; i++){
            remainder += nums[i];
            //divide by k only if k is not 0
            if(k!=0) remainder %= k;//get the remainder
            if(map.containsKey(remainder)){
                //if that remainder is already present meaning sum(0,i) = sum(0,j) 
                //therefore, sum(i, j) divisible by k
                if(i - map.get(remainder) > 1) return true; // more than 1 element
            }else{
                //remainder occurred for the first time, put it in map
                map.put(remainder, i);
            }
        }
        //no subarray with sum%k == 0 found
        return false;
    }
}