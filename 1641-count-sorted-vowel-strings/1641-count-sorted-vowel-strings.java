class Solution {
    //no. of combinations of length n with k values with repetitions = (n + k - 1)!/((k-1)!*(n)!)
    //put n, k=5(5 vowels) => (n+4)!/(4!*n!) --> further simplified to (n+4)*(n+3)*(n+2)*(n+1) / 24
    public int countVowelStrings(int n) {
        return (n+4)*(n+3)*(n+2)*(n+1) / 24;
    }
}