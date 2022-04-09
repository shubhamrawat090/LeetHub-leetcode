class Solution {
//     public int[] topKFrequent(int[] nums, int k) {
//         PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> b[1] - a[1]);
        
//         Map<Integer, Integer> freq = new HashMap<>();
//         for(int num : nums) 
//             freq.put(num, freq.getOrDefault(num, 0) + 1);
        
//         for(Map.Entry<Integer, Integer> e : freq.entrySet()) 
//             pq.offer(new int[] {e.getKey(), e.getValue()});
        
//         int[] result = new int[k];
        
//         while(k-- > 0) {
//             result[k] = (pq.poll())[0];
//         }
        
//         return result;
//     }
    
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        
        for(int val: nums){
            //if value exists then get it and add 1 to it
            //otherwise put 0 and add 1 to it
            map.put(val, map.getOrDefault(val, 0) + 1);
        }
        
        //prioritizing map entries based on higher occurrence
        PriorityQueue<Map.Entry<Integer, Integer>> maxHeap = new PriorityQueue<>((a,b)->b.getValue()-a.getValue());
        
        //adding map entries where higher values of occurrence are at first
        for(Map.Entry entry: map.entrySet()){
            maxHeap.add(entry);
        }
        
        //output arr of k size
        int[] ans = new int[k];
        //delete first element from maxHeap and add it's key(value in nums array and not the occurrence) to output arr 
        for(int i=0; i<k; i++){
            ans[i] = maxHeap.poll().getKey();
        }
        
        return ans;
    }
}