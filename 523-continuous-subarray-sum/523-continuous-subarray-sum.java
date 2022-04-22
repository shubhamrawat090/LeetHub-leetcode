class Solution {
    public boolean checkSubarraySum(int[] nums, int k) {

        Set<Integer> set = new HashSet<>();
        int last = 0; 
        for (int num : nums) {
            int cur = (last + num) % k;
            if (set.contains(cur)) return true;
            set.add(last); 
            last = cur;
        }
        return false;
    }
}