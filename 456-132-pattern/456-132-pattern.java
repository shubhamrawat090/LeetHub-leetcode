class Solution {
    public boolean find132pattern(int[] nums) {
        if(nums==null||nums.length<3) 
            return false;
        
        //prev min and max arr
        int[] min=new int[nums.length];
        int[] max=new int[nums.length];
        
        min[0]=nums[0];
        max[0]=nums[0];
        
        for(int i=1;i<nums.length;i++){
            //if curr >= prev max, set curr max = curr and curr min = prev min
            if(nums[i]>=max[i-1]){
                max[i]=nums[i];
                min[i]=min[i-1];
            }
            //else if curr <= prev min, set curr min = curr and curr max = prev max
            else if(nums[i]<=min[i-1]){
                min[i]=nums[i];
                max[i]=max[i-1];
            }
            
            else{
                int j=0;
                //find a j where nums[j] > nums[i] (nums[i] signifies kth element)
                for( j=i-1;j>=1;j--){
                    if(nums[j]>nums[i]) break;
                }
                
                //if such a jth element is found, also the prev min to that j(which is ith element) is found
                //you have found 132 pattern
                if(j>=1&&min[j-1]<nums[i]) return true;
                
                //set curr max = prev max and curr min = prev min
                max[i]=max[i-1];
                min[i]=min[i-1];
            }
        }
        //no such 132 pattern found
        return false;
    }
}