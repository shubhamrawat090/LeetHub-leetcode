class Solution {
    public int longestConsecutive(int[] nums) {
        //add all values in hashmap and consider each and every one as start points
        HashMap<Integer, Boolean> stPoints = new HashMap<>();
        for(int num: nums) {
            stPoints.put(num, true);
        }
        
        //whichever value's previous num exists in hashmap that is not the start point
        for(int num: nums) {
            if(stPoints.containsKey(num - 1)) {
                stPoints.put(num, false);
            }
        }
        
        //do work for starting points only
        int maxLength = 0;
        for(int num: nums) {
            if(stPoints.get(num) == true) {
                int length = 1;
                int startPt = num;
                while(stPoints.containsKey(startPt + length)) {
                    length++;
                }
                
                maxLength = Math.max(maxLength, length);
            }
        }
        
        return maxLength;
    }
}