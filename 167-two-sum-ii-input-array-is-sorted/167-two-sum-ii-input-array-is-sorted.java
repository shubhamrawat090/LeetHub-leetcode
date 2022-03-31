class Solution {
    public int[] twoSum(int[] numbers, int target) {
        if(numbers.length == 0){
            return new int[]{-1, -1};
        }

        for(int i=0; i<numbers.length; i++){
            int val = numbers[i];
            int complement = target - val;

            int compIdx = search(numbers, complement, i);
            if(compIdx!=-1){
                return new int[]{i+1, compIdx+1};
            }
        }
        
        return new int[]{-1, -1};
    }
    
    public int search(int[] nums, int target, int idx) {
        int start=0, end=nums.length-1;
        
        while(start<=end){
            int mid = start + (end - start)/2;
            
            if(nums[mid] == target){
                if(mid == idx) start = mid + 1;
                else return mid;
            }else if(nums[mid] < target){
                start = mid + 1;
            }else{
                end = mid - 1;
            }
        }
        
        return -1;
    }
}