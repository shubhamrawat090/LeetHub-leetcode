class Solution {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> ans = new ArrayList<List<Integer>>();
        List<Integer> currRow, prevRow = null;
        
        for(int i=0; i<numRows; i++){
            currRow = new ArrayList<Integer>();
            for(int j=0; j<=i; j++){
                if(j==0 || j==i){
                    currRow.add(1);
                }else{
                    currRow.add(prevRow.get(j-1) + prevRow.get(j));
                }
            }
            
            prevRow = currRow;
            ans.add(currRow);
        }
        
        return ans;
    }
}