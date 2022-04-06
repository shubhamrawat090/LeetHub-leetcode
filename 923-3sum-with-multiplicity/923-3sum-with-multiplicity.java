class Solution {
    public int threeSumMulti(int[] arr, int target) {
        int mod = 1000000007; //10^9 + 7
        long result = 0; //count of triplets
        long[] count = new long[101];
        
        for(int val: arr) count[val]++; // store occurrences of each value in array
        
        //take 2 pointers i and j from 0-100
        for(int i=0; i<=100; i++){
            for(int j=i; j<=100; j++){
                //get a k value such that i + j + k = target
                int k = target - i - j;
                
                if(k<0 || k>100) continue; // skip values outside range 0-100
                
                // 3 cases for i and j and k
                
                // FIRST, i==j==k, C(n,3) = n!/3!(n-3)! = n*(n-1)*(n-2)/6
                if(i==j && j==k){//all same
                    result += (count[i] * (count[i]-1) * (count[i]-2))/6;
                    result %= mod;
                }
                
                // SECOND, i==j!=k, C(n,2)*count[k] = n!/2!(n-2)!*count[k] = n*(n-1)/2*count[k]
                else if(i==j && j!=k){//1 different
                    result += ((count[i] * (count[i]-1))/2)*count[k];
                    result %= mod;
                }
                
                // THIRD, i<j<k, count[i]*count[j]*count[k]
                else if(i<j && j<k){//all different
                    result += count[i]*count[j]*count[k];
                    result %= mod;
                }
            }
        }
        
        //convert result to int, keep result in range with mod and return
        return (int)(result%mod);
    }
}