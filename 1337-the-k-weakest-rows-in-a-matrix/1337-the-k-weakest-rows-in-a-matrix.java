class Solution {
    public int[] kWeakestRows(int[][] mat, int k) {
        int[] soldierNum = new int[mat.length];
        int ctr = 0;
        for(int[] arr: mat){
            int soldiers=0;
            for(int i=0; i<arr.length; i++){
                if(arr[i]==1) soldiers++;
                else break;
            }
            //we have added i because in case of same no. of soldiers the lower value of i will be considered weaker
            soldierNum[ctr] = soldiers*100 + ctr;
            ctr++;
        }
        
        Arrays.sort(soldierNum);//sort to get weakest -> strongest soldiers
        
        int[] ans = new int[k];//stores our ans
        
        for(int i=0; i<k; i++){
            ans[i] = soldierNum[i]%100;
        }
        
        return ans;
    }
}