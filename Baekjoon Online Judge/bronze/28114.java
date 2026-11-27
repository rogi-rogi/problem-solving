import java.io.*;
import java.util.*;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // Input
        String[][] info = new String[3][];
        for (int i = 0; i < 3; ++i) {
            info[i] = br.readLine().split(" ");
        }

        // Solve
        Arrays.sort(info, (o1, o2) -> Integer.compare(Integer.parseInt(o2[0]), Integer.parseInt(o1[0])));
        String res1 = Arrays.stream(
                new String[] {
                        info[0][1].substring(2, 4),
                        info[1][1].substring(2, 4),
                        info[2][1].substring(2, 4)
                }
        ).sorted().collect(Collectors.joining());
        String res2 = "" + info[0][2].charAt(0) + info[1][2].charAt(0) + info[2][2].charAt(0);

        // Output
        System.out.println(res1);
        System.out.println(res2);
    }
}