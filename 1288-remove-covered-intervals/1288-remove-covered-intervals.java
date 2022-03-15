class Solution {
    public int removeCoveredIntervals(int[][] intervals) {
        int size = intervals.length;
        int countOfCovered = 0;
        
        for(int i=0; i<size; i++){
            for(int j=0; j<size; j++){
                //if both i and j are are pointing to same interval skip it
                if(i==j) continue;
                
                //count the no. of covered intervals
                if(intervals[i][0]>=intervals[j][0] && intervals[i][1]<=intervals[j][1]){
                    countOfCovered++;
                    break;//no need to check ahead
                }
            }
        }
        
        //remaining intervals = total Intervals - covered intervals
        return size-countOfCovered;
    }
}