public class GraphTraversal {
    
    // -- graph as an adjacency matrix data structure
    public int[][] graph = {
        {0, 1, 0, 0, 0, 0, 0, 0, 0},
        {1, 0, 1, 0, 0, 0, 0, 1, 0},
        {0, 1, 0, 0, 0, 0, 0, 1, 0},
        {0, 0, 0, 0, 0, 0, 0, 1, 1},
        {0, 0, 0, 0, 0, 1, 1, 0, 0},
        {0, 0, 0, 0, 1, 0, 0, 0, 0},
        {0, 0, 0, 0, 1, 0, 0, 1, 0},
        {0, 1, 1, 1, 0, 0, 1, 0, 0},
        {0, 0, 0, 1, 0, 0, 0, 0, 0}
    };

    public int[] marks = {0, 0, 0, 0, 0, 0, 0, 0, 0};

    // -- visitation is just printing the node being visited
    public void visit(int v) {
        System.out.println("Visit: " + v);
    }

    // -- mark node v as visited
    public void mark(int v) {
        marks[v] = 1;
    }

    // -- this is for an adjacency matrix, if you have an adj list, pass that in instead
    // -- perform the Depth First Traversal
    public void DepthFirstTraversal(int[][] graph, int v) {
        // -- visit node v
        visit(v);
        // -- visit node v as visited
        mark(v);
        // -- for all edges vw in graph
        for (int w = 0; w < graph[v].length; w++) {
        // -- this is for greatest to least
        // -- for (int w = graph[v].length - 1; w >= 0; w--) {} 

            // check if an edge exists at (v,w)
            if (graph[v][w] == 1) {
                // -- if w is not marked
                if (marks[w] == 0) {
                    // -- recursive call from node w
                    DepthFirstTraversal(graph, w);
                }
            }
        }
    }
    public static void main(String args[]) {
        GraphTraversal traversal = new GraphTraversal();

        traversal.DepthFirstTraversal(traversal.graph, 0);
    }
}