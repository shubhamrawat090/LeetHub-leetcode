class Solution {
    public List<List<Integer>> generate(int numRows) {
        //contains our answer
        List<List<Integer>> ans = new ArrayList<List<Integer>>();
        //current row and previous row
        List<Integer> currRow, prevRow = null;
        
        //iterate till no. of rows
        for(int i=0; i<numRows; i++){
            //initialize empty row
            currRow = new ArrayList<Integer>();
            for(int j=0; j<=i; j++){
                //first and last element of row is 1
                if(j==0 || j==i){
                    currRow.add(1);
                }
                //take j-1 and j values from prevRow and add to get current row's element at j
                else{
                    currRow.add(prevRow.get(j-1) + prevRow.get(j));
                }
            }
            //store curr row in prev to work for next row
            prevRow = currRow;
            //store our current computed row in answer list
            ans.add(currRow);
        }
        //return answers list
        return ans;
    }
}