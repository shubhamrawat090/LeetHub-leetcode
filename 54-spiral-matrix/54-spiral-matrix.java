class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> list = new ArrayList<>();
        
        int firstRow = 0;
        int lastRow = matrix.length-1;
        int firstCol = 0;
        int lastCol = matrix[0].length-1;
        
        for( ; firstRow<=lastRow && firstCol<=lastCol; firstCol++){
            //first row
            for(int i=firstCol; i<=lastCol; i++){
                list.add(matrix[firstRow][i]);
            }
            
            firstRow++;
            //last col
            for(int i=firstRow; i<=lastRow; i++){
                list.add(matrix[i][lastCol]);
            }
            
            lastCol--;
            
            if(firstRow>lastRow || firstCol>lastCol){
                break;
            }
            
            //last row
            for(int i=lastCol; i>=firstCol; i--){
                list.add(matrix[lastRow][i]);
            }
            
            lastRow--;
            //firstCol
            for(int i=lastRow; i>=firstRow; i--){
                list.add(matrix[i][firstCol]);
            }
            //firstCol++ is not needed as it is already happening in outer for loop
        }
        
        return list;
    }
}