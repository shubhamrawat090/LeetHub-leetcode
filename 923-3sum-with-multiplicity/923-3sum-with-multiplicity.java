class Solution {
    public int threeSumMulti(int[] arr, int target) {
        int mod = 1000000007; //10^9 + 7
        long result = 0; //count of triplets
        
        //take 2 pointers i and j traversing the entire array
        for(int i=0; i<arr.length; i++){
            //keep count of all the elements in the array(0-100 is the limit in the question)
            int[] count = new int[101]; // can use HASHMAP here
            //for every number check its next no. till end 
            for(int j=i+1; j<arr.length; j++){
                //get a k value such that arr[i] + arr[j] + k = target
                int k = target - arr[i] - arr[j];
                //search for this k inside our array, also the k should be in range 0-100
                if(k>=0 && k<=100 && count[k]>0){
                    //if a k is found then the no. of such triplets is no. of k's present as each k can come one time to form a different triplet
                    result += count[k];
                    result %= mod; //mod is used to keep result from getting out of bounds
                }
                //store particular value encountered in our count array
                count[arr[j]]++;
            }
        }
        
        //convert result to int and return
        return (int)result;
    }
}