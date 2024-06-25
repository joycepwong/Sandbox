package NewYearChaos;

import java.io.*;
import java.util.*;
import java.util.stream.*;
import static java.util.stream.Collectors.toList;

class Result {

    /*
     * It is New Year's Day and people are in line for the 
     * Wonderland rollercoaster ride. Each person wears a 
     * sticker indicating their initial position in the queue
     * from 1 to n. Any person can bribe the person 
     * directly in front of them to swap positions, but they 
     * still wear their original sticker. One person can bribe 
     * at most two others.
     * 
     * Determine the minimum number of bribes that took 
     * place to get to a given queue order. Print the 
     * number of bribes, or, if anyone has bribed more than 
     * two people, print "Too chaotic".
     * 
     * Example
     * 
     * q=[1, 2, 3, 5, 4, 6, 7, 8]
     * If person 5 bribes person 4, the queue will look like 
     * this: 1, 2, 3, 5, 4, 6, 7, 8. Only 1 bribe is required. 
     * Print "1".
     * 
     * q=[4, 1, 2, 3]
     * Person 4 had to bribe 3 people to get to the current 
     * position. Print "Too chaotic".
     * 
     * Function Description
     * 
     * Complete the function minimumBribes below.
     * minimumBribes has the following parameter(s):
     * int q[n]: the positions of the people after all bribes
     * 
     * Returns
     * 
     * No value is returned. Print the minimum number 
     * of bribes necessary or "Too chaotic" if someone 
     * has bribed more than 2 people.
     * 
     * Input Format
     * 
     * The first line contains an integer t, the number of test 
     * cases. 
     * Each of the next t pairs of lines are as follows:
     * - The first line contains an integer , the number of 
     * people in the queue
     * - The second line has n space-separated integers 
     * describing the final state of the queue.
     * 
     * Constraints
     * 
     * 1 is less than or equal to t which is less than or
     * equal to 10
     * 1 is less than or equal to n which is less than or 
     * equal to 100000
     *  
     * The function accepts INTEGER_ARRAY q as parameter.
     */

     public static void minimumBribes(List<Integer> q) {
    // Write your code here
        // Check if anyone bribed more than twice
        for(int i=0; i<q.size(); i++){
            if ((q.get(i).intValue() - i - 1)>2){
                System.out.println("Too chaotic");
                return;
            }
        }
        // Basically, count the number of moves to undo all bribes
        int moves = 0;
        int startingIndex = q.size()-1;
        while(startingIndex>0){
            int targetIndex = startingIndex;
            while ((targetIndex+1)!=q.get(targetIndex)){
                // Make sure bribe is being reversed instead of bribing
                // May need to reverse an earlier bribe first
                int temp = q.get(targetIndex-1);
                if(q.get(targetIndex-1)<q.get(targetIndex)){
                    q.set(targetIndex-1, q.get(targetIndex-2));
                    q.set(targetIndex-2, temp);
                    moves = moves +1;
                }
                temp = q.get(targetIndex);
                q.set(targetIndex, q.get(targetIndex-1));
                q.set(targetIndex-1, temp);
                moves = moves + 1;
                targetIndex = targetIndex - 1;
            }
            if((startingIndex+1)==q.get(startingIndex)){
                startingIndex = startingIndex - 1;
            }
        }
        System.out.println(moves);
    }
}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        int t = Integer.parseInt(bufferedReader.readLine().trim());

        IntStream.range(0, t).forEach(tItr -> {
            try {
                int n = Integer.parseInt(bufferedReader.readLine().trim());

                List<Integer> q = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                    .map(Integer::parseInt)
                    .collect(toList());

                Result.minimumBribes(q);
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        });

        bufferedReader.close();
    }
}
