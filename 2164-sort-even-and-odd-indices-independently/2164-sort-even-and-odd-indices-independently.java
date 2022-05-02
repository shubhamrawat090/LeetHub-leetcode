class Solution {
    public int[] sortEvenOdd(int[] nums) {
        //store odd and even frequency which will automatically store it in increasing order
        int even[] = new int[101];
        int odd[] = new int[101];
        for(int i = 0 ; i < nums.length; i++) {
            if(i%2 == 0) even[nums[i]]++;
            else odd[nums[i]]++;
        }
        //start even from start(increasing order) and odd from end(decreasing order)
        int e = 0;
        int o = 100;
        //traverse the array
        for(int i = 0; i < nums.length; i++) {
            //even idx
            if(i%2 == 0) {
                //traverse in even array till a value is found
                while(even[e] == 0) e++; //e++ as we are going from left->right
                //store that value in nums[i]
                nums[i] = e;
                //remove that value's count from even freq arr
                even[e]--;
            } 
            //odd idx
            else {
                //traverse in even array till a value is found
                while(odd[o] == 0) o--; //o-- as we are going from right->left
                //store that value in nums[i]
                nums[i] = o;
                //remove that value's count from odd freq arr
                odd[o]--;
            }
        }
        //return our array
        return nums;
    }
}