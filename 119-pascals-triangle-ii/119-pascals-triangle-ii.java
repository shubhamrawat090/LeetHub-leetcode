class Solution {
    public List<Integer> getRow(int rowIndex) {
        // in 1 based indexing
        // nth row rth col element is found by using nCr which is the value
        // Combination (n-1, r-1), like 5th row 3 col = comb(4,2)
        List<Integer> ans = new ArrayList<>();
        
        for(int i=0; i<=rowIndex; i++){
            if(i==0 || i==rowIndex){
                ans.add(1);
            }else{
                int val = combination(rowIndex, i);
                ans.add(val);
            }
        }
        
        return ans;
    }
    
    private int combination(int n, int r){
        long res = 1;
        for(int i=0; i<r; i++){
            res *= (n-i);
            res /= (i+1);
        }
        return (int)res;
    }
}