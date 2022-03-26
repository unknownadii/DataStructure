package Graph.Questions;

import Graph.ConstructGraph;

import java.util.ArrayList;
import java.util.Scanner;

/*
1. You are given a number n (representing the number of students). Each student will have an id
     from 0 to n - 1.
2. You are given a number k (representing the number of clubs)
3. In the next k lines, two numbers are given separated by a space. The numbers are ids of
     students belonging to same club.
4. You have to find in how many ways can we select a pair of students such that both students are
     from different clubs.

Sample Input
7 // no of vertexes
5 // no of clubes OR no of components in which graph is divided
0 1
2 3
4 5
5 6
4 6
Sample Output
16
 */
public class PerfectFriends {

    public static ArrayList<ArrayList<Integer>> getConnectedComponent(ArrayList<ConstructGraph.Edges>[] graph,
                                                                      boolean[] visited, int vertex) {
        ArrayList<ArrayList<Integer>> allComponents = new ArrayList<>();
        for (int i = 0; i < vertex; i++) {
            if (!visited[i]) {
                ArrayList<Integer> connectedNodes = new ArrayList<>();
                getConnectedComponentHelper(graph, i, visited, connectedNodes);
                allComponents.add(connectedNodes);
            }
        }
        return allComponents;
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

    public static int countPairs(ArrayList<ArrayList<Integer>> componentsList) {
        int count = 0;
        for(int i = 0; i < componentsList.size(); i++){
            for(int j = i + 1; j < componentsList.size(); j++){
                count += componentsList.get(i).size() * componentsList.get(j).size();//size list1 * size of list2
            }
        }
        return count;
    }

    public static void main(String[] args) {
        int totalNodes = 7;
        int totalComponents = 5;
        ConstructGraph obj = new ConstructGraph(totalNodes);

        obj.constructUnDirectedGraph(0, 1);
        obj.constructUnDirectedGraph(2, 3);
        obj.constructUnDirectedGraph(4, 5);
        obj.constructUnDirectedGraph(5, 6);
        obj.constructUnDirectedGraph(4, 6);

        boolean[] visited = new boolean[totalNodes];
        ArrayList<ArrayList<Integer>> componentsList = getConnectedComponent(obj.graph, visited, totalNodes);

        int count = countPairs(componentsList);
        System.out.println(count);
    }

}
