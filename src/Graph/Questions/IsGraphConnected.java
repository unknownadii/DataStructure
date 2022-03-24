package Graph.Questions;

import Graph.ConstructGraph;

import java.util.ArrayList;

public class IsGraphConnected {

    public static void getConnectedComponent(ArrayList<ConstructGraph.Edges>[] graph, boolean[] visited,int vertex) {
        ArrayList<ArrayList<Integer>> allComponents = new ArrayList<>();
        for (int i = 0; i < vertex; i++) {
            if (!visited[i]) {
                ArrayList<Integer> connectedNodes = new ArrayList<>();
                getConnectedComponentHelper(graph, i, visited, connectedNodes);
                allComponents.add(connectedNodes);
            }
        }
        System.out.println(allComponents.size()==1);
    }

    private static void getConnectedComponentHelper(ArrayList<ConstructGraph.Edges>[] graph, int src,
                                                    boolean[] visited, ArrayList<Integer> connectedNodes) {
        connectedNodes.add(src);
        visited[src] = true;
        for (ConstructGraph.Edges edges : graph[src]) {
            if (!visited[edges.neighbour]) {
                getConnectedComponentHelper(graph, edges.neighbour, visited, connectedNodes);
            }
        }
    }

    public static void main(String[] args) {
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
        int numberOfNodes = 7;
        boolean[] visited = new boolean[numberOfNodes];
         getConnectedComponent(obj.graph, visited,7);
    }
}
