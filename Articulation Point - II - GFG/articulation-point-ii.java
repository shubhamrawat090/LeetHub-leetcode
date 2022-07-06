// { Driver Code Starts
import java.util.*;
import java.lang.*;
import java.io.*;
class GFG
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine().trim());
        while(T-->0)
        {
            String[] s = br.readLine().trim().split(" ");
            int V = Integer.parseInt(s[0]);
            int E = Integer.parseInt(s[1]);
            ArrayList<ArrayList<Integer>>adj = new ArrayList<>();
            for(int i = 0; i < V; i++)
                adj.add(i, new ArrayList<Integer>());
            for(int i = 0; i < E; i++){
                String[] S = br.readLine().trim().split(" ");
                int u = Integer.parseInt(S[0]);
                int v = Integer.parseInt(S[1]);
                adj.get(u).add(v);
                adj.get(v).add(u);
            }
            Solution obj = new Solution();
            int[] ans = obj.articulationPoints(V, adj);
            for(int i: ans)
                System.out.print(i + " ");
            System.out.println();
        }
    }
}// } Driver Code Ends


class Solution
{
    public int[] articulationPoints(int V, ArrayList<ArrayList<Integer>> adj)
    {
        // Code here
        boolean[] vis = new boolean[V];
        int[] dis = new int[V];
        int[] low = new int[V];
        boolean[] aps = new boolean[V];//contains articulation points
        
        for(int v=0; v<V; v++) {
            if(!vis[v]) {
                dfs(adj, vis, dis, low, aps, v, -1);
            }
        }
        
        int count = 0;
        for(boolean ap: aps) {
            if(ap) {
                count++;
            }
        }
        
        if(count == 0) {
            return new int[]{-1};
        } else {
            int[] res = new int[count];
            int idx = 0;
            
            for(int i=0; i<aps.length; i++) {
                if(aps[i]) {
                    res[idx++] = i;
                }
            }
            
            return res;
        }
    }
    
    int time = 0;
    void dfs(ArrayList<ArrayList<Integer>> adj, boolean[] vis, int[] dis, int[] low, boolean[] aps, int u, int p) {
        vis[u] = true;
        dis[u] = low[u] = ++time;
        
        int countRootChildren = 0;
        for(int v: adj.get(u)) {
            if(v == p) {
                //ignore PARENT NEIGHBOR
                continue;
            } else if(vis[v]) {
                //already VISITED NEIGHBOR
                low[u] = Math.min(low[u], dis[v]);//update lowest discovered to that of discovery of neighbor if it is lower
            } else {
                // UNVISITED NEIGHBOR
                countRootChildren++;
                //call dfs for neighbor v and u as its parent
                dfs(adj, vis, dis, low, aps, v, u);
                //in post order update the lowest discovery of parent to that of Min(children, parent)
                low[u] = Math.min(low[u], low[v]);
                
                if(p!=-1 && low[v]>=dis[u]) {
                    //articulation detected
                    aps[u] = true;
                }
            }
        }
        
        //Case: ROOT as Articulation Point
        if(p==-1 && countRootChildren>1) {
            aps[u] = true;
        }
    }
}