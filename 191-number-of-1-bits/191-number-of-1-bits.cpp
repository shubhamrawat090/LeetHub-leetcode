class Solution {
public:
    int hammingWeight(uint32_t n) {
        int count = 0;
        
        while(n!=0) {
            //if n has a 1 at last digit then count it
            if((n&1)!=0) count++;
            //right shift by 1
            n=n>>1;
        }
        
        return count;
    }
};