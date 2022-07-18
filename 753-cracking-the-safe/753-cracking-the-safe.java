//////// HAMILTONIAN PATH IMPLEMENTATION //////////
/* If we consider all the passwords like 00, 01, 11, 10 for n=2, k=2
   we can see that all passwords(or vtx of a graph) are visited 
   and no password is visited more than once */

class Solution {
    public String crackSafe(int n, int k) {
        StringBuilder ans = new StringBuilder();
        // first string is "0000....n times"
        for(int i=0; i<n; i++) {
            ans.append('0');
        }
        
        int lim = (int)Math.pow(k, n); //total no. of passwords possible with n places and k characters
        
        HashSet<String> vis = new HashSet<>();
        //add first string to vis
        vis.add(ans.toString());
        
        dfs(n, k, ans, vis, lim);
        
        return ans.toString();
    }
    
    private boolean dfs(int n, int k, StringBuilder ans, HashSet<String> vis, int lim) {
        if(vis.size() == lim) {
            //answer found
            return true;
        }
        
        String lnm1 = ans.substring(ans.length() - (n - 1)); //last n-1 characters
        
        for(int i=0; i<k; i++) {
            String nPwd = lnm1 + i; //adding i to last n-1 characters
            
            if(!vis.contains(nPwd)) {
                vis.add(nPwd);
                ans.append(i);
                
                boolean flag = dfs(n, k, ans, vis, lim);
                
                if(flag == true) {
                    // lnm1 + i combinations will eventually lead to the required string combination
                    return true;
                }
                
                // lnm1 + i combination did not find the req. str
                // backtrack -> remove from ans and vis
                vis.remove(nPwd);
                ans.deleteCharAt(ans.length() - 1);
            }
        }
        
        return false; // required string combination cannot be found
    }
}