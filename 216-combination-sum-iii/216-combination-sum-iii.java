class Solution {
    public List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> res = new ArrayList<>();
        //passing new linked list as we can use removeLast() method
        helper(k, n, 1, new LinkedList(), res);
        
        return res;
    }
    
    public void helper(int k, int n, int start, LinkedList list, List<List<Integer>> res) {
        //do nothing for -ve base cases
        if(k<0 || n<0) return;
        
        //add our list to res if we have used k values and all of them add up to n
        if(k==0 && n==0) {
            res.add(new ArrayList(list));
            return;
        }
        
        //iterate from start to 9
        for(int i=start; i<=9; i++) {
            //add our current value in list
            list.add(i);
            //try for next values with k-1 digits and remaining sum = n-curr val
            helper(k-1, n-i, i+1, list, res);
            list.removeLast(); //backtrack, in case our curr value doesn't work or we want to try new combination
        }
    }
}