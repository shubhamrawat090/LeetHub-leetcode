class Solution {
    public int[] intersect(int[] nums1, int[] nums2) {
        //List for containing answer
        List<Integer> list = new ArrayList<>();
        
        //sort both arrays
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        
        //pointers for nums1 and nums2
        int i = 0, j = 0;
        
        //iterating both nums1 and nums2 simultaneously till any one of them is finished
        while (i < nums1.length && j < nums2.length) {
            //if the values match in both arr then it is a part of intersection
            if (nums1[i] == nums2[j]) {
                //add that value in intersection list
                list.add(nums1[i]);
                //increment both pointers
                i++; j++;
            } 
            //if val of nums1 < val of nums2, val of nums1 will never occur in nums2 as both arr are sorted, so move nums1 ptr 1 step ahead
            else if (nums1[i] < nums2[j]) {
                i++;
            }
            //if val of nums2 < val of nums1, val of nums2 will never occur in nums1 as both arr are sorted, so move nums2 ptr 2 step ahead
            else {
                j++;
            }
        }
        
        //converting list to array
        int[] res = new int[list.size()];
    
        for (int x = 0; x < list.size(); ++x) {
            res[x] = list.get(x);
        }
        //return final ans
        return res;
    }
}