class Solution {
    public List<Integer> getRow(int rowIndex) {
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