class Solution {
    public int maxArea(int[] height) {
        //keeps max area
        int maxArea = 0;
        
        //pointer at start and end of arr
        int left = 0, right = height.length - 1;
        
        //work till both pointers meet
        while(left<right){
            //distance between two lines
            int dist = right-left;
            //height to be taken is the minimum of both heights as water will fill till this height only
            int ht = Math.min(height[left], height[right]);
            //calculate the area
            int area = dist*ht;
            //store the max area out of all areas calculated
            maxArea = Math.max(maxArea, area);
            
            //if left line is of smaller then we have found the best ans using this height and have to go the next on left and same for right
            //this is because moving right ptr when left is small will result in decreasing distance with being able to use the left height only as the new height encountered can be greater, smaller, equal to the left height which will only decrease our area as the distance is decreased when moving the right pointer
            //SO MOVE THE POINTER WHICH IS THE SMALLEST AS THE CURR ANS IS THE BEST ONE USING THAT HEIGHT
            if(height[left]<height[right]){
                left++;
            }else{
                right--;
            }
        }
        
        //return calculated area
        return maxArea;
    }
}