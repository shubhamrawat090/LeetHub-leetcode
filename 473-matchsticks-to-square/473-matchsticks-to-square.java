class Solution {
    public boolean makesquare(int[] matchsticks) {
        int sum = 0;
        for(int matchstick: matchsticks) {
            sum += matchstick;
        }
        
        if(sum % 4 != 0 || matchsticks.length < 4) {
            return false;
        }
        
        Arrays.sort(matchsticks);
        reverse(matchsticks);
        return rec(0, matchsticks, sum/4, 0, 0, 0, 0);
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
    
    private boolean rec(int idx, int[] matchsticks, int target, int s1, int s2, int s3, int s4) {
        if(idx == matchsticks.length) {
            return (s1 == target) && (s2 == target) && (s3 == target) && (s4 == target);
        }
        
        if(s1+matchsticks[idx] <= target && rec(idx+1, matchsticks, target, s1+matchsticks[idx], s2, s3, s4)) {
            return true;
        }
        
        if(s2+matchsticks[idx] <= target && rec(idx+1, matchsticks, target, s1, s2+matchsticks[idx], s3, s4)) {
            return true;
        }
        
        if(s3+matchsticks[idx] <= target && rec(idx+1, matchsticks, target, s1, s2, s3+matchsticks[idx], s4)) {
            return true;
        }
        
        if(s4+matchsticks[idx] <= target && rec(idx+1, matchsticks, target, s1, s2, s3, s4+matchsticks[idx])) {
            return true;
        }
        
        return false;
    }
}