class Solution {
    public int findDuplicate(int[] nums) {
        //slow ptr moves 1 step while fast ptr moves 2 steps at a time,
        //if they meet then there is a cycle
        //the starting point of that cycle is the no. which is repeating
        int slow = nums[0], fast = nums[0];
        
        //DETECTING CYCLE -> use floyd's cycle detection
        while(true){
            slow = nums[slow]; //moves by 1 step
            fast = nums[nums[fast]]; //moves by 2 steps
            
            if(slow == fast){//cycle detected
                break;
            }
        }
        
        //DETECTING STARTING POINT OF THE CYCLE
        //reset slow or fast anyone and then move both by 1 step, wherever they meet is the starting point of the cycle
        slow = nums[0];
        
        while(slow!=fast){
            slow = nums[slow];
            fast = nums[fast];
        }
        
        return slow; // return fast; //both are pointing at starting pt of cycle
    }
}