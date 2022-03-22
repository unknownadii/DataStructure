package Graph;

import java.util.Collections;

public class MainGraph {
    public static void main(String[] args) {
        ConstructGraph obj = new ConstructGraph(7);

        // Weighted UnDirected Graph
        /*
        System.out.println("Weighted UnDirected Graph");
        obj.constructUnDirectedGraph(0, 1, 10);
        obj.constructUnDirectedGraph(1, 2, 10);
        obj.constructUnDirectedGraph(0, 3, 10);
        obj.constructUnDirectedGraph(2, 3, 10);
        obj.constructUnDirectedGraph(4, 5, 10);
        obj.constructUnDirectedGraph(5, 6, 10);
        obj.constructUnDirectedGraph(6, 4, 10);
        obj.display();
        System.out.println();

         */

        // Weighted Directed Graph
        System.out.println("Weighted Directed Graph");
        obj.constructDirectedGraph(0, 1, 10);
        obj.constructDirectedGraph(1, 2, 10);
        obj.constructDirectedGraph(0, 3, 10);
        obj.constructDirectedGraph(2, 3, 10);
        obj.constructDirectedGraph(4, 5, 10);
        obj.constructDirectedGraph(5, 6, 10);
        obj.constructDirectedGraph(6, 4, 10);
        obj.display();
    }
}
