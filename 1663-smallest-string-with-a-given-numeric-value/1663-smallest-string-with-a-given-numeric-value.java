class Solution {
    public String getSmallestString(int n, int k) {
        //using character arr as string operations can be costlier
        //size = n as only n no. of characters are allowed
        char[] c = new char[n];
        
        //iterate from last as the char to pace will be at position i if we iterate from last
        for(int i=n-1; i>=0; i--){
            //if k-i is not out of range from a-z then only take it otherwise take 26 i.e. 'z'
            int val = Math.min(26, k-i);
            
            c[i] = (char)('a'+val-1);//-1 is done to keep value in range of a-z
            k -= val; 
            // remaining val = k-(our placed char's val), as total sum of chars should be less than k
        }
        
        return new String(c);//convert char[] to String and return it
    }
}