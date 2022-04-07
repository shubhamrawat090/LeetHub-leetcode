class Solution {
    public int lastStoneWeight(int[] stones) {
        //sort arr to get max at end
        Arrays.sort(stones);
        //work till count of stones
        int count = stones.length-1;
        while(count!=0)
        {
            //if x==y, destroy both
            if(stones[stones.length-1]==stones[stones.length-2])
            {
                stones[stones.length-1]=0;
                stones[stones.length-2]=0;
            }
            //if x!=y, destroy x and set y=x-y
            if(stones[stones.length-1]!=stones[stones.length-2])
            {
                stones[stones.length-1]=stones[stones.length-1] - stones[stones.length-2];
                stones[stones.length-2]=0;
            }
            //sort the newly sorted arr
            Arrays.sort(stones);
            count--;
        }
        //after processing return the smallest weight, except 0
        for(int j: stones)
        {
            if(j!=0)
            {
                return j;
            }
        }
        //if no such small wt found except 0 then return it
        return 0;
    }
}