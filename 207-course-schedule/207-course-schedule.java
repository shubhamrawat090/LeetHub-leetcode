// Just check if you can find a topological sort or not
// just find a cycle : if there is a cycle then no topological sort possible
class Solution {
    boolean cycle = false;
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        ArrayList<Integer>[] graph = new ArrayList[numCourses];
        
        for(int i=0; i<graph.length; i++) {
            graph[i] = new ArrayList<>();
        }
        
        for(int[] req: prerequisites) {
            graph[req[0]].add(req[1]);
        }
        
        int[] vis = new int[numCourses];
        //0 -> unexplored
        //1 -> exploring
        //2 -> explored
        
        for(int i=0; i<numCourses; i++) {
            if(vis[i] == 0) {
                dfs(graph, vis, i);
            }
        }
        
        return !cycle;
    }
    
    private void dfs(ArrayList<Integer>[] graph, int[] vis, int v) {
        vis[v] = 1;
        
        boolean ans = false;
        for(int nbr: graph[v]) {
            if(vis[nbr] == 1) {
                cycle = true;
                return;
            } else if(vis[nbr] == 0) {
                dfs(graph, vis, nbr);
            }
        }
        
        vis[v] = 2;
    }
}