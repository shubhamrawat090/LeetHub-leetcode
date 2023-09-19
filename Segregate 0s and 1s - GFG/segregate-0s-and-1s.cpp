//{ Driver Code Starts
//Initial template for C++

#include <bits/stdc++.h>
using namespace std;

// } Driver Code Ends
//User function template for C++

class Solution{   
public:
    void segregate0and1(int input[], int size) {
        // code here
        int zeroPtr = 0, onePtr = size - 1;
        while(zeroPtr < onePtr) {
            // Move zeroPtr to right till you get 0's
            while(zeroPtr < size && input[zeroPtr] == 0) zeroPtr++; 
            // Move onePtr to left till you get 1's
            while(onePtr < size && input[onePtr] == 1) onePtr--; 
    
            // Break out of the loop if the pointers cross each other
            if(zeroPtr >= onePtr) break;
    
            // Swap zeroPtr, onePtr
            swap(input[zeroPtr], input[onePtr]);
            
            zeroPtr++;
            onePtr--;
        }
    }
};

//{ Driver Code Starts.

int main() {
    int t;
    cin >> t;
    while (t--) {
        int n;
        cin >> n;
        int arr[n];
        for (int i = 0; i < n; i++) {
            cin >> arr[i];
        }
        Solution ob;
        ob.segregate0and1(arr, n);
        for (int i = 0; i < n; i++) {
            cout << arr[i] << " ";
        }
        cout << "\n";
    }
    return 0;
}
// } Driver Code Ends