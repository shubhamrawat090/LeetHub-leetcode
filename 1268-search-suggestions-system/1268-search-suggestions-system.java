// Logic:
// The approach I had in mind is quite simple! All we need to do is add each product to a prefix trie and then perform a depth-first-search through the trie for each character of our searchWord to add our three-word suggestions. The key bit of implementation here is that we're keeping track of those suggested words while we're inserting products into our trie.

// The way we do this is by using the TrieNode class itself to store our suggested words:

// At each TrieNode, we include a priority queue that stores up to 3 words that share the current character in the trie.
// Our priority queue comparator will keep the larger lexicoographical word on top. The reason we do this is so that we can pop it off whenever our pq exceeds a size of 3.
// Therefore, our bottom 3 words that will never get popped off are the first lexicographically ordered words.
// Observe how we would build our Trie whilst keeping our 3-word storage in mind:

// As you can see, all we'd need to do once we've obtained our Trie structure, all we'd need to do was perform a depth-first search down the trie for each character of searchWord and collect the stored words at each node. We'll let our TrieNode class take care of all priority queue management, including building our list of three words.

// Awesome, now we're ready to start coding!

// Code:
// If you have any questions, suggestions or improvements, feel free to let me know!

class TrieNode {
    public TrieNode[] children;
    public PriorityQueue<String> pq;
    
    public TrieNode() {
        children = new TrieNode[26];
        pq = new PriorityQueue<>((a,b) -> b.compareTo(a));
    }
    
    public void addToPQ(String word) {
        pq.add(word);
        if (pq.size() > 3) pq.poll();
    }
    
    public List<String> getTopThree() {
        List<String> topThree = new ArrayList<>();
        while (!pq.isEmpty()) topThree.add(pq.poll());
        Collections.reverse(topThree);
        return topThree;
    }
}
class Solution {
    public List<List<String>> suggestedProducts(String[] products, String searchWord) {
        TrieNode root = new TrieNode();
        for (String product: products) insert(root, product);
        
        List<List<String>> results = new ArrayList<>();
        for (char c: searchWord.toCharArray()) {
            if ((root = root.children[c - 'a']) == null) break;
            results.add(root.getTopThree());            
        }
        
        while (results.size() < searchWord.length()) 
			results.add(new ArrayList<>());
        return results;
    }
    
    private void insert(TrieNode root, String word) {
        for (char c : word.toCharArray()) {
            if (root.children[c - 'a'] == null) 
				root.children[c - 'a'] = new TrieNode();
            root = root.children[c - 'a'];
            root.addToPQ(word);
        }
    }
}
// Time complexity: O(m) where m is the number of characters in products.
// Space complexity: O(m*n) where n is the number of products.