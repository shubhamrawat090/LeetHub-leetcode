public class Solution {
    public List<Integer> countSmaller(int[] nums) {
        int[] res = new int[nums.length];
        List<Integer> list = new ArrayList<>();
        for(int i = nums.length - 1; i >= 0; i--) {
            res[i] = insert(list, nums[i]);
        }
        list.clear();
        for(int i = 0 ; i < nums.length; i++) {
            list.add(res[i]);
        }
        return list;
    }
    
    // binary insert
    private int insert(List<Integer> list, int num) {
        int l = 0;
        int r = list.size() - 1;
        while(l <= r) {
            int mid = l + (r - l)/2;
            int M = list.get(mid);
            if(M >= num) {
                r = mid - 1;
            }else if(M < num) {
                l = mid + 1;
            }
        }
        list.add(l, num);
        return l;
    }
}