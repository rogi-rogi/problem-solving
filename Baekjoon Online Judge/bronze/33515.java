import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // Input
        String[] input = br.readLine().split(" ");
        final int T1 = Integer.parseInt(input[0]);
        final int T2 = Integer.parseInt(input[1]);

        // Solve & Output
        System.out.println(Math.min(T1, T2));
    }
}