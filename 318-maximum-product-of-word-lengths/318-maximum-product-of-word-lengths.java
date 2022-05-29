// Idea is to reduce the k^2 to k by puting all the characters of each string into a set.

// Time Complexity - O(n.k) + O(n^2.k) ~ O(n^2.k)
// where -
// n.k = to put all characters of each string into the set
// n^2 = to iterate over all the strings and compare it with every other string.
// k = for each string s1, we need to iterate over all the k characters and check if the s2 string's set contains the character of s1 in O(1) time

// Space Complexity - O(n.k), to store all characters of each string into the set.

class Solution {
    public int maxProduct(String[] words) {
        int n = words.length;
        List<Set<Character>> lst = new ArrayList(n);
        int max = 0;

        for(String word : words) {	
            Set<Character> set = new HashSet();
            lst.add(set);
            for(int i=0; i<word.length(); i++) {
                set.add( word.charAt(i) );
            }
        }

        for(int i=0; i<n; i++) {
            Set<Character> setI = lst.get(i);
            for(int j=i+1; j<n; j++) {
                boolean hasCommon = false;
                Set<Character> setJ = lst.get(j);
                for(Character c : setI) {
                    if( setJ.contains(c) ) {
                        hasCommon = true;
                        break;
                    }
                }

                if( !hasCommon ) 
                    max = Math.max(max, words[i].length()*words[j].length());	
            }
        }
        return max;
    }
}