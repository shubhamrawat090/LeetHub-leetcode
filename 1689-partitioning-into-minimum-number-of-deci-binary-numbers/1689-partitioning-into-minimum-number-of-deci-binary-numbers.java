class Solution {
    public int minPartitions(String n) {
        for(int dig=9; dig>=1; dig--) {
            for(int i=0; i<n.length(); i++) {
                if(n.charAt(i)-'0' == dig) {
                    return dig;
                }
            }
        }
        
        return 0;
    }
}