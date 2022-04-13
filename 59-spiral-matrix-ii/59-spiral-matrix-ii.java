class Solution {
    public int[][] generateMatrix(int n) {
        int[][] matrix = new int[n][n];
        
        int firstRow = 0;
        int firstCol = 0;
        int lastRow = n-1;
        int lastCol = n-1;
        
        int val = 1;
        
        for( ; firstRow<=lastRow && firstCol<=lastCol; firstCol++){
            
            //first row
            for(int i=firstCol; i<=lastCol; i++){
                matrix[firstRow][i] = val;
                val++;
            }
            
            firstRow++;
            //last col
            for(int i=firstRow; i<=lastRow; i++){
                matrix[i][lastCol] = val;
                val++;
            }
            
            lastCol--;
            
            if(firstRow>lastRow || firstCol>lastCol){
                break;
            }
            
            //last row
            for(int i=lastCol; i>=firstCol; i--){
                matrix[lastRow][i] = val;
                val++;
            }
            
            lastRow--;
            //first col
            for(int i=lastRow; i>=firstRow; i--){
                matrix[i][firstCol] = val;
                val++;
            }
        }
        
        return matrix;
    }
}