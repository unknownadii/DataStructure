package Graph.BFS;

import Graph.ConstructGraph;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.HashMap;

public class IsGraphBipartite {
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
        //obj.constructUnDirectedGraph(6, 4, 10);
        obj.display();
        System.out.println();


        int vertexSize = 7;
        HashMap<Integer, Integer> visited = new HashMap<>();
        for (int v = 0; v < vertexSize; v++) {
            if (!visited.containsKey(v)) {
                boolean bip = IsBipartite(obj.graph, v, visited);
                if (!bip) {
                    System.out.println(false);
                    return;
                }
            }
        }

        System.out.println(true);
    }

    static class Pair {
        int vtx;
        int level;

        Pair(int vtx, int level) {
            this.vtx = vtx;
            this.level = level;
        }
    }

    public static boolean IsBipartite(ArrayList<ConstructGraph.Edges>[] graph, int src, HashMap<Integer, Integer> visited) {
        ArrayDeque<Pair> queue = new ArrayDeque<>();
        queue.add(new Pair(src, 0));
        while (queue.size() > 0) {
            Pair rem = queue.remove();

            if (visited.containsKey(rem.vtx)) {
                if (visited.get(rem.vtx) % 2 != rem.level % 2) {
                    return false;
                }
            } else {
                visited.put(rem.vtx, rem.level);
            }

            for (ConstructGraph.Edges e : graph[rem.vtx]) {
                if (!visited.containsKey(e.neighbour)) {
                    queue.add(new Pair(e.neighbour, rem.level + 1));
                }
            }
        }

        return true;
    }
}
