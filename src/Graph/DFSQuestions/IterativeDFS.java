package Graph.DFSQuestions;

import Graph.ConstructGraph;

import java.util.ArrayList;
import java.util.Stack;

/*
Same Trick as BFS But use Stack insit of Queue
 */
public class IterativeDFS {
    public static void main(String[] args) {
        int vertexSize = 7;
        ConstructGraph obj = new ConstructGraph(vertexSize);
        // Weighted UnDirected Graph
        System.out.println("Directed Graph");
        obj.constructDirectedGraph(0, 1);
        obj.constructDirectedGraph(1, 2);
        obj.constructDirectedGraph(0, 3);
        obj.constructDirectedGraph(2, 3);
        obj.constructDirectedGraph(4, 3);
        obj.constructDirectedGraph(4, 5);
        obj.constructDirectedGraph(4, 6);
        obj.constructDirectedGraph(5, 6);
        obj.display();
        System.out.println();

        int src = 0;
        iterativeDFS(obj.graph, vertexSize, src);

    }

    private static void iterativeDFS(ArrayList<ConstructGraph.Edges>[] graph, int vertexSize, int src) {
        Stack<Pair> stack = new Stack<>();
        stack.push(new Pair(src, src + ""));
        boolean[] visited = new boolean[vertexSize];
        while (stack.size() > 0) {
            Pair rem = stack.pop();

            if (visited[rem.v] == true) {
                continue;
            }
            visited[rem.v] = true;
            System.out.println(rem.v + "@" + rem.psf);

            for (ConstructGraph.Edges e : graph[rem.v]) {
                if (visited[e.neighbour] == false) {
                    stack.push(new Pair(e.neighbour, rem.psf + e.neighbour));
                }
            }
        }
    }

    static class Pair {
        int v;
        String psf;

        Pair(int v, String psf) {
            this.v = v;
            this.psf = psf;
        }
    }
}
