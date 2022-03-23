class Solution {
    public int brokenCalc(int startValue, int target) {
        //if startValue>=target then only thing we can do is subtract 1, 
        //the no. of times we have to subtract 1 is startValue - target i.e. the difference between then to reach the target
        if(startValue >= target) return startValue - target;
        
        //Otherwise, if target is even we divide it by 2
        //if it is odd we add 1 to change it to even
        if(target % 2 == 0){
            return 1 + brokenCalc(startValue, target / 2);
        }
        return 1 + brokenCalc(startValue, target + 1);
    }
}