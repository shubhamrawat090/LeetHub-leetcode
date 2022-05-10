// let’s take an example and dry run on it to understand.

//    _______________________________________
//   | 2 | 5 | 9 | 6 | 9 | 3 | 8 | 9 | 7 | 1 |
//    ---------------------------------------
//     0   1   2   3   4   5   6   7   8   9 
    
    
//     2 -- 9 -- 1 -- 5
//          |         |
//          |         3
//          |         |
//          7 -- 8 -- 6

// Initially, we have 2, then we got to the second index, we have 9, then we go to the 9th index, we have 1, then we go to the 1st index, we again have 5, then we go to the 5th index, we have 3, then we go to the 3rd index, we get 6, then we go to the 6th index, we get 8, then we go to the 8th index, we get 7, then we go to the 7th index and we get 9 and here cycle is formed.

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