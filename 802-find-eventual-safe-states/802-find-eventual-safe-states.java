class Solution {
    // visited array states
    // 0 --> not visited
    // 1 --> visited
    // 2 --> visited & SAFE
    
    public List<Integer> eventualSafeNodes(int[][] graph) {
        int[] vis = new int[graph.length];
        
        List<Integer> safeStates = new ArrayList<>();
        
        for(int i=0; i<graph.length; i++) {
            //travel through all paths from this vtx "i" and check if it is safe
            boolean safe = dfs(i, graph, vis);
            
            if(safe == true) {
                //add to our list if it is safe to travel
                safeStates.add(i);
            }
        }
        
        return safeStates;
    }
    
    private boolean dfs(int v, int[][] graph, int[] vis) {
        //vtx is visited and safe therefore all vtx on this path until now are safe
        if(vis[v] == 2) {
            return true;
        } 
        //we have pointed to already visited vtx which is not safe, so return false for all vtx on our path that we have currently covered till this point
        else if(vis[v] == 1) {
           return false; 
        } 
        //unexplored or not visited
        else {
            vis[v] = 1; // mark visited
            
            //traverse all neighbors
            for(int nbr: graph[v]) {
                boolean isNbrSafe = dfs(nbr, graph, vis);
                //if any our our neighbor is not safe then we are not safe
                if(!isNbrSafe) {
                    return false;
                }
            }
            
            //no unsafe nbr found => mark us as safe
            vis[v] = 2;
            return true;
        }
    }
}