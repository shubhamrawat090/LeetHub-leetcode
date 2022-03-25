class Solution {
    public int twoCitySchedCost(int[][] costs) {
        //half of costs array is taken
        int N = costs.length/2;
        //calculates our cost
        int minCost = 0;
        //iterator for calculating refund
        int idx = 0;
        //arr of size = costs
        int[] refund = new int[2*N];
        
        for(int[] cost : costs) {
            //for each val of costs get cityB - cityA
            refund[idx++] = cost[1] - cost[0];
            //initially think all of them are going to city A
            minCost += cost[0];
        }
        //refund array has the loss encountered when all go to city A
        Arrays.sort(refund);
        
        //add first half of this loss to minimize the cost
        for (int i = 0; i < N; i++) {
            minCost += refund[i];
        }
        return minCost;
    }
}