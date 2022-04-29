//Graph Coloring - DFS
// 0 = uncolored
// 1 = blue
// -1 = red

// TIME: O(V+E), SPACE: O(V)
class Solution {
    public boolean isBipartite(int[][] g) {
        int[] colors = new int[g.length];//color for each node in graph
        for (int i = 0; i < g.length; i++)
            //if a node is uncoloured(not connected to any other node => no way to get to that)
            //and, we are not able to colour it
            if (colors[i] == 0 && !validColor(g, colors, 1, i)) // initially we are coloring the node blue
                return false;
        //return true as no conflict in colouring found
        return true;
    }

    //check if we can color the graph with the color we want
    boolean validColor(int[][] g, int[] colors, int color, int node) {
        //if it is already coloured then check if our color is same as the color of the node which means there is no conflict, otherwise there is a conflict and the graph is not bipartite
        if (colors[node] != 0) 
            return colors[node] == color;
        
        //if it is not colored, the color it with our color
        colors[node] = color;
        //check all adjacent nodes and color it with the other color than our color
        for (int adjacent : g[node])
            //return false if coloring is not possible
            if (!validColor(g, colors, -color, adjacent))
                return false;
        return true;
    }
}