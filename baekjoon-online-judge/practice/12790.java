import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        // Input
        int T = Integer.parseInt(br.readLine());

        // Solve
        while (T-- > 0) {
            int[] input = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            int HP = input[0] + input[4];
            int MP = input[1] + input[5];
            int POWER = input[2] + input[6];
            int SHIELD = input[3] + input[7];

            // Solve
            if (HP < 1)
                HP = 1;
            if (MP < 1)
                MP = 1;
            if (POWER < 0)
                POWER = 0;
            sb.append(HP + 5 * MP + 2 * POWER + 2 * SHIELD).append("\n");
        }

        // Output
        System.out.println(sb);
    }
}