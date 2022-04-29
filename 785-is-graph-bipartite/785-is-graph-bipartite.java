//Graph Coloring - BFS
// 0 = uncolored
// 1 = blue
// -1 = red

// TIME: O(V+E), SPACE: O(V)

class Solution {
    public boolean isBipartite(int[][] g) {
        int[] colors = new int[g.length];
        for (int i = 0; i < g.length; i++)
            //do the work if the node is not colored
            if (colors[i] == 0) {
                //Queue for each node's children
                Queue<Integer> q = new LinkedList<>();
                q.add(i);//add our node to it
                colors[i] = 1;//color our node blue
                //work while queue is empty
                while (!q.isEmpty()) {
                    //get our node from queue
                    Integer node = q.poll();
                    //get all it's children/adjacent nodes
                    for (int adjacent : g[node])
                        //if adjacent nodes have the same color as our node => our graph is not bipartite
                        if (colors[adjacent] == colors[node])
                            return false;
                        //if adjacent nodes are not colored
                        else if (colors[adjacent] == 0) {
                            // add it in queue
                            q.add(adjacent);
                            // color it opposite to that of our node
                            colors[adjacent] = -colors[node];
                        }
                }
            }
        
        //return true if no violation is found and entire graph is traversed
        return true;
    }
}