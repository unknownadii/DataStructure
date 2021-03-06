package Graph.DFSQuestions;

import Graph.ConstructGraph;

import java.util.ArrayList;
import java.util.HashSet;

/*
1. You are given a graph and a src vertex.
2. You are required to find and print all hamiltonian paths and cycles starting from src. The cycles must end with "*" and paths with a "."

Note -> A hamiltonian path is such which visits all vertices without visiting any twice. A hamiltonian path becomes a cycle if there is an edge between first and last vertex.
Note -> Print in lexicographically increasing order.

Sample Input
7
9
0 1 10
1 2 10
2 3 10
0 3 10
3 4 10
4 5 10
5 6 10
4 6 10
2 5 10
0

Sample Output
0123456.
0123465.
0125643*
0346521*
 */
public class PrintHamiltonianPathAndCycle {
    public static void main(String[] args) {
        ConstructGraph obj = new ConstructGraph(7);
        System.out.println("Weighted UnDirected Graph");
        obj.constructUnDirectedGraph(0, 1, 10);
        obj.constructUnDirectedGraph(1, 2, 10);
        obj.constructUnDirectedGraph(0, 3, 10);
        obj.constructUnDirectedGraph(2, 3, 10);
        obj.constructUnDirectedGraph(3, 4, 10);
        obj.constructUnDirectedGraph(4, 5, 10);
        obj.constructUnDirectedGraph(2, 5, 10);//connecting 2nd and 5th node
        obj.constructUnDirectedGraph(5, 6, 10);
        obj.constructUnDirectedGraph(6, 4, 10);
        obj.display();
        System.out.println();
        // we are using visited to avoid the condition of cyclic graph in which it will rotate infinitely
        HashSet<Integer> visited = new HashSet<>();
        int source = 0;
        hamiltonianPathAndCycle(obj.graph, source, source, visited, source + " ");
    }

    public static void hamiltonianPathAndCycle(ArrayList<ConstructGraph.Edges>[] graph,
                                               int osrc, int src, HashSet<Integer> visited, String psf) {
        if (visited.size() == graph.length - 1) {
            System.out.print(psf);

            boolean closingEdge = false;
            for (ConstructGraph.Edges e : graph[osrc]) {
                if (e.neighbour == src) {
                    closingEdge = true;
                    break;
                }
            }

            if (closingEdge) {
                System.out.println("*");
            } else {
                System.out.println(".");
            }
            return;
        }

        visited.add(src);
        for (ConstructGraph.Edges e : graph[src]) {
            if (!visited.contains(e.neighbour)) {
                hamiltonianPathAndCycle(graph, osrc, e.neighbour, visited, psf + e.neighbour + " ");
            }
        }
        visited.remove(src);
    }
}
