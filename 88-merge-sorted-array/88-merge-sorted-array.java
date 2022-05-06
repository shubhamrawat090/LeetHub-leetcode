// Gap Method
// Time: O(logN), Space: O(1)
class Solution {
    public void swap(int[] ar1, int[] ar2, int i, int j)
    {
        int temp = ar1[i];
        ar1[i] = ar2[j];
        ar2[j] = temp;
    }
    
    public void merge(int[] ar1, int n, int[] ar2, int m) {
        int gap =(int) Math.ceil((double)(n + m) / 2.0);
        
        while (gap > 0) {
            int i = 0;
            int j = gap;
            
            while (j < (n + m)) {
                if (j < n && ar1[i] > ar1[j]) {
                    swap(ar1, ar1, i, j);
                } else if (j >= n && i < n && ar1[i] > ar2[j - n]) {
                    swap(ar1, ar2, i, j-n);
                } else if (j >= n && i >= n && ar2[i - n] > ar2[j - n]) {
                    swap(ar2, ar2, i - n, j - n);
                }
                j++;
                i++;
            }
            
            if (gap == 1) {
                gap = 0;
            } else {
                gap =(int) Math.ceil((double) gap / 2.0);
            }
        }

        int itr1 = n;
        for(int j=0; j<m; j++) {
            ar1[itr1] = ar2[j];
            itr1++;
        } 
    }
}