class Solution {
    public int minDominoRotations(int[] tops, int[] bottoms) {
        // num1 on top row and num1 on bottom row
        int count1 = 0, count2 = 0;
        
        // num2 on top row and num2 on bottom row
        int count3 = 0, count4 = 0;
        
        int num1 = tops[0], num2 = bottoms[0];
        
        for(int i=0; i<tops.length; i++) {
            if(count1 != Integer.MAX_VALUE) {
                if(tops[i] == num1) {
                    //don't do anything
                } else if(bottoms[i] == num1) {
                   //1 swap
                    count1++;
                } else {
                    count1 = Integer.MAX_VALUE;
                }
            }

            if(count2 != Integer.MAX_VALUE) {
                if(bottoms[i] == num1) {
                    //don't do anything
                } else if(tops[i] == num1) {
                   //1 swap
                    count2++;
                } else {
                    count2 = Integer.MAX_VALUE;
                }
            }

            if(count3 != Integer.MAX_VALUE) {
                if(tops[i] == num2) {
                    //don't do anything
                } else if(bottoms[i] == num2) {
                   //1 swap
                    count3++;
                } else {
                    count3 = Integer.MAX_VALUE;
                }
            }

            if(count4 != Integer.MAX_VALUE) {
                if(bottoms[i] == num2) {
                    //don't do anything
                } else if(tops[i] == num2) {
                   //1 swap
                    count4++;
                } else {
                    count4 = Integer.MAX_VALUE;
                }
            }
        }
        
        int min = Math.min(count1, Math.min(count2, Math.min(count3, count4)));
        
        return min == Integer.MAX_VALUE? -1: min;
    }
}