class Solution {
    //if we consider a 2x3 board and number all cells from 0 to 5, then dir[i] = adjacent(4 directions TBRL) values of cell no. i
    int[][] dir = {{1, 3}, {0, 4, 2}, {1, 5}, {0, 4}, {1, 3, 5}, {2, 4}};
    
    class Pair {
        String config; // current board configuration
        int level;
        
        Pair(String c, int l) {
            config = c;
            level = l;
        }
    }
    
    //converting board into a string for processing
    String getConfig(int[][] board) {
        StringBuilder sb = new StringBuilder();
        
        for(int[] row: board) {
            for(int val: row) {
                sb.append(val);
            }
        }
        
        return sb.toString();
    }
    
    public int slidingPuzzle(int[][] board) {
        HashSet<String> vis = new HashSet<>();
        
        ArrayDeque<Pair> queue = new ArrayDeque<>();
        
        Pair root = new Pair(getConfig(board), 0);
        
        queue.add(root);
        
        while(queue.size() > 0) {
            //r m* w a*
            //remove
            Pair rem = queue.remove();
            
            //mark*
            if(vis.contains(rem.config)) {
                continue;
            }
            vis.add(rem.config);
            
            //work
            if(rem.config.equals("123450")) {
                return rem.level;
            }
            
            //addNew*
            int idx0 = rem.config.indexOf('0');//index of 0 in current configuration of board
            //get adjacent nbr of idx0
            for(int i: dir[idx0]) {
                String newConfig = swap(rem.config, idx0, i);//swap 0 with adjacent neighbors
                if(!vis.contains(newConfig)) {
                    Pair nextPair = new Pair(newConfig, rem.level+1);
                    queue.add(nextPair);
                }
            }
        }
        
        return -1;
    }
    
    private String swap(String str, int i, int j) {
        //convert string to stringbuilder for faster swapping
        StringBuilder sb = new StringBuilder(str);
        
        sb.setCharAt(i, str.charAt(j));
        sb.setCharAt(j, str.charAt(i));
        
        return sb.toString();
    }
}