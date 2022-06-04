class Solution {
    public List<Integer> intersection(int[][] nums) {
        if (nums == null || nums.length == 0) {
            return new ArrayList<>();
        } 
        
        int len = nums.length;
        
        int[] freq = new int[1001];
        for (int[] arr : nums) {
            for (int n : arr) {
                freq[n]++;
            }
        }
        
        List<Integer> res = new ArrayList<>();
        for (int i = 1; i <= 1000; i++) {
            if (freq[i] == len) {
                res.add(i);
            }
        }
        
        return res;
    }
}