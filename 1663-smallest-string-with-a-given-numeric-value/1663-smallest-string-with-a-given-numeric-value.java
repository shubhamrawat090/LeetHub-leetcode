class Solution {
    public String getSmallestString(int n, int k) {
        // observation that ans is like : a.....a (some character) z.....z
        
        // we thing initially all characters are 'a',
        // then we check no. of 'z's to be placed
        // then we check if any place if left where neither 'a' nor 'z' can be filled, we fill it with other suitable character
        
        k = k - n;// 'a' takes up all places so k is reduced by n
        //we make groups of 25 to check no. of 'z' and not 26 because 1 value is reduced as it was filled by a
        int zcount = k/25;
        int value = k%25;// remaining value is neither 'a' nor 'z'
        
        char[] c = new char[n];
        Arrays.fill(c, 'a');
        int i=n-1; //iterating from end
        
        //filling z's from end
        while(zcount-->0){
            c[i--] = 'z'; 
        }
        
        if(value>0){
            //add only if value exists
            c[i--] = (char)('a'+value);
        }
        
        //fill remaining with 'a', this can be AVOIDED BY USING Arrays.fill(c, 'a');
        // while(i>=0){
        //     c[i--] = 'a';
        // }
        
        return new String(c);
    }
}