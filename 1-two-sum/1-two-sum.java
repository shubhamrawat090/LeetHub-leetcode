class Solution {
    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> map = new HashMap<>();
        
        int size = nums.length;
        
        for(int i=0; i<size; i++) {
            map.put(nums[i], i);
        }
        
        for(int i=0; i<size; i++) {
            if(map.containsKey(target-nums[i])) {
                if(map.get(target-nums[i])==i) {
                    continue;
                }
                return new int[]{i, map.get(target-nums[i])};
            }
        }
        
        return null;
    }
}