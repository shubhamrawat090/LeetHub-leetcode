class Solution {
    //storing parent of set and multiplier from value to their parents
    HashMap<String, String> parent;
    HashMap<String, Double> mult;
    
    //initialize parent of all operands to themselves and their multipliers as 1.0
    private void initializerDSU(String x) {
        if(parent.containsKey(x) == false) {
            parent.put(x, x);
            mult.put(x, 1.0);
        }
    }
    
    public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {
        parent = new HashMap<>();
        mult = new HashMap<>();
        
        for(List<String> eq: equations) {
            initializerDSU(eq.get(0));
            initializerDSU(eq.get(1));
        }
        
        //Build DSU
        int i=0; //iterator
        for(List<String> eq: equations) {
            //get leaders and multipliers
            String l0 = find(eq.get(0));
            String l1 = find(eq.get(1));
            
            Double m0 = mult.get(eq.get(0));
            Double m1 = mult.get(eq.get(1));
            
            //perform union(without considering ranks)
            parent.put(l0, l1);
            mult.put(l0, m1*values[i]/m0);
            
            i++;
        }
        
        //iterate queries to check in DSU and find a possible path to go from operand a to operand b
        double[] res = new double[queries.size()];//store results corresponding to each query
        i=0;//reset iterator
        
        for(List<String> query: queries) {
            if(!parent.containsKey(query.get(0)) || !parent.containsKey(query.get(1))) {
               res[i] = -1.0;
               i++;
               continue;
            }
            
            //find leaders of set of both operands of query
            String l0 = find(query.get(0));
            String l1 = find(query.get(1));
            
            if(!l0.equals(l1)) {
               res[i] = -1.0;
               i++;
               continue;
            }
            
            //get the multipliers of both operands and divide them to get the ans
            Double m0 = mult.get(query.get(0));
            Double m1 = mult.get(query.get(1));
            
            res[i] = m0/m1;
            
            i++;
        }
        
        return res;
    }
    
    String find(String x) {
        if(parent.get(x).equals(x)) {
            return x;
        } else {
            String currParent = parent.get(x);
            String leader = find(currParent);
            
            parent.put(x, leader);
            mult.put(x, mult.get(currParent) * mult.get(x));
            
            return leader;
        }
    }
}