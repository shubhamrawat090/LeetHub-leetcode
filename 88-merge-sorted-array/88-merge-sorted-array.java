class Solution {
    public void merge(int[] arr1, int n, int[] arr2, int m) {
        int k;
        if(m == 0) {
            return;
        }
        for (int i = 0; i < n; i++) {
          // take first element from arr1 
          // compare it with first element of second array
          // if condition match, then swap
          if (arr1[i] > arr2[0]) {
            int temp = arr1[i];
            arr1[i] = arr2[0];
            arr2[0] = temp;
          }

          // then sort the second array
          // put the element in its correct position
          // so that next cycle can swap elements correctly
          int first = arr2[0];
          // insertion sort is used here
          for (k = 1; k < m && arr2[k] < first; k++) {
            arr2[k - 1] = arr2[k];
          }
          arr2[k - 1] = first;
        }
        
        int itr1 = n;
        for(int j=0; j<m; j++) {
            arr1[itr1] = arr2[j];
            itr1++;
        }
        
    }
}