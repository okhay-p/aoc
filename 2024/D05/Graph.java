import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

public class Graph {
    private Map<Integer, Map<Integer, Integer>> adjacencyMap;

    public Graph() {
        adjacencyMap = new HashMap<>();
    }

    // Add a vertex
    public void addVertex(int vertex) {
        adjacencyMap.putIfAbsent(vertex, new HashMap<>());
    }

    // Add an edge
    public void addEdge(int source, int destination) {
        adjacencyMap.putIfAbsent(source, new HashMap<>());
        adjacencyMap.putIfAbsent(destination, new HashMap<>());

        adjacencyMap.get(source).put(destination, 1);
    }

    public boolean checkEdge(int source, int destination) {
      return adjacencyMap.get(source).get(destination) != null;
    }


    // Print adjacency map
    public void printGraph() {
        for (Map.Entry<Integer, Map<Integer, Integer>> entry : adjacencyMap.entrySet()) {
            System.out.println("Vertex " + entry.getKey() + " -> " + entry.getValue());
        }
    }
}
