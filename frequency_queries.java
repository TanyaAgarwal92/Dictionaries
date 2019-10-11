/*
[HackerRank] : You are given  queries. Each query is of the form two integers described below:
1 x : Insert x in your data structure.
2 y : Delete one occurence of y from your data structure, if present.
3 z : Check if any integer is present whose frequency is exactly . If yes, print 1 else 0.
Return an integer array consisting of all the outputs of queries of type .
*/

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

public class Solution {

    // Complete the freqQuery function below.
    static List<Integer> freqQuery(int[][] queries) {
        List<Integer> result = new ArrayList<>();
        Map<Integer, Integer> numberToCount = new HashMap<>();
        Map<Integer, Set<Integer>> countToNumbers = new HashMap<>();
        for (int i = 0; i < queries.length; i++) {
            int operation = queries[i][0];
            int operand = queries[i][1];

            if (operation == 1) {
                int prevCount = numberToCount.getOrDefault(operand, 0);
                int currCount = prevCount + 1;

                numberToCount.put(operand, currCount);

                if (prevCount != 0) {
                    countToNumbers.get(prevCount).remove(operand);
                }

                if (!countToNumbers.containsKey(currCount)) {
                    countToNumbers.put(currCount, new HashSet<>());
                }
                countToNumbers.get(currCount).add(operand);
            } else if (operation == 2) {
                if (numberToCount.containsKey(operand)) {
                    int prevCount = numberToCount.get(operand);
                    int currCount = prevCount - 1;

                    if (currCount == 0) {
                        numberToCount.remove(operand);
                    } else {
                        numberToCount.put(operand, currCount);
                    }

                    countToNumbers.get(prevCount).remove(operand);

                    if (currCount != 0) {
                        countToNumbers.get(currCount).add(operand);
                    }
                }
            } else if (operation == 3) {
                result.add(countToNumbers.getOrDefault(operand, Collections.emptySet()).isEmpty() ? 0 : 1);
            }
        }
        return result;     
    }
    public static void main(String[] args) throws IOException {
        try (BufferedReader bufferedReader = new BufferedReader(
                    new InputStreamReader(System.in))) {
            
            int q = Integer.parseInt(bufferedReader.readLine().trim());
            int[][] queries = new int[q][2];
           
            for (int i = 0; i < q; i++) {
                String[] query = bufferedReader.readLine().split(" ");
                queries[i][0] = Integer.parseInt(query[0]);
                queries[i][1] = Integer.parseInt(query[1]);
            }
          
            List<Integer> ans = freqQuery(queries);
          
            try (BufferedWriter bufferedWriter = new BufferedWriter(
                        new FileWriter(System.getenv("OUTPUT_PATH")))) {
            
                bufferedWriter.write(ans.stream().map(Object::toString)
                            .collect(joining("\n")) + "\n");
            }
        }
    }
}
