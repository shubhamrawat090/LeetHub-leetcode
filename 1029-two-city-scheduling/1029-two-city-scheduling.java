class Solution {
    public int twoCitySchedCost(int[][] costs) {
        int N = costs.length/2;
        int minCost = 0;
        int idx = 0;
        int[] refund = new int[2*N];
        for(int[] cost : costs) {
            refund[idx++] = cost[1] - cost[0];
            minCost += cost[0];
        }
        Arrays.sort(refund);
        for (int i = 0; i < N; i++) {
            minCost += refund[i];
        }
        return minCost;
    }
}