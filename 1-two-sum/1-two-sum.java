class Solution {
    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> valIdxMap = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            // if target-curr val exists in map
            // then return the index for map element, curr element
            if (valIdxMap.containsKey(target - nums[i])) {
                return new int[] { valIdxMap.get(target - nums[i]), i };
            }

            valIdxMap.put(nums[i], i);
        }

        return new int[] { -1, -1 };
    }
}