class Solution {
    
    public int countValidWords(String sentence) {
        //separating all the words and storing it in an array
        //something like, "this is a sentence" => {"this", "is", "a", "sentence"}
        String[] words = sentence.split(" ");
        
        //initially there are not valid words
        int validWords = 0;
        
        for(String word: words){
            //no word present
            if(word.equals("")) continue;
            
            //initially we assume the current word is valid and there is not hyphen condition violation
            boolean valid = true, hyphen = false;
            
            //traversing each character of word
            for(int i = 0; i < word.length();i++){
                char ch = word.charAt(i);
                
                //if ch is from a-z i.e. lowercase characters
                if(ch>='a' && ch<='z')
                    continue;
                //if ch is a digit then it is not valid character => valid=false
                if(ch >= '0' && ch <= '9'){
                    valid = false;
                    //no need to check for characters further
                    break;
                }
                //hyphen encountered
                if(ch == '-'){
                    //if hyphen is already true this means we encountered a hyphen before and count of hyphen should be less than 1
                    if(hyphen){
                        valid = false;
                        //no need to check further
                        break;
                    }
                    //if hyphen is at beginning or end then it is not a valid character
                    if(i == 0 || i == word.length()-1){
                        valid = false;
                        //no need to check further
                        break;
                    }
                    //if hyphen is not surrounded by lowercase character then also it is not a valid character
                    char prevChar = word.charAt(i-1);
                    char nextChar = word.charAt(i+1);
                    if(!((prevChar>='a' && prevChar<='z') && (nextChar>='a' && nextChar<='z'))){
                        valid = false;
                        //no need to check further
                        break;
                    }
                    //if all of the above conditions is false it means first time hyphen is encountered and it is surrounded by lowercase characters
                    hyphen = true;
                }
                //punctuations encountered
                if(ch == '!' || ch == ',' || ch == '.'){
                    //if punctuations are not at the end of word it means word is invalid
                    if(i != word.length()-1){
                        valid = false;
                        break;
                    }
                }
            }
            //if all the above conditions are bypassed then it means the valid flag is unchanged meaning that our word is valid and has passed all the above checks
            if(valid){
                //count it as a valid word
                validWords++;
            }
            
        }
        
        //return the count of valid words
        return validWords;
    }
}