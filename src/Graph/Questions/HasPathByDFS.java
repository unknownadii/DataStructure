package Graph.Questions;

import Graph.ConstructGraph;

import java.util.ArrayList;

/*
1. You are given a graph, a src vertex and a destination vertex.
2. You are required to find if a path exists between src and dest. If it does, print true
     otherwise print false.
 */
public class HasPathByDFS {

    private static boolean hasPath(int source, int destination, ArrayList<ConstructGraph.Edges>[] graph, boolean[] visited) {
        if (source == destination) {
            return true;
        }
        visited[source] = true;
        for (ConstructGraph.Edges edges : graph[source]) {
            if (!visited[edges.neighbour]) {
                boolean returnAnswer = hasPath(edges.neighbour, destination, graph, visited);
                if (returnAnswer) {
                    return true;
                }
            }
        }
        return false;
    }

    public static void main(String[] args) {
        ConstructGraph obj = new ConstructGraph(7);

        // Weighted UnDirected Graph
        System.out.println("Weighted UnDirected Graph");
        obj.constructUnDirectedGraph(0, 1, 10);
        obj.constructUnDirectedGraph(1, 2, 10);
        obj.constructUnDirectedGraph(0, 3, 10);
        obj.constructUnDirectedGraph(2, 3, 10);
        obj.constructUnDirectedGraph(3, 4, 10);
        obj.constructUnDirectedGraph(4, 5, 10);
        obj.constructUnDirectedGraph(5, 6, 10);
        obj.constructUnDirectedGraph(6, 4, 10);
        obj.display();
        System.out.println();
        // we are using visited to avoid the condition of cyclic graph in which it will rotate infinitely
        boolean[] visited = new boolean[7];
        System.out.println(hasPath(2, 6, obj.graph, visited));

    }
}
