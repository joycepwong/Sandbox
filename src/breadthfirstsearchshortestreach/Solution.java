package breadthfirstsearchshortestreach;

import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.function.*;
import java.util.regex.*;
import java.util.stream.*;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

class Result {

    /*
     * Consider an undirected graph where each edge weighs 6 
     * units. Each of the nodes is labeled consecutively from 1 to
     * n.
     * You will be given a number of queries. For each query, you
     * will be given a list of edges describing an undirected 
     * graph. After you create a representation of the graph, you
     * must determine and report the shortest distance to each of
     * the other nodes from a given starting position using the
     * breadth-first search algorithm (BFS). Return an array of
     * distances from the start node in node number order. If a
     * node is unreachable, return -1 for that node.
     * 
     * Example
     * The following graph is based on the listed inputs:
     *     2
     * 1 <
     *     3 - 4
     * 5
     * 
     * n=5 // number of nodes
     * m=3 // number of edges
     * edges = [1,2],[1,3],[3,4]
     * s=1 // starting node
     * 
     * All distances are from the start node 1. Outputs are
     * calculated for distances to nodes 2 through 5: [6, 6, 12, -1].
     * Each edge is 6 units and the unreachable node 5 has the 
     * required return distance of -1.
     * 
     * Function Description
     * Complete the bfs function in the editor below. If a node is
     * unreachable, its distance is -1.
     * bfs has the following parameters:
     * int n: the number of nodes
     * int m: the number of edges
     * int edges[m][2]: start and end nodes for edges
     * int s: the node to start traversals from
     * 
     * Returns
     * int[n-1]: the distances to nodes in increasing node
     * number order, not including the start node (-1 if a node is
     * not reachable)
     * 
     * Input Format
     * The first line contains an integer q, the number of queries.
     * Each of the following q sets of lines has the following
     * format:
     * -The first line contains two space-separate integers n and m,
     * the number of nodes and edges in the graph.
     * -Each line i of the m susbsequent lines contains two space-
     * separated integers, u and v, that describe an edge between
     * nodes u and v.
     * -The last line contains a single intger, s, the node number 
     * to start from
     * 
     * Constraints
     * 1<=q<=10
     * 2<=n<=1000
     * 1<=m<=(n*(n-1))/2
     * 1<=u,v,s<=n
     * 
     * Sample Input
     * 2
     * 4 2
     * 1 2
     * 1 3
     * 1
     * 3 1
     * 2 3
     * 2
     * 
     * Sample Output
     * 6 6 -1
     * -1 6
     * 
     */

    public static List<Integer> bfs(int n, int m, List<List<Integer>> edges, int s) {
    // Write your code here

    }

}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int q = Integer.parseInt(bufferedReader.readLine().trim());

        IntStream.range(0, q).forEach(qItr -> {
            try {
                String[] firstMultipleInput = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

                int n = Integer.parseInt(firstMultipleInput[0]);

                int m = Integer.parseInt(firstMultipleInput[1]);

                List<List<Integer>> edges = new ArrayList<>();

                IntStream.range(0, m).forEach(i -> {
                    try {
                        edges.add(
                            Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                                .map(Integer::parseInt)
                                .collect(toList())
                        );
                    } catch (IOException ex) {
                        throw new RuntimeException(ex);
                    }
                });

                int s = Integer.parseInt(bufferedReader.readLine().trim());

                List<Integer> result = Result.bfs(n, m, edges, s);

                bufferedWriter.write(
                    result.stream()
                        .map(Object::toString)
                        .collect(joining(" "))
                    + "\n"
                );
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        });

        bufferedReader.close();
        bufferedWriter.close();
    }
}
