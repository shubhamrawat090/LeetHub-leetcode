class Solution {
    public List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> res = new ArrayList<>();
        helper(k, n, 1, new LinkedList(), res);
        
        return res;
    }
    
    public void helper(int k, int n, int sum, LinkedList list, List<List<Integer>> res) {
        if(k<0 || n<0) return;
        
        if(k==0 && n==0) {
            res.add(new ArrayList(list));
            return;
        }
        
        for(int i=sum; i<=9; i++) {
            list.add(i);
            helper(k-1, n-i, i+1, list, res);
            list.removeLast();
        }
    }
}