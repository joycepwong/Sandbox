package TruckTour;

import java.io.*;
import java.util.*;
import java.util.stream.*;
import static java.util.stream.Collectors.toList;

class Result {

    /*
     * Suppose there is a circle. There are N petrol pumps
     * on that circle. Petrol pumps are numbered 0 to (N-1) 
     * (both inclusive). You have two pieces of
     * information corresponding to each of the petrol
     * pumps: (1) the amount of petrol that particular
     * petrol pump will give, and (2) the distance that
     * petrol pump to the next petrol pump.
     * Initially, you have a tank of infinite capacity
     * carrying no petrol. You can start the tour at any
     * of the petrol pumps. Calculate the first point
     * from wheter the truck will be able to complete the
     * circle. Consider that the truck will stop at each of
     * the petrol pumps. The truck will move one kilometer
     * for each litre of the petrol.
     * 
     * Input Format
     * The first line will contain the value of N.
     * The next N lines will contain a pair of integers
     * each, i.e. the amount of petrol that petrol pump will
     * give and the distance between that petrol pump and the
     * next petrol pump.
     * 
     * Constraints:
     * 1 is less than or equal to N which is less than or 
     * equal to 100000
     * 1 is less than or equal to both the amount of petrol 
     * and the distance which are less than or equal to
     * 1 000 000 000
     * 
     * Output Format
     * An integer which will be the smallest index of the
     * petrol pump from which we can start the tour.
     * 
     * Complete the 'truckTour' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts 2D_INTEGER_ARRAY petrolpumps as parameter.
     */

    public static int truckTour(List<List<Integer>> petrolpumps) {
    // Write your code here
        int lowestIndex = 0;
        for(int i=0; i<petrolpumps.size(); i++){
            int pumpCounter = 0;
            int currentPump = i;
            boolean outOfGas = false;
            int balance = 0;
            while(pumpCounter < petrolpumps.size()){
                balance = balance + petrolpumps.get(currentPump).get(0) - petrolpumps.get(currentPump).get(1); 
                pumpCounter = pumpCounter + 1;
                if(balance<0){
                    outOfGas = true;
                    break;
                }
                currentPump = currentPump+1;
                if(currentPump>(petrolpumps.size()-1)){
                    currentPump = 0;
                }
            }
            if(!outOfGas){
                return i;
            }
        }
        return lowestIndex;
    }
}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int n = Integer.parseInt(bufferedReader.readLine().trim());

        List<List<Integer>> petrolpumps = new ArrayList<>();

        IntStream.range(0, n).forEach(i -> {
            try {
                petrolpumps.add(
                    Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                        .map(Integer::parseInt)
                        .collect(toList())
                );
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        });

        int result = Result.truckTour(petrolpumps);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}
