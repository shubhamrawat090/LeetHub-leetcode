class Solution {
    public int[] intersect(int[] nums1, int[] nums2) {
        //frequency array for nums1
        int[] arr = new int[1001];
        for (int i = 0; i < nums1.length; i++) {
            arr[nums1[i]]++;
        }
        //stores answer
        ArrayList<Integer> al = new ArrayList<Integer>();
        
        /*traverse through nums2 and check in frequency array of nums1 that if the values of nums2 are present in it, if that is the case then add that value in our ans list and subtract 1 from frequency as this value is processed 1 time*/
        for (int i = 0; i < nums2.length; i++) {
            if (arr[nums2[i]] > 0) {
                arr[nums2[i]]--;
                al.add(nums2[i]);
            }
        }
        //converting array list to array(we can use a new array as well I have used the frequency array reference variable only as the need for it was finished so this variable can be reused)
        arr = new int[al.size()];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = al.get(i);
        }
        //return final ans
        return arr;
    }
}