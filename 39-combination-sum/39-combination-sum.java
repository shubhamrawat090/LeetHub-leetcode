class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List <Integer>> ans = new ArrayList<>();
        findCombinations(0, candidates, target, ans, new ArrayList<>());
        return ans;
    }
    
    //helper function
    private void findCombinations(int ind, int[] arr, int target, List<List<Integer>> ans, List<Integer> ds){
        //if idx reaches end of arr
        if (ind == arr.length) {
            //if all chosen nos. add up to target, then add our ds to ans list
            if (target == 0) {
                ans.add(new ArrayList<>(ds));
            }
            //return if our operation is complete or if there is some target left inspite of trying all the nos. in the arr
            return;
        }

        //pick element at idx only if it is less than or equal to target => otherwise target might become negative
        if (arr[ind] <= target) {
            //add curr element to data stucture
            ds.add(arr[ind]);
            //find all possible combinations trying that same element for multiple times, as it is allowed in the question
            findCombinations(ind, arr, target - arr[ind], ans, ds);
            ds.remove(ds.size() - 1); // backtrack
        }
        //not picking the current element
        findCombinations(ind + 1, arr, target, ans, ds);
    }
}