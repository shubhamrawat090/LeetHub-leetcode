class Solution {
    public List<Integer> intersection(int[][] nums) {
        //make a frequency map
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int i=0; i<nums.length; i++) {
            for(int j=0; j<nums[i].length; j++) {
                if(!map.containsKey(nums[i][j])) {
                    map.put(nums[i][j], 1);
                } else {
                    map.put(nums[i][j], map.get(nums[i][j])+1);
                }
            }
        }
        
        //add only those values whose frequency is equal to length of nums array
        ArrayList<Integer> ans = new ArrayList<>();
        for(int key: map.keySet()) {
            if(map.get(key) == nums.length) {
                ans.add(key);
            }
        }
        
        Collections.sort(ans);
        return ans;
    }
}