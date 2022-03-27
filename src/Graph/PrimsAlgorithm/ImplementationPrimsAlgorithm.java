package Graph.PrimsAlgorithm;

import Graph.ConstructGraph;

import java.util.ArrayList;
import java.util.PriorityQueue;

/*
Prims Algorithm(minimum spanning tree MST )
(same as dijkstra Algorithm but in place of "psf" we take "comingFromVertex" and
in place of "wsf" we take weight of current vertex)
is a normal BFS/level order traversal but in bfs we were using Normal Queue
but in this Prims Algorithm we were using PriorityQueue
 */

public class ImplementationPrimsAlgorithm {

    static class Pair implements Comparable<Pair> {
        int vertex;
        int comingFromVertex;
        int weightOfVertex;

        public Pair(int vertex, int comingFromVertex, int weightOfVertex) {
            this.vertex = vertex;
            this.comingFromVertex = comingFromVertex;
            this.weightOfVertex = weightOfVertex;
        }

        public int compareTo(Pair o) {
            return this.weightOfVertex - o.weightOfVertex;
        }
    }

    public static void main(String[] args) {
        int vertexSize = 7;
        ConstructGraph obj = new ConstructGraph(vertexSize);
        // Weighted UnDirected Graph
        System.out.println("Weighted UnDirected Graph");
        obj.constructUnDirectedGraph(0, 1, 10);
        obj.constructUnDirectedGraph(1, 2, 20);
        obj.constructUnDirectedGraph(0, 3, 20);
        obj.constructUnDirectedGraph(2, 3, 40);
        obj.constructUnDirectedGraph(3, 4, 50);
        obj.constructUnDirectedGraph(4, 5, 60);
        obj.constructUnDirectedGraph(5, 6, 70);
        obj.constructUnDirectedGraph(6, 4, 80);
        obj.display();
        System.out.println();

        boolean[] visited = new boolean[vertexSize];
        int src = 0;

        primsAlgorithm(obj.graph, visited, src);
    }

    private static void primsAlgorithm(ArrayList<ConstructGraph.Edges>[] graph, boolean[] visited, int src) {
        PriorityQueue<Pair> queue = new PriorityQueue<>();
        queue.add(new Pair(src, -1, 0));
        while (queue.size() > 0) {
            //remove
            Pair temp = queue.remove();
            // check visited
            if (visited[temp.vertex]) {
                continue;
            }
            // mark visited
            visited[temp.vertex] = true;

            // Do your Work (Like printing or etc..)
            System.out.println("Current Vertex -> " + temp.vertex + " Previous vertex -> "
                    + temp.comingFromVertex + " Weight Of current vertex -> " + temp.weightOfVertex);

            // add their un visited neighbour
            for (ConstructGraph.Edges e : graph[temp.vertex]) {
                if (!visited[e.neighbour]) {
                    queue.add(new Pair(e.neighbour, temp.vertex, e.weight));
                }
            }
        }
    }
}
