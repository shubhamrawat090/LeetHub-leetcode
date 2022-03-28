class Solution {
    public boolean search(int[] nums, int target) {
        //find pivot which is the point where our array is partitioned
        int pivot = findPivotWithDuplicates(nums);

        // if you did not find a pivot, it means the array is not rotated
        if (pivot == -1) {
            // just do normal binary search
            return binarySearch(nums, target, 0 , nums.length - 1);
        }

        // if pivot is found, you have found 2 asc sorted arrays
        if (nums[pivot] == target) {
            //the element at pivot is our target
            return true;
        }

        //we know that pivot is not our target so we can skip it 
        //which is why we search in the ranges [0, pivot-1], [pivot+1, nums.length-1]
        if (target >= nums[0]) {
            //if target is less that the first element then it is not in the left sorted array as it was in ascending and our target is less than the least element itself
            return binarySearch(nums, target, 0, pivot - 1);
        }

        //if we do not find our target in the left sorted arr, then search the right asc sorted arr
        return binarySearch(nums, target, pivot + 1, nums.length - 1);
        
    }
    
    int findPivotWithDuplicates(int[] arr) {
        int start = 0;
        int end = arr.length - 1;
        while (start <= end) {
            int mid = start + (end - start) / 2;
            // 4 cases over here
            if (mid < end && arr[mid] > arr[mid + 1]) {
                return mid;
            }
            if (mid > start && arr[mid] < arr[mid - 1]) {
                return mid-1;
            }

            // if elements at middle, start, end are equal then just skip the duplicates
            if (arr[mid] == arr[start] && arr[mid] == arr[end]) {
                // skip the duplicates
                // NOTE: what if these elements at start and end were the pivot??
                // check if start is pivot
                if (start < end && arr[start] > arr[start + 1]) {
                    return start;
                }
                start++;

                // check whether end is pivot
                if (end > start && arr[end] < arr[end - 1]) {
                    return end - 1;
                }
                end--;
            }
            // left side is sorted, so pivot should be in right
            else if(arr[start] < arr[mid] || (arr[start] == arr[mid] && arr[mid] > arr[end])) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }
        return -1;
    }
    
    boolean binarySearch(int[] arr, int target, int start, int end) {
        while(start <= end) {
            // find the middle element
            // int mid = (start + end) / 2; 
            // might be possible that (start + end) exceeds the range of int in java
            int mid = start + (end - start) / 2;

            if(arr[mid] == target){
                //element found at mid
                return true;
            }else if(target < arr[mid]){
                //target on left side
                end = mid - 1;
            }else{
                //target on right side
                start = mid + 1;
            }
        }
        return false;
    }
}