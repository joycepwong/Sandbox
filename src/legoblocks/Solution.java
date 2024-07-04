package legoblocks;

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
     * You have an infinite number of 4 types of lego blocks of 
     * sizes given as (depth x height x width):
     * 
     * d	h	w
     * 1	1	1
     * 1	1	2
     * 1	1	3
     * 1	1	4
     * Using these blocks, you want to make a wall of height n 
     * and width m. Features of the wall are:
     * 
     * - The wall should not have any holes in it.
     * - The wall you build should be one solid structure, so there 
     * should not be a straight vertical break across all rows of 
     * bricks.
     * - The bricks must be laid horizontally.
     * 
     * How many ways can the wall be built?
     * 
     * Example
     * n=2
     * m=3
     * The height is 2 and the width is 3. Here are some 
     * configurations (where the numbers represent the widths of
     * each block):
     * 
     * 9 Good layouts: 1, 2 over 3; 2, 1 over 3; 2, 1 over 1, 2; 
     * 1, 2 over 2, 1; 3 over 3; 1, 1, 1 over 3; 3 over 1, 2; 3
     * over 2, 1; 3 over 1, 1, 1
     * 
     * 6 Bad Layouts: 1, 1, 1 over 1, 2; 1, 2 over 1, 2; 1, 1, 1
     * over 1, 1, 1; 1, 2 over 1, 1, 1; 1, 1, 1 over 2, 1; 2, 1
     * over 2, 1
     * 
     * There are 9 valid (good) permutations and 15 (good and 
     * bad) permutations in all.
     * 
     * Function Description
     * 
     * Complete the legoBlocks function in the editor below.
     * legoBlocks has the following parameter(s):
     * int n: the height of the wall
     * int m: the width of the wall
     * 
     * Returns
     * - int: the number of valid wall formations modulo 
     * (10^9+7)
     * 
     * Input Format
     * 
     * The first line contains the number of test cases t.
     * Each of the next t lines contains two space-separated 
     * integers n and m.
     * 
     * Constraints
     * 
     * 1<=t<=100
     * 1<=n,m<=1000
     * 
     * Sample Input
     * 
     * STDIN   Function
     * -----   --------
     * 4       t = 4
     * 2 2     n = 2, m = 2
     * 3 2     n = 3, m = 2
     * 2 3     n = 2, m = 3
     * 4 4     n = 4, m = 4
     * 
     * Sample Output
     * 
     * 3  
     * 7 
     * 9
     * 3375
     */

    public static int legoBlocks(int n, int m) {
    // Write your code here

    }

}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int t = Integer.parseInt(bufferedReader.readLine().trim());

        IntStream.range(0, t).forEach(tItr -> {
            try {
                String[] firstMultipleInput = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

                int n = Integer.parseInt(firstMultipleInput[0]);

                int m = Integer.parseInt(firstMultipleInput[1]);

                int result = Result.legoBlocks(n, m);

                bufferedWriter.write(String.valueOf(result));
                bufferedWriter.newLine();
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        });

        bufferedReader.close();
        bufferedWriter.close();
    }
}
