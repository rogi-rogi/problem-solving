import java.io.*;
import java.util.*;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // Input
        br.readLine();

        // Solve
        int[] res = new int[1999];
        Arrays.setAll(res, i -> i < 999 ? 1 : 1000);

        // Output
        System.out.println(1999);
        System.out.println(Arrays.stream(res).mapToObj(String::valueOf).collect(Collectors.joining(" ")));
    }
}