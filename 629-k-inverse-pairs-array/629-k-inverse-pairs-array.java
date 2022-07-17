class Solution {
    public int kInversePairs(int n, int k) {
        int[][] memo = new int[n+1][k+1];
    
        for(int[] m: memo) {
            Arrays.fill(m, -1);
        }
    
        return find(n,k, memo);
    }
    
    int mod = 1000000007;
    
    private int find(int n, int k, int[][] memo){
        if(n == 0) return k == 0 ? 1 : 0;	
        if(k < 0) return 0; 
        
        if(memo[n][k] != -1) return memo[n][k];   
        
		int val = (find(n-1, k, memo) + find(n, k-1, memo)) % mod;
        
        if(k - n >= 0) val = (val - find(n-1, k-n, memo) + mod) % mod;
        
        return memo[n][k] = val;
    }
}