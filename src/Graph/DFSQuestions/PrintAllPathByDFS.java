package Graph.DFSQuestions;

import Graph.ConstructGraph;

import java.util.ArrayList;

public class PrintAllPathByDFS {
    private static void printAllPaths(ArrayList<ConstructGraph.Edges>[] graph, int src, int dest, boolean[] visited, String psf) {
        if (src == dest) {
            System.out.println(psf);
            return;
        }

        visited[src] = true;
        for (ConstructGraph.Edges e : graph[src]) {
            if (!visited[e.neighbour]) {
                printAllPaths(graph, e.neighbour, dest, visited, psf + e.neighbour+" ");
            }
        }
        visited[src] = false;
    }

    public static void main(String[] args) {
        // Weighted UnDirected Graph
        ConstructGraph obj = new ConstructGraph(7);
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
        printAllPaths(obj.graph,3, 6, visited, 3+ " ");
    }
}
