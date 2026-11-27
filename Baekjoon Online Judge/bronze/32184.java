import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // Input
        String[] input = br.readLine().split(" ");
        final int A = Integer.parseInt(input[0]);
        final int B = Integer.parseInt(input[1]);

        // Solve & Output
        if (A % 2 == 0 && B % 2 == 1) {
            System.out.println((B - A) / 2 + 2);
        } else {
            System.out.println((B - A) / 2 + 1);
        }
    }
}