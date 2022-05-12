class Solution {
    // We will use BACKTRACKING 
    //               1 2 3   swap 2 & 3 => 1 3 2
    // swap 1 & 2 => 2 1 3   swap 1 & 3 => 2 3 1
    // swap 1 & 3 => 3 1 2   swap 1 & 2 => 3 2 1
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        
        helper(res, nums, 0);
        
        return res;
    }
    
    private void helper(List<List<Integer>> res, int[] nums, int idx) {
        if(idx == nums.length) {
            // List<Integer> list = new ArrayList<>();
            // for(int num: nums) {
            //     list.add(num);
            // }
            List<Integer> list = Arrays.stream(nums).boxed().collect(Collectors.toList());
            res.add(list);
            return;
        }
        
        for(int i=idx; i<nums.length; i++) {
            //swap curr idx and ith value via traversing the arr
            swap(nums, i, idx);
            //call for next idx
            helper(res, nums, idx+1);
            //backtrack
            swap(nums, i, idx);
        }
    }
    
    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}