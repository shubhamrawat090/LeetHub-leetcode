class Solution {
    public int findClosestNumber(int[] nums) {
        int ans = Integer.MAX_VALUE;
        int diff = Integer.MAX_VALUE;
        
        for(int num: nums){
            if(Math.abs(num-0)<diff){
                diff = Math.abs(num-0);
                ans = num;
            }else if(Math.abs(num-0)==diff){
                ans = Math.max(ans, num);
            }
        }
        
        return ans;
        
    }
}

// 2ND APPROACH
//O(n)
// class Solution {
//     public int findClosestNumber(int[] nums) {
//         int ans=nums[0],i;
//         for(i=1;i<nums.length;i++)
//         {
//             int d1=Math.abs(nums[i]),d2=Math.abs(ans);
//             if(d1<d2) ans=nums[i];
//             else if(d1==d2 && ans<nums[i]) ans=nums[i];
//         }    
//         return ans;
//     }
// }