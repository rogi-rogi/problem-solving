import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // Input
        final int N = Integer.parseInt(br.readLine());
        int[] A = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        // Solve
        Arrays.sort(A);

        int minEven = Integer.MAX_VALUE, minOdd = Integer.MAX_VALUE;
        Integer prevEven = null, prevOdd = null;
        for (int a : A) {
            if (a % 2 == 0) {
                if (prevEven != null) {
                    minEven = Math.min(minEven, a - prevEven);
                }
                if (prevOdd != null) {
                    minOdd = Math.min(minOdd, a - prevOdd);
                }
                prevEven = a;
            } else {
                if (prevOdd != null) {
                    minEven = Math.min(minEven, a - prevOdd);
                }
                if (prevEven != null) {
                    minOdd = Math.min(minOdd, a - prevEven);
                }
                prevOdd = a;
            }
        }


        // Output
        if (minOdd == Integer.MAX_VALUE) {
            minOdd = -1;
        }
        if (minEven == Integer.MAX_VALUE) {
            minEven = -1;
        }
        System.out.println(minEven + " " + minOdd);
    }
}