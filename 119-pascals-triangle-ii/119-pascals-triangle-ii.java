class Solution {
    public List<Integer> getRow(int rowIndex) {
        List<Integer> ans = new ArrayList<>();
        
        if(rowIndex == 0){
            ans.add(1);
            return ans;
        }
        ans.add(1);
        ans.add(1);
        if(rowIndex == 1){  
            return ans;
        }
        for(int index=1; index<rowIndex; index++){
            List<Integer> curr = new ArrayList<Integer>();
            curr.add(1);
            for(int i=1; i<ans.size(); i++){
                int sum = ans.get(i-1)+ans.get(i);
                curr.add(sum);
            }
            curr.add(1);
            
            ans = new ArrayList<Integer>();
            ans = curr;
        }
        
        return ans;
    }
}