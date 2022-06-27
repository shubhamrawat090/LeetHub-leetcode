class Solution {
    public int minPartitions(String n) {
        for(int dig=9; dig>=1; dig--) {
            if(n.contains(String.valueOf(dig))) {
                return dig;
            }
        }
        
        return 0;
    }
}