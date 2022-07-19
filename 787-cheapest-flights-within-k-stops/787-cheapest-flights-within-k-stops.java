class Solution {
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        int[] dist = new int[n];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[src] = 0;
        
        int[] distPlus1 = null;
        
        for(int i=1; i<=k+1; i++) {
            distPlus1 = Arrays.copyOf(dist, dist.length);
            for(int[] flight: flights) {
                // going from u --> v
                int u = flight[0];
                int v = flight[1];
                
                //cost of going from u --> v
                int uv = flight[2]; 
                
                //if we have currently reached point "u" only then we can go to point "v"
                if(dist[u] != Integer.MAX_VALUE) {
                    distPlus1[v] = Math.min(distPlus1[v], dist[u] + uv);
                }
            }
            dist = distPlus1; // update dist array to current points that we have covered
        } 
        
        //NO PATH FOUND with minimum k stops in between src and dest
        if(dist[dst] == Integer.MAX_VALUE) {
            return -1;
        } else {
            return dist[dst];
        }
    }
}