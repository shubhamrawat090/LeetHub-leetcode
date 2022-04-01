class Solution {
    //function to check for vowels(UPPER AND LOWER CASE)
    private boolean checkVowel(char ch){
        return (ch=='a' || ch=='e' || ch=='i' || ch=='o' || ch == 'u' || ch=='A' || ch=='E' || ch=='I' || ch=='O' || ch == 'U');
    }
    
    
    public String reverseVowels(String s) {
        //convert char arr because of string immutability
        char[] chArr = s.toCharArray();
        
        //starting and ending pointer
        int i=0, j=chArr.length-1;
        
        restart:
        //work till the pointers meet
        while(i<j){
            //move i ptr to right for consonants
            while(!checkVowel(chArr[i])){
                if(i<j) i++;
                else break restart;
            }
            
            //move j ptr to right for vowels
            while(!checkVowel(chArr[j])){
                if(j>i) j--;
                else break restart;
            }
            
            //if i and j meet that means there is only 1 vowel which does not need to be reversed
            if(i>=j) break;
            
            //reverse ith & jth characters which are vowels
            char temp = chArr[i];
            chArr[i] = chArr[j];
            chArr[j] = temp;
            
            //move i to 1 step right and j to 1 step left
            i++;
            j--;
        }
        
        //convert char arr to string and return the ans
        StringBuilder ans = new StringBuilder();
        for(char ch: chArr){
            ans.append(ch);
        }
        
        return ans.toString();
    }
}