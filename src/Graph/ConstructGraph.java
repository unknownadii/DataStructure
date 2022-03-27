package Graph;

import java.util.ArrayList;

public class ConstructGraph {
    public ArrayList<Edges>[] graph;

    public class Edges {
       public int current;
        public  int neighbour;
        public int weight;

        public Edges(int current, int neighbour, int weight) {
            this.current = current;
            this.neighbour = neighbour;
            this.weight = weight;
        }
    }

    //Assigning a new Arraylists on every nodes of array
    /*
   ArrayList<Edges>[] graph = [{},
    {},
    {},
    {},
    {},
    {}]
     */
    public ConstructGraph(int totalNodes) {
        // intilizing the graph
        graph = new ArrayList[totalNodes];
        for (int i = 0; i < totalNodes; i++) {
            graph[i] = new ArrayList<>();
        }
    }

    //Construct Weighted UnDirect-Graph
    public void constructUnDirectedGraph(int source, int destination, int weight) {
        graph[source].add(new Edges(source, destination, weight));
        graph[destination].add(new Edges(destination, source, weight));
    }

    //Construct UnDirect-Graph
    public void constructUnDirectedGraph(int source, int destination) {
        int weight = 1; // by default if weight is not given
        graph[source].add(new Edges(source, destination, weight));
        graph[destination].add(new Edges(destination, source, weight));
    }

    //Construct Weighted Directed Graph
    public void constructDirectedGraph(int source, int destination, int weight) {
        graph[source].add(new Edges(source, destination, weight));
    }

    //Construct Direct-Graph
    public void constructDirectedGraph(int source, int destination) {
        int weight = 1; // by default if weight is not given
        graph[source].add(new Edges(source, destination, weight));
    }

    //Display
    public void display() {
        for (ArrayList<Edges> list : graph) {
            for (Edges edge : list) {
                System.out.print(" Current = " + edge.current + " Neighbour = " + edge.neighbour + " Weight = " + edge.weight);
                System.out.println();
            }

        }
    }
}
