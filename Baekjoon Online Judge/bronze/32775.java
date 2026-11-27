import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // Input
        final int S = Integer.parseInt(br.readLine());
        final int F = Integer.parseInt(br.readLine());

        // Solve
        if (S <= F) {
            // Output
            System.out.println("high speed rail");
        } else {
            System.out.println("flight");
        }
    }
}