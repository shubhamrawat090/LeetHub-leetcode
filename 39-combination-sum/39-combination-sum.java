class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<>();
        
        helper(target, candidates, res, new LinkedList(), 0);
        return res;
    }
    
    public void helper(int target, int[] candidates, List<List<Integer>> res, LinkedList list, int idx) {
        if(idx == candidates.length) {
            if(target == 0) {
                res.add(new ArrayList(list));
            }
            return;
        }

        if(candidates[idx] <= target) {
            list.add(candidates[idx]);
            helper(target-candidates[idx], candidates, res, list, idx);
            list.removeLast();
        }
        helper(target, candidates, res, list, idx+1);
    }
}