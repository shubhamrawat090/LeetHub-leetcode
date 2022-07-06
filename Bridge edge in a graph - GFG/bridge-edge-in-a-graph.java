// { Driver Code Starts
import java.util.*;
import java.io.*;
import java.lang.*;

class DriverClass
{
    public static void main (String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        
        while(t-- > 0)
        {
            ArrayList<ArrayList<Integer>> list = new ArrayList<>();
            int V = sc.nextInt();
            int E = sc.nextInt();
            for(int i = 0; i < V+1; i++)
                list.add(i, new ArrayList<Integer>());
            for(int i = 0; i < E; i++)
            {
                int u = sc.nextInt();
                int v = sc.nextInt();
                list.get(u).add(v);
                list.get(v).add(u);
            }
            int c = sc.nextInt();
            int d = sc.nextInt();
            
            Solution ob = new Solution();
            
            System.out.println(ob.isBridge(V,list,c,d));
        }
    }
}// } Driver Code Ends


// User function Template for Java

class Solution
{
    //Function to find if the given edge is a bridge in graph.
    static int bridge = 0;
    static int isBridge(int V, ArrayList<ArrayList<Integer>> adj, int c, int d)
    {
        // code here
        boolean[] vis = new boolean[V];
        int[] dis = new int[V];
        int[] low = new int[V];
        
        time = 0;
        bridge = 0;
        
        for(int i=0; i<V; i++) {
            if(!vis[i]) {
                dfs(adj, vis, dis, low, i, -1, c, d);
            }
        }
        
        return bridge;
    }
    
    static int time = 0;
    static void dfs(ArrayList<ArrayList<Integer>> adj, boolean[] vis, int[] dis, int[] low, int u, int p, int c, int d) {
        vis[u] = true;
        dis[u] = low[u] = ++time;
        
        for(int v: adj.get(u)) {
            if(v == p) {
                continue;
            } else if(vis[v]) {
                low[u] = Math.min(low[u], dis[v]);
            } else {
                dfs(adj, vis, dis, low, v, u, c, d);
                low[u] = Math.min(low[u], low[v]);
                
                if(low[v] > dis[u]){
                    if(c == v && d == u || c == u && d == v){
                        bridge = 1;
                    }
                }
            }
        }
    }
}