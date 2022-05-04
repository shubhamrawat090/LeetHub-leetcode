class Solution {
    public int maxOperations(int[] nums, int k) {
        int n = nums.length;
        if (n == 1) return 0;
        Arrays.parallelSort(nums);
        int l = -1;
        int r = n;
        // binary search to find right boundary
        while (l + 1 < r) {
            int m = l + ((r - l) >> 1);
            if (nums[m] < k) {
                l = m;
            } else {
                r = m;
            } 
        } 
        r = l;
        l = 0;
        int total = 0;
        while (l < r) {
            int sum = nums[l] + nums[r];
            if (sum > k) {
                r--;
            } else if (sum < k) {
                l++;
            } else {
                total++;
                l++;
                r--;
            }
        }
        return total;
    }
}