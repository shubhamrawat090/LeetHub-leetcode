////////////// 2-step process ///////////////////////

// 1. Traverse the graph & update dist. values
// 2. Find max distance (if all nodes are traversed)
class Solution {
    public class Edge{
        int dst;
        int wt;
        Edge(int dst , int wt){
            this.dst = dst;
            this.wt = wt;
        }
    }
    public class pair{
        int v;
        int dist;
        pair(int v, int dist){
            this.v = v;
            this.dist = dist;
        }
    }
    public int networkDelayTime(int[][] times, int N, int K) {
        ArrayList<Edge>[] graph = new ArrayList[N+1];
        for(int i=0;i<N+1;i++) graph[i] = new ArrayList<>();
        for(int i = 0; i<times.length; i++){
            Edge newE = new Edge(times[i][1],times[i][2]);
            graph[times[i][0]].add(newE);
        }
        
        pair src = new pair(K,0);
        PriorityQueue<pair> pq = new PriorityQueue<>((a,b)->{
           return a.dist-b.dist;
        });
        pq.add(src);
        int [] len = new int[N+1];
        Arrays.fill(len,Integer.MAX_VALUE);
        len[K] = 0;
        int time = 0;
        while(pq.size()!=0){
            pair rvtx = pq.remove();
            for(Edge e : graph[rvtx.v]){
                pair tmp = new pair(e.dst, e.wt + rvtx.dist);
                if(len[tmp.v]>tmp.dist){
                    pq.add(tmp);
                    len[tmp.v] = e.wt+rvtx.dist;
                }
            }
        
    }
        for(int i=1;i<=N;++i)
        {
            if(len[i]==Integer.MAX_VALUE)
                return -1;
            time = Math.max(time,len[i]);
        }
            return time;
    }
}