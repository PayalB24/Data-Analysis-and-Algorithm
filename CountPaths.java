import java.util.*;

public class CountPaths {
    public static void addEdge(Map<Character, List<Character>> graph, char from, char to) {
        graph.putIfAbsent(from, new ArrayList<>());
        graph.get(from).add(to);
    }
    public static int countPaths(Map<Character, List<Character>> graph, char source, char destination) {
        int[] count = {0};
        Set<Character> visited = new HashSet<>();
        dfs(graph, source, destination, visited, count);
        return count[0];
    }
    private static void dfs(Map<Character, List<Character>> graph, char current, char destination, Set<Character> visited, int[] count) {
        if (current == destination) {
            count[0]++;
            return;
        }
        visited.add(current);
        for (char neighbor : graph.getOrDefault(current, new ArrayList<>())) {
            if (!visited.contains(neighbor)) {
                dfs(graph, neighbor, destination, visited, count);
            }
        }
        visited.remove(current);
    }

    public static void main(String[] args) {
        Map<Character, List<Character>> graph = new HashMap<>();
        addEdge(graph, 'A', 'B');
        addEdge(graph, 'A', 'C');
        addEdge(graph, 'B', 'C');
        addEdge(graph, 'B', 'E');
        addEdge(graph, 'C', 'D');
        addEdge(graph, 'D', 'B');
        addEdge(graph, 'D', 'E');
        char source = 'A';
        char destination = 'E';
        int totalPaths = countPaths(graph, source, destination);

        System.out.println("Total number of paths from " + source + " to " + destination + " is: " + totalPaths);
    }
}
