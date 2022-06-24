// STEPS

// 1. Find the total sum.
// 2. Find the maximum value idx in array.
// 3. Find the difference sum = total sum - maxVal
// 4. Update maxVal = maxVal - diff. sum
// 5. Repeat till all values become 1 in array.


// TIME: O(Nlog(maxVal)), Space: log(maxVal) for recursive stack
class Solution {
    public boolean isPossible(int[] target) {
        long sum = 0;
        int maxIdx = 0;
        
        //get sum of all elements and maxIdx
        for(int i=0; i<target.length; i++) {
            sum += target[i];
            if(target[i]>target[maxIdx]) {
                maxIdx = i;
            }
        }
        
        //MAXIMUM VALUE
        long maxVal = target[maxIdx];
        
        //get diff sum
        long diffSum = sum - maxVal;
        
        //if diff sum is 1 then we can keep on subtracting 1 from maxValue to make it 1
        //also, if maxValue is 1 then we have successfully converted our maximum value to 1
        if(diffSum == 1 || maxVal == 1) {
            return true;
        }
        
        //on updating maxValue, it shouldn't become -ve as we won't be able to make it 1 again(because all values are +ve)
        if(diffSum > maxVal) {
            return false;
        }
        
        //if diffSum = 0 then maxVal will never be changed and we might get TLE
        if(diffSum == 0) {
            return false;
        }
        
        //if we keep on subtracting diffSum and then we get to 0 => we won't ever reach to 1
        if(maxVal % diffSum == 0) {
            return false;
        }
        
        //update maxVal
        //we use "%" instead of "-" because we can save steps where maxValue is at the same idx and we keep on subtracting the same diffSum from it
        target[maxIdx] %= diffSum;
        
        //repeat for updated array
        return isPossible(target);
    }
}