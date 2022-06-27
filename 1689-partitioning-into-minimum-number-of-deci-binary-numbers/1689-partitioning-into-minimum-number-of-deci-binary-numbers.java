// to reduce 5123 we need numbers 1111, 1011, 1001, 1000, 1000

// 5123 - 1111 = 4012
// 4012 - 1011 = 3001
// 3001 - 1001 = 2000
// 2000 - 1000 = 1000
// 1000 - 1000 = 0

// we are using the logic that wherever there is a val other than 0 we place 1 otherwise we place 0 to get our deci-binary no. to be subtracted like 4012 needs 1011 to be subtracted from it
// we do this entire process until we reach 0

// An OBSERVATION can be made is that the no. of deci-binary values that needs to be used are EQUAL TO THE MAXIMUM no. in the string
// this is because the each digit is being subtracted by 1 if it is not 0 already
// therefore, the largest digit will take the longest time to reach to 0 which will be largest digit no. of times only

// SO THIS QUESTION GENERALLY BOILS DOWN TO FINDING THE MAXIMUM DIGIT IN THE STRING

class Solution {
    public int minPartitions(String n) {
        int max = 0;
        for(char c: n.toCharArray()) {
            max = Math.max(max, c-'0');
        }
        
        return max;
    }
}