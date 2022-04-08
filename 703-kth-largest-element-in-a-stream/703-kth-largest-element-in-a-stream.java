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
    PriorityQueue<Integer> minHeap; //will keep the list already sorted which is why minHeap is used
    int target; //k value
    
    public KthLargest(int k, int[] nums) {
        minHeap = new PriorityQueue<>(k); //keep only k elements where kth largest is at top
        
        for(int n : nums) {
            if(minHeap.size() < k) {
                //add our element if less than k elements are inside heap
                minHeap.offer(n);
            } else if (n > minHeap.peek()) {
                //if our element is greater that top of minHeap it means this element is kth largest so add it
                minHeap.poll();// delete top element
                minHeap.offer(n);// add our element at top
            }
        }
        
        //set our target to k
        this.target = k;
    }
    
    public int add(int val) {
        if(minHeap.size() < target) {
            //add our element if less than k elements are inside heap
            minHeap.offer(val);
        } else if (val > minHeap.peek()) {
            //if our element is greater that top of minHeap it means this element is kth largest so add it
            minHeap.poll();// delete top element
            minHeap.offer(val);// add our element at top
        }
        
        //return kth largest if heap has k elements present in it otherwise return -1
        return minHeap.size() < target ? -1 : minHeap.peek();
    }
}