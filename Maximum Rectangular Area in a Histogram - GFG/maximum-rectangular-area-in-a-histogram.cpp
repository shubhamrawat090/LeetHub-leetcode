//{ Driver Code Starts
#include <bits/stdc++.h>
using namespace std;


// } Driver Code Ends
class Solution
{
    public:
    //Function to find largest rectangular area possible in a given histogram.
    long long getMaxArea(long long arr[], int n)
    {
        // Your code here
        vector<int> nextSm = nextSmaller(arr, n);
        vector<int> prevSm = previousSmaller(arr, n);
        
        long long maxArea = -1;
        for(int i=0; i<n; i++) {
            long long width = arr[i];
            long long height = nextSm[i] - prevSm[i] - 1;
            long long area = width * height;
            maxArea = max(area, maxArea);
        }
        
        return maxArea;
    }
    
    vector<int> nextSmaller(long long arr[], int &n) {
        stack<long long> stk;
        stk.push(-1);
        vector<int> ans(n);
        
        for(int i=n-1; i>=0; i--) {
            long long curr = arr[i];
            while(!stk.empty() && stk.top() != -1 && curr <= arr[stk.top()]) {
                stk.pop();
            }
            if(stk.empty()) {
                ans[i] = -1;
            } else {
                ans[i] = stk.top();
            }
            stk.push(i);
        }
        
        for(int i=0; i<n; i++) {
            if(ans[i] == -1) {
                ans[i] = n;
            }
        }
        
        return ans;
    }
    
    vector<int> previousSmaller(long long arr[], int &n) {
        stack<long long> stk;
        stk.push(-1);
        vector<int> ans(n);
        
        for(int i=0; i<n; i++) {
            long long curr = arr[i];
            while(!stk.empty() && stk.top() != -1 && curr <= arr[stk.top()]) {
                stk.pop();
            }
            if(stk.empty()) {
                ans[i] = -1;
            } else {
                ans[i] = stk.top();
            }
            stk.push(i);
        }
        
        return ans;
    }
};


//{ Driver Code Starts.

int main()
 {
    long long t;

    cin>>t;
    while(t--)
    {
        int n;
        cin>>n;
        
        long long arr[n];
        for(int i=0;i<n;i++)
            cin>>arr[i];
        Solution ob;
        cout<<ob.getMaxArea(arr, n)<<endl;
    
    }
	return 0;
}

// } Driver Code Ends