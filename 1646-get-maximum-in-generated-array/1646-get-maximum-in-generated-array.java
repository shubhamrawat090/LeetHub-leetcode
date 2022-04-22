class Solution {
    public int getMaximumGenerated(int n) {
        int[] arr = new int[n+1];
        int max = arr[0];
        for(int i=0; i<=n; i++){
            if(i==0 || i==1){
                arr[i] = i;
            }
            
            if(i==0) continue;
            
            if(2*i >= 2 && 2*i <= n){
                arr[2*i] = arr[i];
            }
            
            if(2*i+1 >= 2 && 2*i+1 <= n){
                arr[2*i+1] = arr[i] + arr[i+1];
            }
            
            max = Math.max(max, arr[i]);
        }
        
        return max;
    }
}