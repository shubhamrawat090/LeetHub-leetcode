/////////////////////////////////// DIJKSTRA'S ALGORITHM /////////////////////////////////////

// 1. Initialize distance to point at index 0 to 0 and distance to all other points to +inf.

/* 2. While !(all points are covered):
      Pick the index which has the lowest distance value
      Mark this node as visited
      Add the distance to the answer variable
      Update the distance to other points from this point */

// 3. Return ans

class Solution {
    public int minCostConnectPoints(int[][] points) {
        boolean[] visited=new boolean[points.length];
        
        Node[] nodes=new Node[points.length];
        
        int ans=0;
        
        for(int i=0;i<points.length;i++){
            int[] point=points[i];
            nodes[i]=new Node(point[0], point[1], Integer.MAX_VALUE);
        }
        
        nodes[0].dist=0;

        int numNodes=points.length;
        
        while(numNodes>0){
            numNodes--;
            int minIndex = findNextNode(nodes, visited);
            ans += nodes[minIndex].dist;
            visited[minIndex] = true;
            updateDistToAllNodes(nodes, minIndex, visited);
        }
        
        return ans;
    }

    public void updateDistToAllNodes(Node[] nodes, int index, boolean[] visited){
        int x = nodes[index].x;
        int y = nodes[index].y;
        
        for(int i=0;i<nodes.length;i++){
            if(!visited[i]){
                int newDist=Math.abs(nodes[i].x-x)+Math.abs(nodes[i].y-y);
                nodes[i].dist=Math.min(nodes[i].dist, newDist);
            }
        }
    }

    public int findNextNode(Node[] nodes, boolean[] visited){
        int min=Integer.MAX_VALUE;
        int ans=-1;
        
        for(int i=0;i<nodes.length;i++){
            if(nodes[i].dist<min && !visited[i]){
                min=nodes[i].dist;
                ans=i;
            }
        }
        
        return ans;
    }

    class Node{
        int x, y;
        int dist;
        
        Node(int x, int y, int dist){
            this.x=x;
            this.y=y;
            this.dist=dist;
        }
    }
}