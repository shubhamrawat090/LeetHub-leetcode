class Solution {
    public boolean validPath(int n, int[][] edges, int source, int destination) {
        if(source == destination) {
            return true;
        }
        // Creating adj list
        ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
        
        for(int i=0; i<n; i++) {
            graph.add(new ArrayList<>());
        }
        
        for(int[] e: edges) {
            graph.get(e[0]).add(e[1]);
            graph.get(e[1]).add(e[0]);
        }
        
        boolean[] vis = new boolean[n];
        
        return dfs(graph, source, destination, vis);
    }
    
    private boolean dfs(ArrayList<ArrayList<Integer>> graph, int src, int dest, boolean[] vis) {
        vis[src] = true;
        
        for(int nbr: graph.get(src)) {
            if(!vis[nbr]) {
                if(nbr == dest) {
                    return true;
                }
                
                if(dfs(graph, nbr, dest, vis) == true) {
                    return true;
                }
            }
        }
        
        return false;
    }
}