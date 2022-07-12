class Solution {
    public boolean makesquare(int[] matchsticks) {
        // sum of all matchsticks length
        int sum = 0;
        for(int matchstick: matchsticks) {
            sum += matchstick;
        }
        
        // if total sum of lengths of matchsticks is not a multiple of 4, we can't make a square 
        // also, there must be atleast 4 matchsticks
        if(sum % 4 != 0 || matchsticks.length < 4) {
            return false;
        }
        
        // sorting in non-increasing order decreases the runtime as well as reduces the chance of TLE
        // since, bigger sticks are going to be processed at first
        Arrays.sort(matchsticks);
        reverse(matchsticks);
        
        // sides vector
        int[] sides = new int[4];
        
        // also, check if any of the side has length more than the target, we can't make the matchstick
        if(matchsticks[0] >sum)
            return false;
        
        // recurse to find out if there exists any optimal square?
        return rec(sides, 0, sum/4, matchsticks);
    }
    
    private boolean rec(int[] sides, int pos, int target, int[] sticks) {
        // check if we reaches the target?
        if(pos == sticks.length) {
            return (sides[0] == target) && (sides[1] == target) && (sides[2] == target) && (sides[3] == target);
        }
        
        for(int i=0; i<4; i++){
            // check whether on adding current matchstick length, increases the target?
            // also, check whether we have already checked this state or not?
            if(sides[i] + sticks[pos] > target || alreadyHappened(sides, i))
                continue;
            
            // include current matchstick length
            sides[i] += sticks[pos];
            if(rec(sides, pos+1, target, sticks))
                return true;
            
            // reduce side length for further recursion
            sides[i] -= sticks[pos];
        }
        
        return false;
    }
    
    // DP OPTIMISATION, check whether same state has already happened or not?
    private boolean alreadyHappened(int[] sides, int pos){
        
        for(int i=0; i<pos; i++){
            // {5+6, 3, 5, 9} and {5, 3, 5+6, 9} are essentially the same recursion calls
            if(sides[i] == sides[pos])
                return true;
        }
        
        return false;
    }
    
    private void reverse(int[] arr) {
        int start = 0, end = arr.length-1;
        
        while(start < end) {
            int temp = arr[start];
            arr[start] = arr[end];
            arr[end] = temp;
            
            start++;
            end--;
        }
    }
}