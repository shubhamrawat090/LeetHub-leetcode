class Solution {
    public boolean checkSubarraySum(int[] nums, int k) {
        Set<Integer> set = new HashSet<>();
        int last = 0; //previous subarr sum remainder
        for (int num : nums) {//iterate through entire array
            int cur = (last + num) % k;//current subarr sum remainder
            if (set.contains(cur)) return true;//if the rem already exists return true
            set.add(last); //add prev sub arr sum remainder
            last = cur; //change prev to curr for next iteration
        }
        //return false if nothing happens which means no such subarr found
        return false;
    }
}