package Graph.DijkstrasAlgorithm;

import Graph.ConstructGraph;

import java.util.ArrayList;
import java.util.PriorityQueue;

/*
Dijkstra's Algorithm is a normal BFS/level order traversal but in bfs we were using Normal Queue
but in this Dijkstra's Algorithm we were using PriorityQueue
 */
public class ImplementationDijkstrasAlgorithm {

    static class Pair implements Comparable<Pair> {
        int v;
        String psf;
        int wsf;

        Pair(int v, String psf, int wsf) {
            this.v = v;
            this.psf = psf;
            this.wsf = wsf;
        }

        public int compareTo(Pair o) {
            return this.wsf - o.wsf;
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
        shortestPath(obj.graph, visited, src);
    }

    private static void shortestPath(ArrayList<ConstructGraph.Edges>[] graph, boolean[] visited, int src) {
        PriorityQueue<Pair> queue = new PriorityQueue<>();
        queue.add(new Pair(src, src + "", 0));
        while (queue.size() > 0) {
            Pair rem = queue.remove();

            if (visited[rem.v] == true) {
                continue;
            }
            visited[rem.v] = true;
            System.out.println("Vertex -> " + rem.v + " , Path From " + src + " -> " + rem.v +" = " + (rem.psf) +
                    " , Weight Total From " + src + " -> " + rem.v +" = " + rem.wsf);

            for (ConstructGraph.Edges e : graph[rem.v]) {
                if (visited[e.neighbour] == false) {
                    queue.add(new Pair(e.neighbour, rem.psf + e.neighbour, rem.wsf + e.weight));
                }
            }
        }
    }


}
