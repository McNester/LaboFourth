import graphParts.Vertex;
import graphs.MyGraph;
import graphs.WeightedGraph;
import searches.BreadthFirstSearch;
import searches.DepthFirstSearch;
import searches.DijkstraSearch;
import searches.Search;

public class Main {

    public static void main(String[] args) {
        WeightedGraph<String> weightedGraph = new WeightedGraph<>(true);
        fillWithWeights(weightedGraph);

        System.out.println("Dijkstra:");
        Search<String> djk = new DijkstraSearch(weightedGraph, new Vertex("Almaty"));
        outputPath(djk, "Kyzylorda");


        System.out.println("--------------------------------");

        MyGraph<String> graph = new MyGraph<>(true);
        fillWithoutWeights(graph);

        System.out.println("DFS:");
        Search<String> dfs = new DepthFirstSearch(graph, new Vertex("Almaty"));
        outputPath(dfs, "Kyzylorda");

        System.out.println("--------------------------------");

        System.out.println("BFS:");
        Search<String> bfs = new BreadthFirstSearch(graph, new Vertex( "Almaty"));
        outputPath(bfs, "Kyzylorda");
    }

    public static void fillWithoutWeights(MyGraph<String> graph) {
        graph.addEdge(new Vertex("Almaty"), new Vertex("Astana"));
        graph.addEdge(new Vertex("Shymkent"),new Vertex("Atyrau"));
        graph.addEdge(new Vertex("Atyrau"), new Vertex("Astana"));
        graph.addEdge(new Vertex("Almaty"), new Vertex("Shymkent"));
        graph.addEdge(new Vertex("Shymkent"), new Vertex("Astana"));
        graph.addEdge(new Vertex("Astana"), new Vertex("Kostanay"));
        graph.addEdge(new Vertex("Shymkent"), new Vertex("Kyzylorda"));
    }

    public static void fillWithWeights(WeightedGraph<String> graph) {
        graph.addEdge("Almaty", "Astana", 2.1);
        graph.addEdge("Shymkent", "Atyrau", 7.8);
        graph.addEdge("Atyrau", "Astana", 7.1);
        graph.addEdge("Almaty", "Shymkent", 7.2);
        graph.addEdge("Shymkent", "Astana", 3.9);
        graph.addEdge("Astana", "Kostanay", 3.5);
        graph.addEdge("Shymkent", "Kyzylorda", 5.4);
    }

    public static void outputPath(Search<String> search, String key) {
        for (Vertex v : search.pathTo(key)) {
            System.out.print(v + " -> ");
        }

        System.out.println();
    }
}
