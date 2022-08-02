class Solution {
    public List<Integer> majorityElement(int[] nums) {
        HashMap<Integer, Integer> map = new HashMap<>();
        
        for(int num: nums) {
            map.put(num, map.getOrDefault(num, 0)+1);
        }
        
        List<Integer> res = new ArrayList<>();
        for(int num: map.keySet()) {
            if(map.get(num) > nums.length/3) {
                res.add(num);
            }
        }
        
        return res;
    }
}