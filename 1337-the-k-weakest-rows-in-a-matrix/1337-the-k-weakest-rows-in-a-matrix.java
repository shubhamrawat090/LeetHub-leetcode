class Solution {
    public int[] kWeakestRows(int[][] mat, int k) {
        int[] soldierNum = new int[mat.length];
        
        for(int i=0; i<mat.length; i++){
            int soldiers=0;
            for(int j=0; j<mat[0].length; j++){
                if(mat[i][j]==1) soldiers++;
                else break;
            }
            //we have added i because in case of same no. of soldiers the lower value of i will be considered weaker
            soldierNum[i] = soldiers*100 + i;
        }
        
        Arrays.sort(soldierNum);//sort to get weakest -> strongest soldiers
        
        int[] ans = new int[k];//stores our ans
        
        for(int i=0; i<k; i++){
            ans[i] = soldierNum[i]%100;
        }
        
        return ans;
    }
}