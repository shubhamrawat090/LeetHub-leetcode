class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int[] mergedArr = new int[m+n];
        
        int itr1 = 0, itr2 = 0, i=0;
        
        while(itr1<m && itr2<n) {
            if(nums1[itr1] < nums2[itr2]) {
                mergedArr[i++] = nums1[itr1];
                itr1++;
            }else {
                mergedArr[i++] = nums2[itr2];
                itr2++;
            }
        }
        
        while(itr1<m) {
            mergedArr[i++] = nums1[itr1++];
        }
        
        while(itr2<n) {
            mergedArr[i++] = nums2[itr2++];
        }
        
        for(int j=0; j<m+n; j++) {
            nums1[j] = mergedArr[j];
        }
    }
}