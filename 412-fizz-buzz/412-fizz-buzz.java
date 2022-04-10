class Solution {
    public List<String> fizzBuzz(int n) {
        //stores ans
        List<String> ans = new ArrayList<>();
        
        //traverse from 1 to n
        for(int i=1; i<=n; i++){
            //if i is divisible by 3 & 5 both
            if(i%3 == 0 && i%5 == 0){
                ans.add("FizzBuzz");
            }
            //if i is divisible by 3
            else if(i%3 == 0){
                ans.add("Fizz");
            }
            //if i is divisible by 5
            else if(i%5 == 0){
                ans.add("Buzz");
            }
            //if i is divisible by neither 3 nor 5
            else{
                // i+"" converts integer to string
                ans.add(i+"");
            }
        }
        
        return ans;
    }
}