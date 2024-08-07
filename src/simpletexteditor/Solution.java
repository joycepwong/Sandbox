package simpletexteditor;

import java.io.*;
import java.util.*;

/*
 * Implement a simple text editor. The editor initially contains 
 * an empty string, . Perform Q operations of the following 4 
 * types:
 * 
 * append(W) - Append string W to the end of S.
 * delete(k) - Delete the last k characters of S.
 * print(k) - Print the kth character of S.
 * undo() - Undo the last (not previously undone) operation of 
 * type 1 or 2, reverting S to the state it was in prior to that 
 * operation.
 * 
 * Example
 * S = 'abcde'
 * ops = ['1 fg', '3 6', '2 5', '4', '3 7', '4', '3 4']
 * 
 * operation
 * index   S       ops[index]  explanation
 * -----   ------  ----------  -----------
 * 0       abcde   1 fg        append fg
 * 1       abcdefg 3 6         print the 6th letter - f
 * 2       abcdefg 2 5         delete the last 5 letters
 * 3       ab      4           undo the last operation, index 2
 * 4       abcdefg 3 7         print the 7th characgter - g
 * 5       abcdefg 4           undo the last operation, index 0
 * 6       abcde   3 4         print the 4th character - d
 * 
 * The results should be printed as:
 * 
 * f
 * g
 * d
 * 
 * Input Format
 * 
 * The first line contains an integer, Q, denoting the number of 
 * operations.
 * Each line i of the Q subsequent lines (where 0<=i<Q) defines 
 * an operation to be performed. Each operation starts with a 
 * single integer, t (where t is an element of {1,2,3,4}), 
 * denoting a type of operation as defined in the Problem 
 * Statement above. If the operation requires an argument, t is 
 * followed by its space-separated argument. For example, if t=1 
 * and W="abcd", line i will be 1 abcd.
 * 
 * Constraints
 * 
 * 1<=Q<=1 000 000
 * 1<=k<=|S|
 * The sum of the lengths of all W in the input <= 1 000 000.
 * The sum of k over all delete operations <= 2 000 000.
 * All input characters are lowercase English letters.
 * It is guaranteed that the sequence of operations given as 
 * input is possible to perform.
 * 
 * Output Format
 * 
 * Each operation of type 3 must print the kth character on a 
 * new line.
 * 
 * Sample Input
 * 8
 * 1 abc
 * 3 3
 * 2 3
 * 1 xy
 * 3 2
 * 4
 * 4
 * 3 1
 * 
 * Sample Output
 * c
 * y
 * a
 */
class Result {

    public static void textEditorTaking(List<String[]> operations) throws IOException {
        String s = "";
        Stack<String[]> undoStack = new Stack<String[]>();
        for(int i=0; i<operations.size(); i++) {
            int type = Integer.parseInt(operations.get(i)[0]);
            if(type == 1){
                String strToAppend = operations.get(i)[1];
                s = s+strToAppend;
                String[] oppositeOperation = new String[2];
                oppositeOperation[0] = "2";
                oppositeOperation[1] = new Integer(strToAppend.length()).toString();
                undoStack.push(oppositeOperation);
            } else if (type == 2) {
                String[] oppositeOperation = new String[2];
                oppositeOperation[0] = "1";
                oppositeOperation[1] = s.substring(s.length()-Integer.parseInt(operations.get(i)[1]),s.length());
                undoStack.push(oppositeOperation);
                s = s.substring(0, s.length()-Integer.parseInt(operations.get(i)[1]));
            } else if (type == 3) {
                int ordinal = Integer.parseInt(operations.get(i)[1]);
                System.out.println(s.substring(ordinal-1, ordinal));
            } else {
                String[] undoOperation = undoStack.pop();
                int undoType = Integer.parseInt(undoOperation[0]);
                if(undoType == 1){
                    s = s+undoOperation[1];
                } else {
                    s = s.substring(0, s.length()-Integer.parseInt(undoOperation[1]));
                }
            }
        }
    }
}

public class Solution {

    public static void main(String[] args) throws IOException {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(bufferedReader.readLine().trim());

        List<String[]> operations = new ArrayList<>();
        
        try {
            for(int i=0; i<n; i++){
                String[] anOperation = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");
                operations.add(anOperation);
            }
        } catch (IOException ex) {
                throw new RuntimeException(ex);
        }
        
        Result.textEditorTaking(operations);

        bufferedReader.close();
    }
}
