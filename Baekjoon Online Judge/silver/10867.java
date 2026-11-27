import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        // Init
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
      
        // Input
        final int N = Integer.parseInt(br.readLine());

        // Solve
        HashSet<Integer> set = new HashSet<>();
        for (Integer num : Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray()) {
            set.add(num);
        }
        set.stream().sorted().forEach((e)->sb.append(e).append(" "));

        // Output
        System.out.println(sb);
    }
}
