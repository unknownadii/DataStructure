package Graph.BFS;

import Graph.ConstructGraph;

import java.util.ArrayDeque;
import java.util.ArrayList;

public class IsGraphCyclic {
    static class Pair {
        int vertex;
        String pathSoFar;

        public Pair(int vertex, String pathSoFar) {
            this.vertex = vertex;
            this.pathSoFar = pathSoFar;
        }
    }

    private static boolean isCyclic(ArrayList<ConstructGraph.Edges>[] graph, int source, boolean[] visited) {
        ArrayDeque<Pair> queue = new ArrayDeque<>();
        queue.add(new Pair(source,source+""));
        while (queue.size() > 0) {
            Pair temp = queue.remove();
            if (visited[temp.vertex]) {
                return true;
            }
            visited[temp.vertex] = true;
            for (ConstructGraph.Edges e : graph[temp.vertex]) {
                if (!visited[e.neighbour]) {
                    queue.add(new Pair(e.neighbour, temp.pathSoFar + e.neighbour));
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
        //obj.constructUnDirectedGraph(2, 3, 10);
        obj.constructUnDirectedGraph(3, 4, 10);
        obj.constructUnDirectedGraph(4, 5, 10);
        obj.constructUnDirectedGraph(5, 6, 10);
        //obj.constructUnDirectedGraph(6, 4, 10);
        obj.display();
        System.out.println();
        int vertexSize = 7;
        boolean[] visited = new boolean[vertexSize];

        //checking for every unvisited because user can provide any type of graph which
        // may have components(like getallComponenet Question) or may not have any components.
        for (int i = 0; i < vertexSize; i++) {
            if (!visited[i]) {
                boolean haveCycle = isCyclic(obj.graph, i, visited);
                if (haveCycle) {
                    System.out.println(true);
                    return;
                }
            }
        }
        System.out.println(false);
    }
}
