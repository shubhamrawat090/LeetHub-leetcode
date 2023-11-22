//{ Driver Code Starts
//Initial Template for C++

#include <bits/stdc++.h> 
using namespace std; 


// } Driver Code Ends
//User function Template for C++

class Solution{
    
    public:
    vector<int> help_classmate(vector<int> arr, int n) 
    { 
        // Your code goes here
        stack<int> stk;
        stk.push(-1);
        vector<int> ans(arr.size());
        
        for(int i=arr.size()-1; i>=0; i--) {
            int curr = arr[i];
            while(!stk.empty() && curr <= stk.top()) {
                stk.pop();
            }
            if(stk.empty()) {
                ans[i] = -1;
            } else {
                ans[i] = stk.top();
            }
            stk.push(curr);
        }
        
        return ans;
    } 
};

//{ Driver Code Starts.

int main() 
{ 
	int t;
	cin>>t;
	while(t--)
	{
		int n;
		cin>>n;
		vector<int> array(n);
		for (int i = 0; i < n; ++i)
		{
			cin>>array[i];
		}
		Solution obj;
		vector<int> result = obj.help_classmate(array,n);
		for (int i = 0; i < n; ++i)
		{
			cout<<result[i]<<" ";
		}
		cout<<"\n";
	}
	return 0; 
}


// } Driver Code Ends