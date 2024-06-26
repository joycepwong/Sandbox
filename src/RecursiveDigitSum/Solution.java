package recursivedigitsum;

import java.io.*;
import java.math.*;

class Result {

    /*
     * Complete the function superDigit below.
     * 
     * We define super digit of an integer  using the following rules:
     * 
     * Given an integer, we need to find the super digit of the integer.
     * If  has only  digit, then its super digit is .
     * Otherwise, the super digit of  is equal to the super digit of the sum of the digits of .
     * For example, the super digit of  will be calculated as:
     * 
     * super_digit(9875)   	9+8+7+5 = 29 
     * super_digit(29) 	    2 + 9 = 11
     * super_digit(11)		1 + 1 = 2
     * super_digit(2)		= 2 
     * 
     * It must return the calculated super digit as an integer.
     * superDigit has the following parameter(s):
     * string n: a string representation of an integer
     * int k: the times to concatenate  to make 
     * 
     * Returns
     * int: the super digit of n repeated k times
     * 
     * Input Format
     * The first line contains two space separated integers, n and k.
     * 
     * Constraints
     * 
     * 1 less than or equal to n which is less than 10 to the exponent
     * 100000
     * 1 less than or equal to k which is less than or equal to 100000
     * 
     */

     public static int superDigit(String n, int k) {
        // Write your code here
            if(k==1){
                if(n.length()==1){
                    return Integer.parseInt(n);
                } else {
                    return superDigit(Long.toString(parseAdd(n)), 1);
                }
            } else {
                return superDigit(Long.toString(parseAdd(n)*k), 1);
            }
        }
        
        public static long parseAdd(String numberString){
            BigInteger sum = new BigInteger("0");
            for(int i=0; i<numberString.length(); i++){
                sum = sum.add(new BigInteger(numberString.substring(i, i+1)));
            }
            return sum.longValue();
        }

}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String[] firstMultipleInput = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

        String n = firstMultipleInput[0];

        int k = Integer.parseInt(firstMultipleInput[1]);

        int result = Result.superDigit(n, k);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}
