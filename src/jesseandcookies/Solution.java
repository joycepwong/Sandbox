package jesseandcookies;

import java.io.*;
import java.util.*;
import java.util.stream.*;
import static java.util.stream.Collectors.toList;

class Result {

    /*
     * Jesse loves cookies and wants the sweetness of some 
     * cookies to be greater than value k. To do this, two 
     * cookies with the least sweetness are repeatedly mixed. 
     * This creates a special combined cookie with:
     * sweetness = (1x Least sweet cookie + 2 x  2nd least 
     * sweet cookie).
     * 
     * This occurs until all the cookies have a sweetness that
     * is >=k.
     *
     * Given the sweetness of a number of cookies, determine 
     * the minimum number of operations required. If it is 
     * not possible, return -1.
     *
     * Example
     * k=9
     * A=[2,7,3,6,4,6]
     * The smallest values are 2,3.
     * Remove them then return 2+2x3=8 to the array. Now 
     * A=[8,7,6,4,6].
     * Remove 4,6 and return 4+6x2=16 to the array. Now 
     * A=[16,8,7,6].
     * Remove 6,7 return 6+2x7=20 and A=[20,16,8,7].
     * Finally, remove 8,7 and return 7+2x8=23 to A. Now 
     * A=[23,20,16].
     * All values are >=k=9 so the process stops after 4
     * iterations. Return 4.
     *
     * Function Description
     * Complete the cookies function in the editor below.
     * cookies has the following parameters:
     * int k: the threshold value
     * int A[n]: an array of sweetness values
     *
     * Returns
     * int: the number of iterations required or -1
     *
     * Input Format
     * 
     * The first line has two space-separated integers,
     * n and k, the size of A[] and the minimum required 
     * sweetness respectively.
     * The next line contains n space-separated integers, A[i].
     * 
     * Constraints
     * 1<=n<=1 000 000
     * 0<=k<=1 000 000 000
     * 0<=A[i]<=1 000 000
     *
     * Sample Input
     * STDIN               Function
     * -----               --------
     * 6 7                 A[] size n = 6, k = 7
     * 1 2 3 9 10 12       A = [1, 2, 3, 9, 10, 12]  
     * 
     * Sample Output
     * 2
     */

     public static int cookies(int k, List<Integer> A) {
        // Write your code here
            if(k==0){
                return 0;
            } 
            if(A.size()==1){
                if(A.get(0)<k){
                    return -1;
                } else {
                    return 0;
                }
            } 
            // There are 2 or more cookies
            PriorityQueue<Integer> q = new PriorityQueue<>();
            for(int i=0; i<A.size(); i++){
                q.offer(A.get(i));
            }
            int counter = 0;
            if(q.peek()>=k){
                return counter;
            } 
            while(q.size()>1 && q.peek()<k){
                int lowest = q.poll();
                int nextLowest = q.poll();
                int newCookie = lowest+(2*nextLowest);
                counter++;
                q.offer(newCookie);
            }
            if(q.size()==1 && q.peek()<k){
                return -1;
            } else {
                return counter;
            }
        }

}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String[] firstMultipleInput = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

        int n = Integer.parseInt(firstMultipleInput[0]);

        int k = Integer.parseInt(firstMultipleInput[1]);

        List<Integer> A = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
            .map(Integer::parseInt)
            .collect(toList());

        int result = Result.cookies(k, A);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}