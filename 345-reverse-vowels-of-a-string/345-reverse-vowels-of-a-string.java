class Solution {
    private boolean checkVowel(char ch){
        return (ch=='a' || ch=='e' || ch=='i' || ch=='o' || ch == 'u' || ch=='A' || ch=='E' || ch=='I' || ch=='O' || ch == 'U');
    }
    public String reverseVowels(String s) {
        char[] chArr = s.toCharArray();
        int i=0, j=chArr.length-1;
        
        while(i<j){
            while(i<j && !checkVowel(chArr[i])){
                i++;
            }
            
            while(j>i && !checkVowel(chArr[j])){
                j--;
            }
            
            if(i>=j) break;
            
            char temp = chArr[i];
            chArr[i] = chArr[j];
            chArr[j] = temp;
            
            i++;
            j--;
        }
        
        StringBuilder ans = new StringBuilder();
        for(char ch: chArr){
            ans.append(ch);
        }
        
        return ans.toString();
    }
}