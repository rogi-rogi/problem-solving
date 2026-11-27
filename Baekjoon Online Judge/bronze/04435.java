import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        // Init
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        // Input & Solve
        final int T = Integer.parseInt(br.readLine());
        final int[] gandalf = {1, 2, 3, 3, 4, 10};
        final int[] sauron = {1, 2, 2, 2, 3, 5, 10};
        for (int idx = 1; idx <= T; ++idx) {
            String[] armyOfGandalf = br.readLine().split(" ");
            String[] armyOfSauron = br.readLine().split(" ");
            int sumOfGandalf = 0, sumOfSauron = 0;
            for (int i = 0; i < armyOfGandalf.length; ++i) {
                sumOfGandalf += gandalf[i] * Integer.parseInt(armyOfGandalf[i]);
            }
            for (int i = 0; i < armyOfSauron.length; ++i) {
                sumOfSauron += sauron[i] * Integer.parseInt(armyOfSauron[i]);
            }
            sb.append("Battle ").append(idx);
            if (sumOfGandalf > sumOfSauron)
                sb.append(": Good triumphs over Evil\n");
            else if (sumOfGandalf < sumOfSauron)
                sb.append(": Evil eradicates all trace of Good\n");
            else sb.append(": No victor on this battle field\n");
        }

        // Output
        System.out.print(sb);
    }
}
