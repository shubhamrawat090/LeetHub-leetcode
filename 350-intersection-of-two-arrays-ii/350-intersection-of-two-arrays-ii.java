class Solution {
    public int[] intersect(int[] nums1, int[] nums2) {
        List<Integer> ans = new ArrayList<>();
        HashMap<Integer, Integer> map1 = new HashMap<>();
        HashMap<Integer, Integer> map2 = new HashMap<>();
        
        //frequency map for nums1
        for(int i=0; i<nums1.length; i++){
            int val = nums1[i];
            if(map1.containsKey(val)){
                map1.put(val, map1.get(val)+1);
            }else{
                map1.put(val, 1);
            }
        }
        //frequency map for nums2
        for(int i=0; i<nums2.length; i++){
            int val = nums2[i];
            if(map2.containsKey(val)){
                map2.put(val, map2.get(val)+1);
            }else{
                map2.put(val, 1);
            }
        }
        
        for(int key: map1.keySet()){
            if(map2.containsKey(key)){
                int minFreq = Math.min(map1.get(key), map2.get(key));
                
                while(minFreq-->0){
                    ans.add(key);
                }
            }
        }
        
        int[] finalAns = new int[ans.size()];
        for(int i=0; i<ans.size(); i++){
            finalAns[i] = ans.get(i);
        }
        
        return finalAns;
    }
}