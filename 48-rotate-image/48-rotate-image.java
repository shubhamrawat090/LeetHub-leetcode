class Solution {
    public void rotate(int[][] matrix) {
        int n = matrix.length;
        int[][] tempMatrix = new int[n][n];
        //transpose matrix and store in temp matrix
        for(int i=0; i<n; i++) {
            for(int j=0; j<n; j++) {
                tempMatrix[j][i] = matrix[i][j];
            }
        }
        
        //reverse each row of transposed matrix
        for(int[] arr: tempMatrix) {
            int start=0, end=n-1;
            while(start < end) {
                int temp = arr[start];
                arr[start] = arr[end];
                arr[end] = temp;
                
                start++;
                end--;
            }
        }
        
        //copy temp matrix -> which is rotated by 90 degrees to our main matrix
        for(int i=0; i<n; i++) {
            for(int j=0; j<n; j++) {
                matrix[i][j] = tempMatrix[i][j];
            }
        }
    }
}