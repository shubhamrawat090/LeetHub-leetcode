/*
C: constructor: int[] nums, int k
api add, add a new val in output the kth largest num in the stream
A:1 <= k <= 104
0 <= nums.length <= 104
-104 <= nums[i] <= 104
-104 <= val <= 104
At most 104 calls will be made to add.
It is guaranteed that there will be at least k elements in the array when you search for the kth element.
R:use minHeap
for n in num, if minheap size < k offer
if minheap size >= k, if > peek, pop then offer
T: constructor TC:O(nlogk) SC:O(k)
add: TC:O(logk)
*/

class KthLargest {
    PriorityQueue<Integer> minHeap;
    int target;
    
    public KthLargest(int k, int[] nums) {
        minHeap = new PriorityQueue<>(k);
        for(int n : nums) {
            if(minHeap.size() < k) {
                minHeap.offer(n);
            } else if (n > minHeap.peek()) {
                minHeap.poll();
                minHeap.offer(n);
            }
        }
        this.target = k;
    }
    
    public int add(int val) {
        if(minHeap.size() < target) {
            minHeap.offer(val);
        } else if(val > minHeap.peek()) {
            minHeap.poll();
            minHeap.offer(val);
        }
        return minHeap.size() < target ? -1 : minHeap.peek();
    }
}