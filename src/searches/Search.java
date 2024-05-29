package searches;

import graphParts.Vertex;

import java.util.*;

public class Search<V> {
    protected Set<Vertex<V>> marked;
    protected Map<Vertex<V>, Vertex<V>> edgeTo;
    protected final Vertex<V> source;

    public Search(Vertex source) {
        this.source = source;
        marked = new HashSet<>();
        edgeTo = new HashMap<>();
    }

    public boolean hasPathTo(Vertex v) {
        return marked.contains(v);
    }

    public Iterable<Vertex> pathTo(String v) {
        Vertex vert = new Vertex(v);
        if (!hasPathTo(vert)) return null;

        LinkedList<Vertex> ls = new LinkedList<>();
        for (Vertex i = vert; i != source; i = edgeTo.get(i)) {
            ls.push(i); // inverted adding
        }

        ls.push(source);

        return ls;
    }
}
