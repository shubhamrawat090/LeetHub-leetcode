class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        //iterators for nums1, nums2 and mergedArr(nums1 starting from end)
        int itr1 = m-1, itr2 = n-1, i=m+n-1;
        
        //iterate from back till either nums1(m->0) or nums2(n->0) is fully traversed
        while(itr1>=0 && itr2>=0) {
            //if nums1 has greater value then add its value to nums1[i] and decrement itr1 and i
            if(nums1[itr1] > nums2[itr2]) {
                nums1[i--] = nums1[itr1--];
            }
            //otherwise add its value to nums1[i] and increment itr2 and i
            else {
                nums1[i--] = nums2[itr2--];
            }
        }
        
        //if there is any value left in nums1, add it to nums1[i]
        while(itr1>=0) {
            nums1[i--] = nums1[itr1--];
        }
        //if there is any value left in nums2, add it to nums1[i]
        while(itr2>=0) {
            nums1[i--] = nums2[itr2--];
        }
    }
}