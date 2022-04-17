class Solution {
    public long waysToBuyPensPencils(int total, int cost1, int cost2) {
        int i=0;
        long count=0;
        //1 way 0 pencil 0 pen
        if(cost1>total && cost2> total){
            count++;
            return count;
        }
        
        //cannot buy pen so buying pencils
        if(cost1>total){
            return (total/cost2)+1;
        }
        
        //cannot buy pencils so buying pen
        if(cost2>total){
            return (total/cost1)+1;
        }
        
        //till cost of buying multiple pens is in total budget
        while(i*cost1<total){
            //getting no. of pencils we can buy
            int tempTotal = total;
            tempTotal -= i*cost1;
            count += (tempTotal/cost2)+1;  
            i++;
        }
        
        //if you can still buy a pen the add it
        if(i*cost1<=total){
            count++;
        }
        
        // return count
        return count;
    }
}