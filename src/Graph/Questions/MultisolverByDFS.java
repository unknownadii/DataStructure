package Graph.Questions;

import Graph.ConstructGraph;

import java.util.ArrayList;
import java.util.PriorityQueue;

public class MultisolverByDFS {

    static class Pair implements Comparable<Pair> {
        int weightSoFar;
        String pathSoFar;

        Pair(int wsf, String psf) {
            this.weightSoFar = wsf;
            this.pathSoFar = psf;
        }

        public int compareTo(Pair o) {
            return this.weightSoFar - o.weightSoFar;
        }

        static String smallestPath;
        static Integer smallestPathWeight = Integer.MAX_VALUE;
        static String largestPath;
        static Integer largestPathWeight = Integer.MIN_VALUE;
        static String ceilPath;
        static Integer ceilPathWeight = Integer.MAX_VALUE;
        static String floorPath;
        static Integer floorPathWeight = Integer.MIN_VALUE;
        static PriorityQueue<Pair> pq = new PriorityQueue<>();

        public static void multisolver(ArrayList<ConstructGraph.Edges>[] graph, int src, int dest, boolean[] visited,
                                       int numberForCeilAndFloor, int k, String pathSofar, int weightSoFar) {
            if (src == dest) {
                if (weightSoFar < smallestPathWeight) {
                    smallestPathWeight = weightSoFar;
                    smallestPath = pathSofar;
                }

                if (weightSoFar > largestPathWeight) {
                    largestPathWeight = weightSoFar;
                    largestPath = pathSofar;
                }

                if (weightSoFar < numberForCeilAndFloor && weightSoFar > floorPathWeight) {
                    floorPathWeight = weightSoFar;
                    floorPath = pathSofar;
                }

                if (weightSoFar > numberForCeilAndFloor && weightSoFar < ceilPathWeight) {
                    ceilPathWeight = weightSoFar;
                    ceilPath = pathSofar;
                }

                if (pq.size() < k) {
                    pq.add(new Pair(weightSoFar, pathSofar));
                } else if (weightSoFar > pq.peek().weightSoFar) {
                    pq.remove();
                    pq.add(new Pair(weightSoFar, pathSofar));
                }
                return;
            }

            visited[src] = true;
            for (ConstructGraph.Edges e : graph[src]) {
                if (!visited[e.neighbour]) {
                    multisolver(graph, e.neighbour, dest, visited, numberForCeilAndFloor,
                            k, pathSofar + e.neighbour, weightSoFar + e.neighbour);
                }
            }
            visited[src] = false;
        }

        public static void main(String[] args) {
            // Weighted UnDirected Graph
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
            boolean[] visited = new boolean[7];
            int numberForCeilAndFloor = 15;
            multisolver(obj.graph, 0, 6, visited, numberForCeilAndFloor, 3, 0 + "", 0);

            System.out.println("Smallest Path = " + smallestPath + "@" + smallestPathWeight);
            System.out.println("Largest Path = " + largestPath + "@" + largestPathWeight);
            System.out.println("Just Larger Path than " + numberForCeilAndFloor + " = " + ceilPath + "@" + ceilPathWeight);
            System.out.println("Just Smaller Path than " + numberForCeilAndFloor + " = " + floorPath + "@" + floorPathWeight);
            System.out.println(3 + "th largest path = " + pq.peek().pathSoFar + "@" + pq.peek().weightSoFar);
        }
    }
}
