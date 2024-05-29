package searches;

import graphParts.Vertex;
import graphs.MyGraph;

import java.util.LinkedList;
import java.util.Queue;

public class BreadthFirstSearch<V> extends Search<V> {

    public BreadthFirstSearch(MyGraph<V> graph, Vertex<V> source) {
        super(source);

        bfs(graph, source);
    }

    private void bfs(MyGraph<V> graph, Vertex<V> current) {
        marked.add(current);


        Queue<Vertex> queue = new LinkedList<>();
        queue.add(current);

        while (!queue.isEmpty()) {
            Vertex<V> v = queue.remove();

            for (Vertex<V> vertex : graph.adjacencyList(v)) {
                if (!marked.contains(vertex)) {
                    marked.add(vertex);
                    edgeTo.put(vertex, v);
                    queue.add(vertex);
                }
            }
        }
    }
}
