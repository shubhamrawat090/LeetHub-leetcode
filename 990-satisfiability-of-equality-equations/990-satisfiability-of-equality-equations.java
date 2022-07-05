class Solution {
    int[] parent;
    int[] rank;
    
    public boolean equationsPossible(String[] equations) {
        parent = new int[26];
        rank = new int[26];
        
        //initializing rank and parents of each component
        for(int i=0; i<26; i++) {
            parent[i] = i;
            rank[i] = 0;
        }
        
        //traversing the equations and equating "==" operands in 1 set
        for(String eq: equations) {
            if(eq.charAt(1) == '=') {
                //separating operands
                int op1 = eq.charAt(0) - 'a';
                int op2 = eq.charAt(3) - 'a';

                //finding the leader of the set that operands belong to
                int l1 = find(op1);
                int l2 = find(op2);

                //UNION the 2 different leaders
                if(l1 != l2) {
                    union(l1, l2);
                }
            }
        }
        
        //traversing and checking the "!=" operands and checking if they satisfy the condition
        for(String eq: equations) {
            //checking != conditions for their validity
            if(eq.charAt(1) == '!') {
                //separating operands
                int op1 = eq.charAt(0) - 'a';
                int op2 = eq.charAt(3) - 'a';

                //finding the leader of the set that operands belong to
                int l1 = find(op1);
                int l2 = find(op2);

                //if the 2 operands belong to the same set, then they are equal
                if(l1 == l2) {
                    return false;
                }
            }
        }
        
        return true;
    }
    
    int find(int val) {
        //val is the leader of the set, return it
        if(parent[val] == val) {
            return val;
        } else {
            // //can be written as 
            // int parentOfVal = parent[val];
            // int leader = find(parentOfVal);
            // parent[val] = leader;
            // return leader;
           
            parent[val] = find(parent[val]);
            return parent[val];
        }
    }
    
    void union(int x, int y) {
        if(rank[x] < rank[y]) {
            parent[x] = y;
        } else if(rank[x] > rank[y]) {
            parent[y] = x;
        } else {
            parent[x] = y;
            rank[y]++;
        }
    }
}