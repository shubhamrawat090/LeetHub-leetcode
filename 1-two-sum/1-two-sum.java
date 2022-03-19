public class Solution {
    public int[] twoSum(int[] numbers, int target) {
        // stores value->idx pair
        HashMap<Integer,Integer> indexMap = new HashMap<Integer,Integer>();
        for(int i = 0; i < numbers.length; i++){
            //getting target - nums[i] and checking if it is present in hashmap which means that a pair is present with sum = target
            Integer requiredNum = (Integer)(target - numbers[i]);
            if(indexMap.containsKey(requiredNum)){
                //getting idx of (target - curr no., our curr no. )
                int toReturn[] = {indexMap.get(requiredNum), i};
                //store these idx in arr and return it
                return toReturn;
            }
            //store val->idx pair in map
            indexMap.put(numbers[i], i);
        }
        //if no pair is found then return null
        return null;
    }
}