/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> neighbors;
    public Node() {
        val = 0;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val) {
        val = _val;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val, ArrayList<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
}
*/

class Solution {
    public Node cloneGraph(Node node) {
        if(node == null) {
            return null;
        }
        
        Node[] visited = new Node[101];
        return helper(node, visited);
    }
    
    private Node helper(Node node, Node[] visited) {
        Node nodeClone = new Node(node.val);
        visited[node.val] = nodeClone;
        
        for(Node nbr: node.neighbors) {
            if(visited[nbr.val] == null) {
                Node nbrClone = helper(nbr, visited);
                nodeClone.neighbors.add(nbrClone);
            } else {
                Node nbrClone = visited[nbr.val];
                nodeClone.neighbors.add(nbrClone);
            }
        }
        
        return nodeClone;
    }
}