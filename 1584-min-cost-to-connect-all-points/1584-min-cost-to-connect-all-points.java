/////////////////////////// MINIMUM SPANNING TREE - PRIM'S ALGORITHM //////////////////////////////////

class Solution {
    public int minCostConnectPoints(int[][] points) {
        int len = points.length;
        // array that keep track of the shortest distance from mst to each node
        int[] disArr = new int[len];
        for (int i = 1; i < len; ++i) {
            disArr[i] = Integer.MAX_VALUE;
        }
        // visited[node] == true if node in mst
        boolean[] visited = new boolean[len];
        visited[0] = true;//start from 0 node
        
        int numEdge = 0;
        // current node, used to update the disArr
        int cur = 0;
        // result
        int res = 0;
        
        while (numEdge++ < len - 1) {
            int minEdge = Integer.MAX_VALUE;
            int next = -1;
            for (int i = 0; i < len; ++i) {
                // if the node i is not in mst
                if (!visited[i]) {
                    // find the distance between cur and i
                    int xDist = Math.abs(points[cur][0] - points[i][0]);
                    int yDist = Math.abs(points[cur][1] - points[i][1]);
                    int dis = xDist + yDist;
                    // update distance array
                    disArr[i] = Math.min(dis, disArr[i]);
                    // find the shortest edge
                    if (disArr[i] < minEdge) {
                        minEdge = disArr[i];
                        next = i;
                    }
                }
            }
            cur = next;
            visited[cur] = true;
            res += minEdge;
        }
        
        return res;
    }
}