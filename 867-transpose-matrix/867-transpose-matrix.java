class Solution {
    public int[][] transpose(int[][] matrix) {
        if(matrix.length == matrix[0].length){
            //square matrix make changes in same matrix
            for(int i=0; i<matrix.length; i++){
                for(int j=0; j<=i; j++){
                    swap(matrix, i, j, j, i);
                }
            }
            
            return matrix;
        }
        
        //non square, take new matrix
        int[][] res = new int[matrix[0].length][matrix.length];
        for(int i=0; i<matrix.length; i++){
            for(int j=0; j<matrix[0].length; j++){
                res[j][i] = matrix[i][j];
            }
        }
        
        return res;
    }
    
    public void swap(int[][] matrix, int i, int j, int k, int l){
        int temp = matrix[i][j];
        matrix[i][j] = matrix[k][l];
        matrix[k][l] = temp;
    }
}