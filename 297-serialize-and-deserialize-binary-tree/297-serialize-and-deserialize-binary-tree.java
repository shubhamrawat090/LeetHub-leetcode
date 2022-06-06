/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Codec {
    
    class Pair{
        TreeNode node;
        int state;
    }

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        if(root == null) {
            return "";
        }
        
        StringBuilder str = new StringBuilder();
        traverse(root, str);
        return str.toString();
    }
    
    private void traverse(TreeNode root, StringBuilder str) {
        if(root == null) {
            str.append(". ");
            return;
        }
        
        str.append(root.val+" ");
        traverse(root.left, str);
        traverse(root.right, str);
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if(data.isEmpty() || data.charAt(0) == '.')
            return null;
        
        String[] dString = data.split(" ");
        Stack<Pair> stk = new Stack<>();
        int i=0;
        Pair rootPair = new Pair();
        rootPair.node = new TreeNode(Integer.parseInt(dString[i]));
        
        stk.push(rootPair);
        
        while(stk.size()>0) {
            Pair curr = stk.peek();
            
            if(curr.state == 0) {
                curr.state++;
                i++;
                if(!dString[i].equals(".")) {
                    Pair leftPair = new Pair();
                    leftPair.node = new TreeNode(Integer.parseInt(dString[i]));
                    curr.node.left = leftPair.node;
                    stk.push(leftPair);
                }
            } else if(curr.state == 1) {
                curr.state++;
                i++;
                if(!dString[i].equals(".")) {
                    Pair rightPair = new Pair();
                    rightPair.node = new TreeNode(Integer.parseInt(dString[i]));
                    curr.node.right = rightPair.node;
                    stk.push(rightPair);
                }
            } else {
                stk.pop();
            }
        }
        
        return rootPair.node;
    }
}

// Your Codec object will be instantiated and called as such:
// Codec ser = new Codec();
// Codec deser = new Codec();
// TreeNode ans = deser.deserialize(ser.serialize(root));