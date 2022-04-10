class Solution {
    public int minOperations(String[] logs) {
        int levels = 0;
        for(String log: logs){
            if(levels == 0 && log.equals("../")){
                continue;
            }else if(log.equals("../")){
                levels--;
            }else if(log.equals("./")){
                continue;
            }else{
                levels++;
            }
        }
        
        return levels;
    }
}