class Solution {
    public int nextGreaterElement(int m) {
        long n = m;
        int[] count = new int[10]; //count of each digit 0 - 9
        
        //go from right -> left and get the first no. which is decreasing
        int currRem = -1;
        int prevRem = -1;
        
        while(n > 0) {
            //get right most digit
            currRem = (int)(n%10);
            n = n/10;
            
            //add rightmost digit's count
            count[currRem]++;
            
            //first decreasing found
            if(prevRem > currRem) {
                // suppose currRem = 5, you go from 6 - 9 and find which is present at our right side of the no. which is JUST GREATER THAN 5
                int num = currRem + 1;
                while(count[num] == 0) {
                    num++;
                }
                
                // decrease that JUST GREATER digit's count as it is to be swapped with FIRST DECREASING from right -> left
                count[num]--;
                
                //suppose no. is 1(2)44(3)322, 2 (at 2nd pos from left) is FIRST DECREASING from right->left
                // 3 is JUST GREATER, swapping both will result in 1(3)44(2)322
                // to get final answer, just sort everything after 3's new position
                // like, 1(3)22234, this is our answer
                n = n*10 + num;
                
                for(int i=0; i<10; i++) {
                    while(count[i]-- > 0) {
                        n = n*10 + i;
                    }
                }
                //check if n goes out of 32-bit integer range
                return n > Integer.MAX_VALUE ? -1 : (int)n;
            }
            //try for next digit
            prevRem = currRem;
        }
        // n eventually becomes 0 and no. decreassing digit found from right -> left
        return -1;
    }
}