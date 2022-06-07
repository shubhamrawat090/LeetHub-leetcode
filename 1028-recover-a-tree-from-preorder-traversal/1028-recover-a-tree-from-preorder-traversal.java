class Solution {
    class pair{
        TreeNode node;
        int count;
    }
    
    int i = 0;

    public pair dfs(String traversal, int level){
        int initial = i;

        //count value i.e. non '-'
        for( ; i < traversal.length(); i++)
           if(traversal.charAt(i) == '-')
               break;

        String s = traversal.substring(initial , i);
        int val =  Integer.parseInt(s);

        //count '-'
        int count = 0;
        for( ; i < traversal.length(); i++){

            if(traversal.charAt(i) != '-')
                break;

            count++;
        } 

        pair p = new pair();
        p.node = new TreeNode(val);

        p.count = count;

        if(p.count != level)
          return p;

        pair left = dfs(traversal, level + 1);
        p.node.left = left.node;
        p.count = left.count;

        if(left.count != level)
            return p;

        pair right = dfs(traversal, level+1);
        p.node.right = right.node;
        p.count = right.count;

        return p;
    }


    public TreeNode recoverFromPreorder(String traversal) {
        pair p = dfs(traversal, 1);
        return p.node; 
    }
    
}