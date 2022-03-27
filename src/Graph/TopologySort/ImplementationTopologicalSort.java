package Graph.TopologySort;

import Graph.ConstructGraph;

import java.util.ArrayList;
import java.util.Stack;

public class ImplementationTopologicalSort {
    public static void main(String[] args) {
        int vertexSize = 7;
        ConstructGraph obj = new ConstructGraph(vertexSize);
        // Weighted UnDirected Graph
        System.out.println("Directed Graph");
        obj.constructDirectedGraph(0, 1 );
        obj.constructDirectedGraph(1, 2 );
        obj.constructDirectedGraph(0, 3);
        obj.constructDirectedGraph(2, 3);
        obj.constructDirectedGraph(4, 3);
        obj.constructDirectedGraph(4, 5);
        obj.constructDirectedGraph(4, 6);
        obj.constructDirectedGraph(5, 6);
        obj.display();
        System.out.println();

        boolean[] visited = new boolean[vertexSize];
        int src = 0;

        topologicalSort(obj.graph, visited, vertexSize);

    }

    private static void topologicalSort(ArrayList<ConstructGraph.Edges>[] graph, boolean[] visited, int vertexSize) {
        Stack<Integer> st = new Stack<>();
        for (int v = 0; v < vertexSize; v++) {
            if (visited[v] == false) {
                topologicalHelper(graph, v, visited, st);
            }
        }
        while (st.size() > 0) {
            System.out.println(st.pop());
        }
    }

    public static void topologicalHelper(ArrayList<ConstructGraph.Edges>[] graph, int src,
                                         boolean[] visited, Stack<Integer> st) {
        visited[src] = true;
        for (ConstructGraph.Edges e : graph[src]) {
            if (!visited[e.neighbour]) {
                topologicalHelper(graph, e.neighbour, visited, st);
            }
        }
        st.push(src);
    }
}
