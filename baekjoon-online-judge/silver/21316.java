import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // Input
        Map<Integer, List<Integer>> map = new HashMap<>();
        for (int i = 1; i <= 12; ++i) {
            map.put(i, new ArrayList<>());
        }

        for (int i = 1; i <= 12; ++i) {
            String[] input = br.readLine().split(" ");
            final int x = Integer.parseInt(input[0]);
            final int y = Integer.parseInt(input[1]);
            map.get(x).add(y);
            map.get(y).add(x);
        }

        // Solve
        for (int i = 1; i <= 12; ++i) {
            if (map.get(i).size() == 3) {
                int size = 0;
                for (Integer y : map.get(i)) {
                    size += map.get(y).size();
                }
                if (size == 6) {
                    // Output
                    System.out.println(i);
                    break;
                }
            }
        }
    }
}