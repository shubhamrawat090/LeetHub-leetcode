class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        
        //size of array
        int n = nums.length;
        
        //total number of subsets
        int totalSubsets = (int)Math.pow(2, n);
        
        //get all binary from 0 to 2^n
        for(int dec=0; dec<totalSubsets; dec++){
            
            //get binary representation of decimal
            int binaryNo = decimalToBinary(dec);
            
            // Subset
            List<Integer> subset = new ArrayList<>();
            
            //get number of digits in binary representation
            int div = (int)Math.pow(10, n-1);
            for(int i=0; i<n; i++){
                //get individual digits of binary and at that place if digit is 1 include element 
                // for 0 0 1 => don't include arr[0] and arr[1], include arr[2]
                int quot = binaryNo / div;
                if(quot % 10 == 1){
                    //include the number as in binary representation the bit is 1
                    subset.add(nums[i]);
                } 
                div = div / 10;
            }
            ans.add(subset);
        }
        
        return ans;
        
    }
    
    //function to convert decimal to binary
    private static int decimalToBinary(int dec)
    {
        int bin = 0, power = 1;
        while(dec > 0)
        {
            int dig = dec % 2;
            dec = dec / 2;
            bin = bin + dig * power;
            power = power * 10;
        }
        return bin;
    }
}