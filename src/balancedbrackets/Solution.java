package balancedbrackets;

import java.io.*;
import java.util.*;
import java.util.stream.*;

class Result {

    /*
     * A bracket is considered to be any one of the following 
     * characters: (, ), {, }, [, or ].
     * Two brackets are considered to be a matched pair if the 
     * an opening bracket (i.e., (, [, or {) occurs to the left 
     * of a closing bracket (i.e., ), ], or }) of the exact same 
     * type. There are three types of matched pairs of brackets: 
     * [], {}, and ().
     * 
     * A matching pair of brackets is not balanced if the set of 
     * brackets it encloses are not matched. For example, {[(])} 
     * is not balanced because the contents in between { and } 
     * are not balanced. The pair of square brackets encloses a 
     * single, unbalanced opening bracket, (, and the pair of 
     * parentheses encloses a single, unbalanced closing square 
     * bracket, ].
     * 
     * By this logic, we say a sequence of brackets is balanced 
     * if the following conditions are met:
     * 
     * -It contains no unmatched brackets. 
     * -The subset of brackets enclosed within the confines of a 
     * matched pair of brackets is also a matched pair of 
     * brackets.
     * 
     * Given n strings of brackets, determine whether each 
     * sequence of brackets is balanced. If a string is balanced,
     * return YES. Otherwise, return NO.
     * 
     * Function Description
     * 
     * Complete the function isBalanced below.
     * 
     * isBalanced has the following parameter(s):
     * 
     * string s: a string of brackets
     * 
     * Returns
     * 
     * string: either YES or NO
     * 
     * Input Format
     * 
     * The first line contains a single integer , the number of 
     * strings.
     * Each of the next n lines contains a single string s, a 
     * sequence of brackets.
     * 
     * Constraints
     * 
     * 1 is less than or equal to n which is less than or equal
     * to 1000
     * 1 is less than |s| which is less than or equal to 1000,
     * where |s| is the length of the sequence
     * All chracters in the sequences ∈ { {, }, (, ), [, ] }.
     * 
     * Output Format
     * 
     * For each string, return YES or NO.
     */

    public static String isBalanced(String s) {
    // Write your code here
        Stack<String> stack = new Stack<String>();
        for(int i=0; i<s.length(); i++){
            // if bracket at index i is an open bracket, push on stack
            if(isOpenBracket(s.substring(i, i+1))){
                stack.push(s.substring(i, i+1));
            // if bracket at index i is a close bracket, compare it with
            // the top item on the stack to see if they match
            } else {
                if(stack.isEmpty() || 
                !areMatchingBrackets(stack.pop(), s.substring(i, i+1))){
                    return "NO";
                } 
            }
        }
        if(stack.isEmpty()){
            return "YES";
        } else {
            return "NO";
        }
    }
    
    private static boolean isOpenBracket(String b){
        if(b.equals("(") || b.equals("{") || b.equals("[")){
            return true;
        } else {
            return false;
        }
    }
    
    private static boolean areMatchingBrackets(String o, String c){
        if((o.equals("(") && c.equals(")")) || 
        (o.equals("{") && c.equals("}")) || 
        (o.equals("[") && c.equals("]"))){
            return true;
        } else {
            return false;
        }
    }

}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int t = Integer.parseInt(bufferedReader.readLine().trim());

        IntStream.range(0, t).forEach(tItr -> {
            try {
                String s = bufferedReader.readLine();

                String result = Result.isBalanced(s);

                bufferedWriter.write(result);
                bufferedWriter.newLine();
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        });

        bufferedReader.close();
        bufferedWriter.close();
    }
}
