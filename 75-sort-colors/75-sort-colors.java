class Solution {
    public void sortColors(int[] nums) {
        int one = 0, zero = 0, two = 0;
        for(int num: nums) {
            if(num == 0) {
                zero++;
            }
            
            if(num == 1) {
                one++;
            }
            
            if(num == 2){
                two++;
            }
        }
        int i=0;
        for(int j=0; j<zero; j++) {
            nums[i] = 0;
            i++;
        }
        
        for(int j=0; j<one; j++) {
            nums[i] = 1;
            i++;
        }
        
        for(int j=0; j<two; j++) {
            nums[i] = 2;
            i++;
        }
    }
}