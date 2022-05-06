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
                if (top >= 0 && arr[top] == arr[i] && (count[top] + 1) == k) {
                    top -= k - 1;
                } else {
                    top++;
                    count[top] = (arr[top - 1] == arr[i] ? (count[top - 1] + 1) : 1);
                    arr[top] = arr[i];
                }
            }
        }
        return new String(arr, 0, top + 1);
    }
}