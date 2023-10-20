//{ Driver Code Starts
#include<bits/stdc++.h>
using namespace std;



// } Driver Code Ends
class Solution
{
    public:
    //Function to find the maximum number of cuts.
    int maximizeTheCuts(int n, int x, int y, int z)
    {
        //Your code here
        int dp[n+1];
        for(int i=0; i<=n; i++) {
            dp[i] = -1;
        }
        return max(0, helper(n, x, y, z, dp));
    }
    
    int helper(int n, int x, int y, int z, int dp[]) {
        if(n == 0) {
            return dp[n] = 0;
        }
        
        if(n < 0) {
            return INT_MIN;
        }
        
        if(dp[n] != -1) {
            return dp[n];
        }
        
        int xCut = 1 + helper(n-x, x, y, z, dp); 
        int yCut = 1 + helper(n-y, x, y, z, dp);
        int zCut = 1 + helper(n-z, x, y, z, dp);
        
        return dp[n] = max(xCut, max(yCut, zCut));
    }
};

//{ Driver Code Starts.
int main() {
    
    //taking testcases
    int t;
    cin >> t;
    while(t--)
    {
        //taking length of line segment
        int n;
        cin >> n;
        
        //taking types of segments
        int x,y,z;
        cin>>x>>y>>z;
        Solution obj;
        //calling function maximizeTheCuts()
        cout<<obj.maximizeTheCuts(n,x,y,z)<<endl;

    }

	return 0;
}
// } Driver Code Ends