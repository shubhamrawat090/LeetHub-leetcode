/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    //Pair class stores data like node, width(vertical line), depth(horizontal levels)
    class Pair implements Comparable<Pair> {
        TreeNode node;
        int w;
        int d;

        Pair(TreeNode node, int w, int d){
            this.node = node;
            this.w = w;
            this.d = d;
        }

        // COMPARATOR defined so that 
        // 1. ArrayList<Pair> can be sorted using Arrays.sort() 
        // 2. PriorityQueue<Pair> can sort and store data
        // (this - other) means increasing
        // (other - this) means decreasing
        public int compareTo(Pair other){
            //if current level is same then compare according to the node's value
            if(this.d == other.d){
                return this.node.val - other.node.val;
            } 
            //otherwise, compare current level
            else {
                return this.d - other.d;
            }
        }
    }

    public List<List<Integer>> verticalTraversal(TreeNode root) {
        //Using Level Order BFS
        Queue<Pair> queue = new LinkedList<>();
        //Add Root with width = 0, depth = 1
        queue.add(new Pair(root, 0, 1));

        int lmw = 0;
        int rmw = 0;
        
        //Mapping width -> Pair Info of node
        HashMap<Integer, ArrayList<Pair>> map = new HashMap<>();
        while(queue.size() > 0){
            //removing current node
            Pair currNode = queue.remove();

            //Finding left most and right most width extreme
            lmw = Math.min(lmw, currNode.w);
            rmw = Math.max(rmw, currNode.w);

            //Mapping the values and storing the info
            if(map.containsKey(currNode.w) == false){
                //if the key(width) is not present in the Map
                map.put(currNode.w, new ArrayList<>());//create a new list at that index
                map.get(currNode.w).add(currNode);//add currNode at that key
            } else {
                //if the key(width) is already present in the Map
                map.get(currNode.w).add(currNode);//add currNode at that key
            }

            //Add left and right nodes(if they exist) to the Queue
            if(currNode.node.left != null){
                //going left => width-1, level+1
                queue.add(new Pair(currNode.node.left, currNode.w - 1, currNode.d + 1));
            }

            if(currNode.node.right != null){
                //going right => width+1, level+1
                queue.add(new Pair(currNode.node.right, currNode.w + 1, currNode.d + 1));
            }
        }

        //Traverse the HashMap from lmw->rmw and storing the values in result
        List<List<Integer>> res = new ArrayList<>();
        for(int w = lmw; w <= rmw; w++){
            //List storing the sorted values of nodes at that particular vertical level
            ArrayList<Integer> list = new ArrayList<>();
            //Get the list(which is not sorted) from map
            ArrayList<Pair> unsortedList = map.get(w);
            //Sort the list based on the conditioned mentioned in compareTo() method of Pair class
            Collections.sort(unsortedList);

            //take individual Pair and store it's value inside list
            for(Pair temp: unsortedList){
                list.add(temp.node.val);
            }

            //Add curr vertical list to resultant list
            res.add(list);
        }
        
        //Return the resultant
        return res;
    }
}