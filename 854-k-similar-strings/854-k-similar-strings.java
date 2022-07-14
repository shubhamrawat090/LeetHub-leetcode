class Solution {
    public int kSimilarity(String s1, String s2) {
        HashSet<String> vis = new HashSet<>();
        ArrayDeque<String> queue = new ArrayDeque<>();
        
        queue.add(s1);
        
        //we keep changing chars from start to end in s1 and keep comparing them to s2 and we get the level of graph or recursive tree-like str. where we get s1 = s2
        
        //BFS as minimum no. is asked
        int level = 0;
        while(queue.size() > 0) {
            int size = queue.size();
            
            while(size-- > 0) {
                String rem = queue.remove();
                
                if(vis.contains(rem) == true) {
                    continue;
                }
                
                vis.add(rem);
                
                if(rem.equals(s2)) {
                    return level;
                }
                
                for(String nbr: getNeighbors(rem, s2)) {
                    if(!vis.contains(nbr)) {
                        queue.add(nbr);
                    }
                }
            }
            
            level++;
        }
        
        return -1;
    }
    
    private ArrayList<String> getNeighbors(String rem, String s2) {
        ArrayList<String> nbrs = new ArrayList<>();
        
        int idx = -1;
        //find where first dissimilar character appears
        for(int i=0; i<rem.length(); i++) {
            if(rem.charAt(i) != s2.charAt(i)) {
                idx = i;
                break;
            }
        }
        
        //from next index of dissimilar character in rem(s1) find the one that now matches this dissimilar char(in s2) in rem(s1)
        for(int j=idx+1; j<rem.length(); j++) {
            if(rem.charAt(j) == s2.charAt(idx)) {
                //this is the new string permutation which is to be matched with s2 now
                String nbr = swap(rem, idx, j); //got out next nbr
                nbrs.add(nbr);
            }
        }
        
        return nbrs;
    }
    
    private String swap(String rem, int idx, int j) {
        StringBuilder sb = new StringBuilder(rem);
        
        sb.setCharAt(idx, rem.charAt(j));
        sb.setCharAt(j, rem.charAt(idx));
        
        return sb.toString();
    }
}