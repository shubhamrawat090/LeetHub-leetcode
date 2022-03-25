class Solution {
    
    public int twoCitySchedCost(int[][] costs) {
        int cost = 0;
        
        //sort array costs according to maximum profit when sending to city a which means a[0]-b[0]>a[1]-b[1]
        Arrays.sort(costs, (a, b) -> {
            return (a[0] - a[1]) - (b[0] - b[1]);
        });
        
        //after sorting first half is with maximized profit for city a and second half is maximized profit for city b
        for(int i=0; i<costs.length; i++){
            int[] arr = costs[i];
            cost += i<costs.length/2? arr[0]: arr[1];
        }
        
        return cost;
    }
}