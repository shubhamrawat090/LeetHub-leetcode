// if any value occurs more than size/2 times, it means others numbers freq cannot make it 0 when subtracted to it

// we consider first elem to be majority, keep iterating again.
// if this is same as elem so far, increment count
// if new elem occurred, decrement count
// if count == 0, increment count & this element is now the new majority element

class Solution {
    public int majorityElement(int[] nums) {
        int count = 0, majority = 0;
        
        for(int num: nums) {
            if(count == 0) {
                majority = num;
                count++;
            } else {
                if(num == majority) {
                    count++;
                } else {
                    count--;
                }
            }
        }
        
        return majority;
    }
}