class Solution {
    public int candy(int[] ratings) {
        int size = ratings.length;
        
        //process from left
        int[] left = new int[size];
        Arrays.fill(left, 1);
        
        for(int i=1; i<size; i++) {
            if(ratings[i]>ratings[i-1]) {
                left[i] = left[i-1] + 1;
            }
        }
        
        //process from right
        int[] right = new int[size];
        Arrays.fill(right, 1);
        
        for(int i=size-2; i>=0; i--) {
            if(ratings[i]>ratings[i+1]) {
                right[i] = right[i+1] + 1;
            }
        }
        
        //get maximum of both left and right combined
        int totalCandies = 0;
        for(int i=0; i<size; i++) {
            left[i] = Math.max(left[i], right[i]);
            totalCandies += left[i];
        }
        
        return totalCandies;
    }
}