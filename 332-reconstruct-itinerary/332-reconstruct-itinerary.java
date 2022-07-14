class Solution {
    // Using HEIRHOLZER'S ALGORITHM to find Euler Path
    public List<String> findItinerary(List<List<String>> tickets) {
        //converting tickets into a adjacency list where neighbors are sorted using priority queue
        HashMap<String, PriorityQueue<String>> adj = new HashMap<>();
        
        for(List<String> ticket: tickets) {
            String src = ticket.get(0);
            String dest = ticket.get(1);
            
            if(!adj.containsKey(src)) {
                adj.put(src, new PriorityQueue<>());
            }
            
            adj.get(src).add(dest);
        }
        
        //can use arraylist, but then need to add at 0th idx everytime which is time costing
        LinkedList<String> res = new LinkedList<>();
        dfs("JFK", res, adj);
        
        return res;
    }
    
    private void dfs(String v, LinkedList<String> res, HashMap<String, PriorityQueue<String>> adj) {
        //destination detected(as it was not encountered prev src vtx)
        if(!adj.containsKey(v) || adj.get(v).size() == 0) {
            res.addFirst(v);
            return;
        } 
        
        //get the neighbors of current src vtx "v"
        PriorityQueue<String> neighbors = adj.get(v);
        while(neighbors.size() > 0) {
            String nbr = neighbors.remove();
            
            dfs(nbr, res, adj);
        }
        
        res.addFirst(v);
    }
}