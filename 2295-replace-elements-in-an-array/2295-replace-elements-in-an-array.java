class Solution {
    public int[] arrayChange(int[] nums, int[][] operations) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int i=0; i<nums.length; i++) {
            map.put(nums[i], i);
        }
        
        for(int[] op: operations) {
            if(!map.containsKey(op[0])) continue;
            int idx = map.get(op[0]);
            nums[idx] = op[1];
            map.remove(op[0]);
            map.put(nums[idx], idx);
        }
        
        return nums;
    }
}