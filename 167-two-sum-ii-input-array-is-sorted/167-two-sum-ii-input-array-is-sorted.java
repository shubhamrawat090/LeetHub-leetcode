class Solution {
    public int[] twoSum(int[] numbers, int target) {
        //id array is empty return not found [-1,-1]
        if(numbers.length == 0){
            return new int[]{-1, -1};
        }

        //traverse entire array and search complement of each value via binary search
        for(int i=0; i<numbers.length; i++){
            int val = numbers[i];
            int complement = target - val;

            //complement's index value except when it matches our curr value's idx as we should not take a element twice
            int compIdx = search(numbers, complement, i);
            //if an element is found then return the indices(1-based indexing)
            if(compIdx!=-1){
                return new int[]{i+1, compIdx+1};
            }
        }
        
        return new int[]{-1, -1};
    }
    
    //binary search with idx given which is our curr val's idx as we have to skip it to ensure not taking same element twice
    public int search(int[] nums, int target, int idx) {
        int start=0, end=nums.length-1;
        
        while(start<=end){
            int mid = start + (end - start)/2;
            
            if(nums[mid] == target){
                //if target matches our element and mid == idx means we are taking the same element twice so skip it
                if(mid == idx) start = mid + 1;
                else return mid;
            }else if(nums[mid] < target){
                start = mid + 1;
            }else{
                end = mid - 1;
            }
        }
        
        //no element found
        return -1;
    }
}