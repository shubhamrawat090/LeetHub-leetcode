class Solution {
    //helper class with dest->value(weights) pair
    class Node {
        String key;
        double val;

        public Node(String k, double v) {
            key = k;
            val = v;
        }
    }

    public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {
        //build a graph with (src, {dest, value})
        //we use map because graph is dynamic as there is diff wt associated to diff directions
        Map<String, List<Node>> g = buildGraph(equations, values);
        
        //contains the result for each query
        double[] result = new double[queries.size()];
        //call dfs for each query
        for (int i = 0; i < queries.size(); i++)
            //dfs returns the result of each query via traversing graph from query[0] to query[1] and multiplying the values(wt.)
            result[i] = dfs(queries.get(i).get(0), queries.get(i).get(1), new HashSet(), g);
        
        //return the calcualted result for each query
        return result;
    }

    //dfs implementation
    private double dfs(String s, String d, Set<String> visited, Map<String, List<Node>> g) {
        //if src or dest variables are not present in the graphs then there is no way to calculate the result
        if (!(g.containsKey(s) && g.containsKey(d)))
            return -1.0;
        //src/dest = 1 if src == dest
        if (s.equals(d))
            return 1.0;
        
        //add current node in visited
        visited.add(s);
        //traverse all nodes from the src
        for (Node ng : g.get(s)) {
            //go to the node only if not visited already
            if (!visited.contains(ng.key)) {
                //find the ans from the neighbour node
                double ans = dfs(ng.key, d, visited, g);
                //multiply the ans with our node's answer only if it isn't -1 and return it
                if (ans != -1.0)
                    return ans * ng.val;
            }
        }
        //return -1 if you can't find the result
        return -1.0;
    }

    // build graph
    private Map<String, List<Node>> buildGraph(List<List<String>> eq, double[] values) {
        Map<String, List<Node>> g = new HashMap();
        for (int i = 0; i < values.length; i++) {
            //in equations list, get src = variable1 and dest = variable2
            String src = eq.get(i).get(0);
            String des = eq.get(i).get(1);
            //if src or dest is not available then initialize it
            g.putIfAbsent(src, new ArrayList());
            g.putIfAbsent(des, new ArrayList());
            //find the variable src/dest and ad the corresponding values to it like
            // src->dest = val , dest->src = 1/val
            // add those as nodes in graph
            g.get(src).add(new Node(des, values[i]));
            g.get(des).add(new Node(src, 1 / values[i]));
        }
        //return the graph built
        return g;
    }
}