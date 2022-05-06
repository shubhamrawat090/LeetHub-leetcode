// We need two stacks, one is to store arr characters, the other one is to store counts. Since stack peek index <= runner index, we can use string's char array as stack.

class Solution {
    public String removeDuplicates(String s, int k) {
        char[] arr = s.toCharArray();
        int n = arr.length;
        int[] count = new int[n];
        int top = -1;
        for (int i = 0; i < n; i++) {
            if (top == -1) {
                ++top;
                arr[top] = arr[i];
                count[top] = 1;
            } else {
                //if curr character matches stack top and stack top's count + 1(that of curr char)
                //matches k then we just need to remove k-1 chars in stack + 1(our curr char)
                if (top >= 0 && arr[top] == arr[i] && (count[top] + 1) == k) {
                    top -= k - 1;
                } 
                //otherwise push character in stack with incrementing top
                else {
                    top++;
                    //if stack top's char matches our current char then increment our count 
                    //otherwise put count=1 for new char encountered
                    count[top] = (arr[top - 1] == arr[i]) ? (count[top - 1] + 1) : 1;
                    arr[top] = arr[i];
                }
            }
        }
        //convert stack to string
        return new String(arr, 0, top + 1);
    }
}