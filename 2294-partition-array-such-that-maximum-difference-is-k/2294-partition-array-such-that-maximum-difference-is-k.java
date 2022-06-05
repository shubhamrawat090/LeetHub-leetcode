class Solution {
    public int partitionArray(int[] nums, int k) {
        Arrays.sort(nums);
        int ans = 0;
        int i=0;
        while(i<nums.length) {
            int j=i;
            //find the longest possible subsequence with max-min<=k
            while(j<nums.length && nums[j]-nums[i]<=k) {
                j++;
            }
            ans++;//count 1 subsequence
            //starting of the next subsequence
            i=j;
        }
        return ans;
    }
}