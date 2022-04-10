class Solution {
    public int minOperations(String[] logs) {
        int levels = 0;
        for(String log: logs){
            //if at root and "../" is performed, do nothing 
            if(levels == 0 && log.equals("../")){
                continue;
            }
            //go 1 level down
            else if(log.equals("../")){
                levels--;
            }
            //do nothing as we have to remain on the same folder
            else if(log.equals("./")){
                continue;
            }
            //do 1 level deep
            else{
                levels++;
            }
        }
        
        //levels is the no. of "../" operations required to go back to parent folder
        return levels;
    }
}