// If the return ArrayList does not count space then its space complexity is O(1).
// The time complexity is O(n) where n is the count of all grid items.

class Solution {
    public List<List<Integer>> shiftGrid(int[][] grid, int k) {
        int m = grid.length;
        int n = grid[0].length;
        int total = m * n;
        // if shifting total(m*n) times, it shifts back to orignal state
        k = k % total;
        //stores our final result
        List<List<Integer>> result = new ArrayList<>();
        for(int i = 0; i < m; i++) {
            //add an empty row to our 2d output list
            List<Integer> list = new ArrayList<>();
            result.add(list);
            for (int j = 0; j < n; j++) {  
                ////////////// 2D to 1D FLATTENNING /////////////////////
                // i * n + j original place index if we flatten our grid to 1D array
                // i*n is the no. of rows above our element
                // j is the no. of cols in our row
                // i*n + j is the total values shifted from 0,0 starting position which is also our idx in 1d arr
                // E.g. [1,3,4,5], 4 is shifted 2 times from starting 0 position which is also its idx in 1d arr
                int originalIdxFlatten1D = i * n + j;
                
                /////////////// 1D to 2D FOLDING //////////////////////
                // position of our element in 2D grid
                // i * n + j - k  is to get value k steps before                 
                int index = (originalIdxFlatten1D - k + total) % total;
                list.add(grid[index / n][index % n]);
            }
        }
        return result;
    }
}