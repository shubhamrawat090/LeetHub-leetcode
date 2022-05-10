class Solution {
    //freq array
    public int findDuplicate(int[] arr) {
        int n = arr.length;
        int[] freq = new int[n+1];
        
        for (int i = 0; i < n; i++) {
            if (freq[arr[i]] == 0) {
                freq[arr[i]] += 1;
            } else {
                return arr[i];
            }
        }
        
        return 0;
    }
}