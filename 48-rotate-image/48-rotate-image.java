class Solution {
    public void rotate(int[][] matrix) {
        int n = matrix.length;
        int[][] tempMatrix = new int[n][n];
        
        int row = 0, col = n-1;
        
        while(row<n || col>=0) {
            for(int i=0; i<n; i++) {
                tempMatrix[i][col] = matrix[row][i];
            }
            
            row++;
            col--;
        }
        
        for(int i=0; i<n; i++) {
            for(int j=0; j<n; j++) {
                matrix[i][j] = tempMatrix[i][j];
            }
        }
    }
}