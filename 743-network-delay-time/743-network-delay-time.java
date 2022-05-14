////////////// 2-step process ///////////////////////
// DIJKSTRA's ALGORITHM - BFS with Priority Queue
// 1. Traverse the graph & update dist. values
// 2. Find max distance (if all nodes are traversed)
class Solution {
    public class Edge{
        int dst;
        int wt;
        Edge(int dst, int wt){
            this.dst = dst;
            this.wt = wt;
        }
    }
    public class Pair{
        int v;
        int dist;
        Pair(int v, int dist){
            this.v = v;
            this.dist = dist;
        }
    }
    public int networkDelayTime(int[][] times, int N, int K) {
        //Creating Adj list
        ArrayList<Edge>[] graph = new ArrayList[N+1];
        for(int i=0;i<N+1;i++) graph[i] = new ArrayList<>();
        //building an edge(with dist and wt) and pushing it inside the adj list
        for(int i = 0; i<times.length; i++){
            //if times[i] = {u,v,w}
            //from node u, dist = v, wt = w
            Edge newE = new Edge(times[i][1],times[i][2]);
            graph[times[i][0]].add(newE);
        }
        
        //initialising src with k given and setting the distance = 0
        Pair src = new Pair(K,0);
        //will sort in ascending order according to the dist
        PriorityQueue<Pair> pq = new PriorityQueue<>((a,b)->{
           return a.dist-b.dist;
        });
        
        //BFS with priority queue started
        pq.add(src);
        //initially setting all values to MAX
        int [] len = new int[N+1];
        Arrays.fill(len,Integer.MAX_VALUE);
        //source's dist is 0
        len[K] = 0;
        
        while(pq.size()!=0){
            //removed vertex from pq top
            Pair rvtx = pq.remove();
            //traversing and checking all connected nodes of removed vertex
            for(Edge e : graph[rvtx.v]){
                //dist of new = dist(src->rvtx) + wt of rvtx
                Pair tmp = new Pair(e.dst, e.wt + rvtx.dist);
                if(len[tmp.v]>tmp.dist){
                    //if curr dist is less than dist in stored arr then update it and add to priority queue
                    pq.add(tmp);
                    len[tmp.v] = e.wt+rvtx.dist;
                }
            }
        
        }
        
        //traversing the len arr and finding the maximum time = time to cover all edges
        int time = 0;
        for(int i=1;i<=N;++i) {
            //if any val is MAX, it means we cannot reach it from src(k) 
            if(len[i]==Integer.MAX_VALUE)
                return -1;
            time = Math.max(time,len[i]);
        }
        
        return time;
    }
}