class Solution {
    public List<String> findItinerary(List<List<String>> tickets) {
        HashMap<String, PriorityQueue<String>> adj = new HashMap<>();
        
        for(List<String> ticket: tickets) {
            String src = ticket.get(0);
            String dest = ticket.get(1);
            
            if(!adj.containsKey(src)) {
                adj.put(src, new PriorityQueue<>());
            }
            
            adj.get(src).add(dest);
        }
        
        LinkedList<String> res = new LinkedList<>();
        dfs("JFK", res, adj);
        
        return res;
    }
    
    private void dfs(String v, LinkedList<String> res, HashMap<String, PriorityQueue<String>> adj) {
        if(adj.containsKey(v) == false || adj.get(v).size() == 0) {
            res.addFirst(v);
            return;
        } 
        
        while(adj.get(v).size() > 0) {
            String nbr = adj.get(v).remove();
            
            dfs(nbr, res, adj);
        }
        
        res.addFirst(v);
    }
}