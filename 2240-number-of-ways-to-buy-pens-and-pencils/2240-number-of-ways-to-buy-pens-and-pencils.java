class Solution {
    public long waysToBuyPensPencils(int total, int cost1, int cost2) {
        int i=0;
        long count=0;
        if(cost1>total && cost2> total){
            count++;
            return count;
        }
        
        if(cost1>total){
            return (total/cost2)+1;
        }
        
        if(cost2>total){
            return (total/cost1)+1;
        }
        
        while(i*cost1<total){
            int tempTotal = total;
            tempTotal -= i*cost1;
            count += (tempTotal/cost2)+1;  
            i++;
        }
        
        if(i*cost1<=total){
            count++;
        }
        
        return count;
    }
}