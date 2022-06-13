// TABULATION 1-D DP
class Solution {
    public int minimumTotal(List<List<Integer>> triangle) {
        if(triangle==null) 
            return 0;
        
        int size = triangle.size(); 
        
        int[] dp = new int[size+1];
        
        dfs(dp,triangle,size-1);
        
        return dp[0];
        
    }
    
    private void dfs(int[] dp,List<List<Integer>> t,int row){
        if(row<0) 
            return;
        
        for(int j=0;j<=row;j++){
            dp[j] = t.get(row).get(j) + Math.min(dp[j], dp[j+1]);
        } 
        
        dfs(dp, t, row-1);
    }
}