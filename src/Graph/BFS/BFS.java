package Graph.BFS;

import Graph.ConstructGraph;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Queue;

public class BFS {

    static class Pair {
        int vertex;
        String pathSoFar;

        public Pair(int vertex, String pathSoFar) {
            this.vertex = vertex;
            this.pathSoFar = pathSoFar;
        }
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
        int vertexSize = 7;
        int source = 2;
        bfsTraversalOrLevelOrderTraversal(obj.graph, vertexSize, source);

    }

    private static void bfsTraversalOrLevelOrderTraversal(ArrayList<ConstructGraph.Edges>[] graph,
                                                          int vertexesSize, int src) {
        boolean[] visited = new boolean[vertexesSize];
        ArrayDeque<Pair> queue = new ArrayDeque<>();
        queue.add(new Pair(src, src+""));
        while (queue.size() > 0) {
            Pair rem = queue.remove();

            if (visited[rem.vertex] == true) {
                continue;
            }
            visited[rem.vertex] = true;
            System.out.println(rem.vertex + "@" + rem.pathSoFar);

            for (ConstructGraph.Edges e : graph[rem.vertex]) {
                if (visited[e.neighbour] == false) {
                    queue.add(new Pair(e.neighbour, rem.pathSoFar + e.neighbour));
                }
            }
        }
    }
}

