class Solution {
    public List<String> letterCombinations(String digits) {
        //return empty list if digits string is empty
        if(digits.isEmpty()) return new ArrayList<>();
        
        //return the answer from helper function
        return helper("", digits);
    }
    
    //recursive function contains two arguments: processed & unprocessed
    //initially processed is empty and unprocessed is the entire string(digits)
    private List<String> helper(String p, String up){
        
        //when unprocessed is empty, there is an answer in processed
        //just add it in a list and return it
        if(up.isEmpty()){
            List<String> list = new ArrayList<>();
            list.add(p);
            return list;
        }
        
        //gets the first character of unprocessed and converts it to equivalent digit
        //like '2' to 2
        int digit = up.charAt(0) - '0';
        
        //list for storing all the answers
        List<String> list = new ArrayList<>();
        
        //starting & ending indices for function calls, used to get the corresponding character to the digit
        int startIdx = (digit-2)*3, endIdx = (digit-1)*3;
        
        //7, 8, 9 have slight alterations as 7 and 9 contains 4 characters each
        //this changes the range for 7,8,9 as mentioned below
        if(digit == 7){
            endIdx++;
        }else if(digit == 8){
            startIdx++;
            endIdx++;
        }else if(digit == 9){
            startIdx++;
            endIdx+=2;
        }
        
        //e.g. for digit=6 loop runs from 
        //i = 12((6-2)*3) to i < 15((6-1)*3), with changes for digit = 7,8,9
        for(int i=startIdx; i<endIdx && i<=25; i++){
            //last alphabet 'z'='a'+25
            //i=26,27... out of range of alphabets (a-z) so skip i>25
            
            //'a'+0 = 'a'
            //'a'+1 = 'b'
            //and so on till 'a'+25='z'
             char ch = (char)('a'+i);
            
            //add all the answers coming from recursive calls to our list
            //add ch to processed, and remove 1 character from unprocessed as it is processed now
            list.addAll(helper(p+ch, up.substring(1)));
        }
        
        //return final list
        return list;
    }
}