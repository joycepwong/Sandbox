package queueusingtwostacks;

import java.io.*;
import java.util.*;
import java.util.stream.*;
import static java.util.stream.Collectors.toList;
/*
 * A queue is an abstract data type that maintains the order in 
 * which elements were added to it, allowing the oldest elements 
 * to be removed from the front and new elements to be added to 
 * the rear. This is called a First-In-First-Out (FIFO) data 
 * structure because the first element added to the queue (i.e. 
 * the one that has been waiting the longest) is always the 
 * first one to be removed.
 * 
 * A basic queue has the following operations:
 * 
 * Enqueue: add a new element to the end of the queue.
 * Dequeue: remove the element from the front of the queue and return it.
 * In this challenge, you must first implement a queue using two stacks. Then process  queries, where each query is one of the following  types:
 *
 * 1: Enqueue element x into the end of the queue.
 * 2: Dequeue the element at the front of the queue.
 * 3: Print the element at the front of the queue.
 * Input Format
 * The first line contains a single integer, q, denoting the 
 * number of queries.
 * Each line i of the q subsequent lines contains a single query 
 * in the form described in the problem statement above. All 
 * three queries start with an integer denoting the query type, 
 * but only query 1 is followed by an additional space-separated 
 * value, x, denoting the value to be enqueued.
 *
 * Constraints
 *
 * It is guaranteed that a valid answer always exists for each 
 * query of type 3.
 * 
 * Output Format
 * 
 * For each query of type 3, print the value of the element at 
 * the front of the queue on a new line.
 */

class Result {

    public static void queueTaking(List<List<Integer>> queries) {
        Queue<Integer> queue = new ArrayDeque<Integer>();
        for(int i=0; i<queries.size(); i++) {
            int type = queries.get(i).get(0);
            if(type == 1){
                queue.offer(new Integer(queries.get(i).get(1)));
            } else if (type == 2) {
                queue.poll();
            } else {
                System.out.println(queue.peek());
            }
        }
    }
}

public class Solution {

    public static void main(String[] args) throws IOException {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(bufferedReader.readLine().trim());

        List<List<Integer>> queries = new ArrayList<>();

        IntStream.range(0, n).forEach(i -> {
            try {
                queries.add(
                    Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                        .map(Integer::parseInt)
                        .collect(toList())
                );
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        });

        Result.queueTaking(queries);

        bufferedReader.close();
    }
}
