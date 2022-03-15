class Solution {
    public boolean isSubsequence(String smallStr, String bigStr) {
        int smallItr = 0; //iterator for small string
        int bigItr = 0; //iterator for big string
        
        //work till both small and big strings are traversed
        while(bigItr<bigStr.length() && smallItr<smallStr.length()){
            //traverse in small and big strings and check character by character
            //if a char of smallStr matches that of bigStr then increment smallItr
            if(smallStr.charAt(smallItr) == bigStr.charAt(bigItr)){
                smallItr++;
            }
            
            //increment bigItr always to maintain order of smallStr in bigStr
            bigItr++;
        }
        
        //if all characters of smallStr were found in bigStr then it would mean that smallItr = length of smallStr
        return smallItr == smallStr.length();
    }
}