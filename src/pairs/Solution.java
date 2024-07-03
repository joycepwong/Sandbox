package pairs;

import java.io.*;
import java.util.*;
import java.util.stream.*;
import static java.util.stream.Collectors.toList;


class Result {

    /*
     * Given an array of integers and a target value determine
     * the number of pairs of array elements that have a 
     * difference equal to the target value.
     * 
     * Example
     * k=1
     * arr=[1,2,3,4]
     * There are three values that differ by k=1: 2-1=1, 3-2=1,
     * and 4-3=1. Return 3
     * 
     * Functon Description
     * Complete the 'pairs' function below.
     * 
     * pairs has the following parameter(s):
     * int k: an integer, the target difference
     * int arr[n]: an array of integers
     * 
     * Returns
     * int: the number of pairs that satisfy the criterion
     * 
     * Input Format
     * The first line contains two space-separated integers
     * n and k, the size of arr and the target value
     * The second line contains n space-separate integers of
     * the array arr.
     * 
     * Constraints
     * 2 is less than or equal to n which is less than or equal
     * to 100 000
     * 0 is less than k which is less than 1 000 000 000
     * 0 is less than arr[i] which is less than (2^31 -1)
     * each integer arr[i] will be unique
     *
     */

    public static int pairs(int k, List<Integer> arr) {
    // Write your code here
        Collections.sort(arr);
        int numberOfPairs = 0;
        for(int i=0; i<(arr.size()-1); i++){
            for(int j=i+1; j<arr.size(); j++){
                if((arr.get(j)-arr.get(i))==k){
                    numberOfPairs++;
                } else if((arr.get(j)-arr.get(i))>k){
                    break;
                }
            }
        }
        return numberOfPairs;
    }

}
public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String[] firstMultipleInput = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

        int n = Integer.parseInt(firstMultipleInput[0]);

        int k = Integer.parseInt(firstMultipleInput[1]);

        List<Integer> arr = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
            .map(Integer::parseInt)
            .collect(toList());

        int result = Result.pairs(k, arr);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}
