class Solution {
    public int maximumUnits(int[][] boxTypes, int truckSize) {
        //sort boxes in decreasing order on the basis of no. of units
        Arrays.sort(boxTypes, (a, b) -> b[1]-a[1]);
        
        //greedily take the highest unit giving box first and subtract the no. of boxes taken till no box left in truck size
        int ans = 0;
        for(int[] box: boxTypes) {
            if(truckSize == 0) {
                break;
            }
            
            if(box[0]>truckSize) {
                ans += truckSize * box[1];
                truckSize = 0;
            } else {
                ans += box[0] * box[1];
                truckSize -= box[0];
            }
        }
        
        return ans;
    }
}