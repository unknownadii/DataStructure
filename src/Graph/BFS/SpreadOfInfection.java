package Graph.BFS;

import Graph.ConstructGraph;

import java.util.ArrayDeque;
import java.util.ArrayList;

/*
1. You are given a graph, representing people and their connectivity.
2. You are also given a src person (who got infected) and time t.
3. You are required to find how many people will get infected in time t,
 if the infection spreads to neighbors of infected person in 1 unit of time.
 */
public class SpreadOfInfection {
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
        int t = 3;
        int source = 6;

        spreadOfInfection(obj.graph, t, source, vertexSize);

    }

    private static void spreadOfInfection(ArrayList<ConstructGraph.Edges>[] graph, int t, int src, int vtces) {
        int count = 0;

        ArrayDeque<Pair> queue = new ArrayDeque<>();
        queue.add(new Pair(src, 1));
        int[] visited = new int[vtces];
        while (queue.size() > 0) {
            Pair rem = queue.remove();

            // if visited[rem.v] > 0 == true then this vertex is visited
            if (visited[rem.v] > 0) {
                continue;
            }

            visited[rem.v] = rem.time;
            if (rem.time > t) {
                break;
            } else {
                count++;
            }

            for (ConstructGraph.Edges e : graph[rem.v]) {
                if (visited[e.neighbour] == 0) {
                    queue.add(new Pair(e.neighbour, rem.time + 1));
                }
            }
        }

        System.out.println(count);
    }

    static class Pair {
        int v;
        int time;

        Pair(int v, int time) {
            this.v = v;
            this.time = time;
        }
    }
}

