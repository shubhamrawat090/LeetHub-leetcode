class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
    
        int total = nums1.length + nums2.length;
        int half = (total + 1)/2;

        if(nums1.length < nums2.length){

            return findMedianSortedArrays(nums1, nums2, half, total);
        }else{

             return findMedianSortedArrays(nums2, nums1, half, total);
        }


    }


       public double findMedianSortedArrays(int[] A, int[] B, int half, int total) {

        int left = 0, right = A.length;

           while(left <= right){

               int midA = (left + right) /2;
               int midB = half - midA;

               int ALeft = midA > 0 ? A[midA - 1] : Integer.MIN_VALUE;
               int ARight = midA < A.length ? A[midA] : Integer.MAX_VALUE;

               int BLeft = midB > 0 ? B[midB - 1 ] : Integer.MIN_VALUE;
               int BRight = midB < B.length ? B[midB] : Integer.MAX_VALUE;


               if(ALeft <= BRight && BLeft <= ARight ){
                   if(total%2 == 1)
                       return Math.max(ALeft, BLeft);
                   else 
                       return (double) (Math.max(ALeft, BLeft) + Math.min(ARight, BRight)) / 2;

               }
               else if (ALeft > BRight) 
                   right = midA - 1;
               else 
                   left = midA + 1;

           }

        return 0.0;
    }
}