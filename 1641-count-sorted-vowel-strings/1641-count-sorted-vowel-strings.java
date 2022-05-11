// Recursive: Time = O(5^n)
class Solution {
    //vowel array
    char[] vowel = new char[]{'a','e','i','o','u'};
    
    public int countVowelStrings(int n) {
        int ans = 0;
        
        //we start iterating from back(considering our c to be last character of a string of length n) 
        //and we count all possible combinations corresponding to each character in the vowel arr
        for(char c: vowel) {
            ans += count(n-1, c);
        }
        
        return ans;
    }
    
    //recursive function
    private int count(int length, char lastChar) {
        if(length == 0) {
            //when length becomes 0, it means it is the 1 and only string that we need
            return 1;
        }
        
        //store combinations from the curr characters with lastChar >= curr char
        int temp = 0;
        
        for(char c: vowel) {
            //ensure lexicographical order
            if(lastChar>=c) {
                //current char is parsed, now consider for length-1 string remaining
                //our curr char becomes lastChar now
                temp += count(length-1, c);
            }
        }
        
        return temp;
    }
}