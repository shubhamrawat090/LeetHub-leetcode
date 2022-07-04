class Solution {
    public int candy(int[] ratings) {
        int size = ratings.length;
        
        //process from left side
        int[] processingArray = new int[size];
        Arrays.fill(processingArray, 1);
        
        for(int i=1; i<size; i++) {
            if(ratings[i]>ratings[i-1]) {
                processingArray[i] = processingArray[i-1] + 1;
            }
        }
        
        //process from right side
        int rightVal = 1;
        for(int i=size-2; i>=0; i--) {
            if(ratings[i]>ratings[i+1]) {
                processingArray[i] = Math.max(processingArray[i], rightVal + 1);
            }
            rightVal = processingArray[i];
        }
        
        //get maximum of both left and right combined
        int totalCandies = 0;
        for(int i=0; i<size; i++) {
            totalCandies += processingArray[i];
        }
        
        return totalCandies;
    }
}